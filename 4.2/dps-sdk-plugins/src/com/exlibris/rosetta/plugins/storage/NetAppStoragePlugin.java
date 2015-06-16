package com.exlibris.dps.repository.plugin.storage.netapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;

import com.exlibris.core.sdk.storage.containers.StoredEntityMetaData;
import com.exlibris.core.sdk.storage.handler.AbstractStorageHandler;
import com.exlibris.core.sdk.strings.StringUtils;
import com.exlibris.digitool.common.dnx.DnxDocument;
import com.exlibris.digitool.common.dnx.DnxDocumentFactory;
import com.exlibris.digitool.common.storage.Fixity;
import com.exlibris.digitool.infrastructure.utils.Checksummer;
import com.exlibris.dps.repository.plugin.storage.netapp.client.CDMIConnector;
import com.exlibris.dps.repository.plugin.storage.netapp.client.NetAppClient;

public class NetAppStoragePlugin extends AbstractStorageHandler {

	private NetAppClient netAppClient = null;

	@Override
	public boolean deleteEntity(String storedEntityIdentifier)
			throws IOException {
		CDMIConnector connector = new CDMIConnector();
		try {
			return connector.deleteObject(netAppClient, storedEntityIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getFullFilePath(String storedEntityIdentifier) {
		CDMIConnector connector = new CDMIConnector();
		return connector.getCDMIObjectURIAsString(netAppClient, storedEntityIdentifier);
	}

	/*
	 * (non-Javadoc)
	 * @see com.exlibris.digitool.common.storage.StoragePlugin#retrieveEntity(java.lang.String)
	 *
	 * If range support is needed:
	 *
	 * Specific ranges of the value of a data object may be accessed by specifying a byte range after the value field name.
	 * Thus, the following URI returns the first thousand bytes in the value field:
	 * http://cloud.example.com/dataobject?value:0-999
	 *
	 */
	@Override
	public InputStream retrieveEntity(String storedEntityIdentifier)
			throws IOException {
		CDMIConnector connector = new CDMIConnector();
		try {
			return connector.getObject(netAppClient, storedEntityIdentifier);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	@Override
	public String storeEntity(InputStream is,
			StoredEntityMetaData storedEntityMetadata) throws IOException {
		CDMIConnector connector = new CDMIConnector();
		try {
			return connector.putObject(netAppClient, storedEntityMetadata, is);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.exlibris.digitool.common.storage.StoragePlugin#checkFixity(java.util.List, java.lang.String)
	 *
	 * From LDS example:
	 * {"metadata":{"a":"A","ab":"AB","b":"B","cdmi_atime":"2012-07-10T02:18:11.441985Z","cdmi_ctime":"2012-07-10T02:18:11.441985Z","cdmi_hash":"185F8DB32271FE25F561A6FC938B2E264306EC304EDA518007D1764826381969","cdmi_size":"5","cdmi_value_hash_provided":"SHA256"}}
	 *
	 */
	@Override
	public boolean checkFixity(List<Fixity> fixities,
			String storedEntityIdentifier) throws Exception {
		CDMIConnector connector = new CDMIConnector();
		boolean result = true;
		try {
			if(fixities != null) {
				HashMap<String, String> metadata = connector.getObjectMetadata(netAppClient, storedEntityIdentifier);
				String algorithm = metadata.get("cdmi_value_hash_provided");
				String fixityValue = metadata.get("cdmi_hash");
				if(algorithm != null && fixityValue != null){
					for (Fixity currentFixity : fixities) {
						String currentAlgorithm = currentFixity.getAlgorithm();
						boolean sha1Equality = "SHA1".equalsIgnoreCase(currentAlgorithm) && "SHA-1".equalsIgnoreCase(algorithm);
						if(currentAlgorithm.equalsIgnoreCase(algorithm) || sha1Equality) {
							if(!fixityValue.equalsIgnoreCase(currentFixity.getValue())) {
								result = false;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getLocalFilePath(String storedEntityIdentifier) {
		String newFilePath = getTempStorageDirectory() + storedEntityIdentifier;
		File checkExists = new File(newFilePath);
		if(! checkExists.exists()){
			CDMIConnector connector = new CDMIConnector();
			try {
				InputStream object = connector.getObject(netAppClient, storedEntityIdentifier);
				copyInputStreamToFile(object, new File(newFilePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return newFilePath;
	}

	/**
	 *  This method is called from the PluginLocator-PluginInvokationHandler.
	 * @param params
	 */
	public void init(Map<String, String> params) {
		super.init(params);
		netAppClient = new NetAppClient();
		if(!StringUtils.isEmptyString(params.get("container_name"))){
			netAppClient.setContainerName(params.get("container_name").trim());
		}
		if(!StringUtils.isEmptyString(params.get("protocol"))){
			netAppClient.setProtocol(params.get("protocol").trim());
		}
		if(!StringUtils.isEmptyString(params.get("host"))){
			netAppClient.setHost(params.get("host").trim());
		}
		if(!StringUtils.isEmptyString(params.get("port"))){
			netAppClient.setPort(Integer.parseInt(params.get("port").trim()));
		}
		if(!StringUtils.isEmptyString(params.get("ingest_port"))){
			netAppClient.setIngestPort(Integer.parseInt(params.get("ingest_port").trim()));
		}
		if(!StringUtils.isEmptyString(params.get("username"))){
			netAppClient.setUsername(params.get("username").trim());
		}
		if(!StringUtils.isEmptyString(params.get("password"))){
			netAppClient.setPassword(params.get("password").trim());
		}
	}

	@Override
	public byte[] retrieveEntityByRange(String storedEntityIdentifier,
			long start, long end) throws Exception {
		CDMIConnector connector = new CDMIConnector();
		try {
			byte[] bytes = null;
			InputStream objectByRange = connector.getObjectByRange(netAppClient, storedEntityIdentifier, start, end);
			if (objectByRange != null) {
				try {
					bytes = IOUtils.toByteArray(objectByRange);
				} catch (Exception e) {
					System.err
							.println("Exception thrown while copying InputStream to byte array");
					e.printStackTrace();
				} finally {
					objectByRange.close();
				}
			}
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	public static void main(String[] args) {
		if (args.length != 9) {
			System.out.println("Usage: container_name, protocol, host, port, ingest_port, username, password, filePath, mimeType");
			// e.g.: "CDMI/cdmi_objectid" "https" "10.118.232.182" "8080" "8081" "" "" "C:\Users\Public\Pictures\Sample Pictures\Chrysanthemum.jpg" "image/jpeg"
			return;
		}

		NetAppStoragePlugin netAppStoragePlugin = new NetAppStoragePlugin();
		Map<String, String> params = new LinkedHashMap<String, String>();
		params.put("container_name", args[0]);
		params.put("protocol", args[1]);
		params.put("host", args[2]);
		params.put("port", args[3]);
		params.put("ingest_port", args[4]);
		params.put("username", args[5]);
		params.put("password", args[6]);
		netAppStoragePlugin.init(params);
		System.out.println("Params: " + params);

		String storedEntityIdentifier = null;
		String filePath = args[7];
		File file = new File(filePath);
		try {
			System.out.println("storeEntity of " + filePath);
			StoredEntityMetaData storedEntityMetaData = new StoredEntityMetaData();
			storedEntityMetaData.setSizeInBytes("" + file.length());
			storedEntityMetaData.setEntityPid("FL1");
			String mimeType = args[8];
			String dnx = "<dnx xmlns=\"http://www.exlibrisgroup.com/dps/dnx\"><section id=\"fileFormat\"><record><key id=\"mimeType\">" + mimeType + "</key></record></section></dnx>";
			DnxDocument fileDnx = DnxDocumentFactory.getInstance().parse(dnx);
			storedEntityMetaData.setFileDnx(fileDnx);
			storedEntityIdentifier = netAppStoragePlugin.storeEntity(new FileInputStream(filePath), storedEntityMetaData);
			System.out.println("identifier: " + storedEntityIdentifier);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (storedEntityIdentifier != null) {
			try {
				System.out.println("retrieveEntity of " + storedEntityIdentifier);
				InputStream inputStream = netAppStoragePlugin.retrieveEntity(storedEntityIdentifier);
				String name = FilenameUtils.getName(filePath);
				String path = "C:\\Users\\shmuelb\\Documents\\" + name;
				copyInputStreamToFile(inputStream, new File(path));
                System.out.println("See retrieved file in " + path);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				System.out.println("retrieveEntityByRange of " + storedEntityIdentifier);
				String name = FilenameUtils.getName(filePath);
				String path = "C:\\Users\\shmuelb\\Documents\\" + name;
				File fileByRange = new File(path);

				byte[] allBytes = null;
				byte[] bytes;
				int i = 0;
				do {
					bytes = netAppStoragePlugin.retrieveEntityByRange(storedEntityIdentifier, i * 10000, i * 10000 + 9999);
					if (bytes != null) {
						allBytes = ArrayUtils.addAll(allBytes, bytes);
					}
					i++;
				} while (bytes != null);

				FileUtils.writeByteArrayToFile(fileByRange, allBytes);

				System.out.println("See retrieved file in " + path);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("getFullFilePath of " + storedEntityIdentifier);
			String fullFilePath = netAppStoragePlugin.getFullFilePath(storedEntityIdentifier);
			System.out.println("fullFilePath: " + fullFilePath);

			System.out.println("checkFixity of " + storedEntityIdentifier);
			List<Fixity> fixities = new ArrayList<Fixity>();
			boolean checkFixity = false;
			try {
				Fixity fixity = new Fixity();
				fixity.setAlgorithm("SHA1");
				String sha1 = new Checksummer(file, false, true, false).getSHA1();
				fixity.setValue(sha1);
				fixities.add(fixity);
				checkFixity = netAppStoragePlugin.checkFixity(fixities, storedEntityIdentifier);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("checkFixity result: " + checkFixity);

//			System.out.println("getLocalFilePath of " + storedEntityIdentifier);
//			String localFilePath = netAppStoragePlugin.getLocalFilePath(storedEntityIdentifier);
//			System.out.println("localFilePath: " + localFilePath);

			System.out.println("deleteEntity of " + storedEntityIdentifier);
			boolean deleteEntity = false;
			try {
				deleteEntity = netAppStoragePlugin.deleteEntity(storedEntityIdentifier);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("deleteEntity result: " + deleteEntity);
		}
	}

	public static void copyInputStreamToFile(InputStream source,
			File destination) throws IOException {
		try {
			FileOutputStream output = FileUtils.openOutputStream(destination);
			try {
				IOUtils.copy(source, output);
			} finally {
				IOUtils.closeQuietly(output);
			}
		} finally {
			IOUtils.closeQuietly(source);
		}
	}
}
