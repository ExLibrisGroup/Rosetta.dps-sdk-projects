package com.exlibris.dps.repository.plugin.storage.netapp.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.xmlbeans.impl.util.Base64;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import com.exlibris.core.sdk.storage.containers.StoredEntityMetaData;
import com.exlibris.digitool.common.dnx.DNXConstants;
import com.exlibris.digitool.common.dnx.DnxDocument;

public class CDMIConnector {

	/*
	 * Stores the sent stream to CDMI
	 */
	public String putObject(NetAppClient netAppClient, StoredEntityMetaData storedEntityMetadata, InputStream inputStream) throws Exception{
		// Create the request
		DefaultHttpClient httpclient = createHttpClient(netAppClient, true);
		HttpPost httpPost = new HttpPost(new URI(getContainerURI(netAppClient, true)));

		// TODO: support chunks for big files
		byte[] encode = Base64.encode(IOUtils.toByteArray(inputStream));
		String bytes = new String(encode);

		initializeHeaders(httpPost, CDMIHttpHeader.CONTENT_TYPE_CDMI_OBJECT);
		String domainURI = "/cdmi_domains/";
		DnxDocument fileDnx = storedEntityMetadata.getFileDnx();
		String mimetype = fileDnx.getSectionKeyValue(DNXConstants.FILEFORMAT.MIMETYPE);
		String string = "{\"domainURI\":\"" + domainURI
				+ "\",\"mimetype\":\"" + mimetype + "\",\"metadata\":{\"pid\" : \"" + storedEntityMetadata.getEntityPid()
				+ "\"},\"valuetransferencoding\":\"base64\",\"value\":\"" + bytes + "\"}";
		httpPost.setEntity(new StringEntity(string));

		// 1. Create data object
		HttpResponse response = httpclient.execute(httpPost);

		// 2. get object id from the response
		String identifier = getSpecificJSONValue(response, "objectID");

		// 3. update the existing object value in ranges
/*
    FIXME

    !!! If InputStreamEntity will not work - try sending in ranges manually

 		long partSize = 4096;
		long remainingBytes = storedEntityMetadata.getSizeInBytes();
		long currentRange = 0;
		long endRange = 0;
		boolean isLastPart = (remainingBytes - partSize <= 0);
		while (remainingBytes > 0) {
			isLastPart = (remainingBytes - partSize <= 0);
			if(isLastPart){
				partSize = remainingBytes;
			}
			endRange = currentRange+partSize;
			httpput = new HttpPut(getCDMIObjectURI(netAppClient, identifier)+"?value:"+currentRange+":"+endRange);
			byte [] stream = new byte[(int) partSize];
			inputStream.read(stream);
			StringEntity entity = new StringEntity(new String(stream));
			httpput.setEntity(entity);
			response = httpclient.execute(httpput);
			if (!isSuccessfulResponse(response)){
				deleteObject(netAppClient, identifier);
				return null;
			}
			remainingBytes = remainingBytes - partSize;
		}
*/

		return identifier;
	}


	/*
	 *	According CDMI documentation:
	 *	Individual fields within a data object may be accessed by specifying the field name after a question mark "?" that is appended to the end of the data object URI. Thus, the following URI returns the value field in the response body:
	 *	http://cloud.example.com/dataobject?value
	 */
	public InputStream getObject(NetAppClient netAppClient, String identifier) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException, URISyntaxException{
		return getObjectByRange(netAppClient, identifier, null, null);
	}

	/*
	 *	According CDMI documentation:
	 *	Individual fields within a data object may be accessed by specifying the field name after a question mark "?" that is appended to the end of the data object URI. Thus, the following URI returns the value field in the response body:
	 *	http://cloud.example.com/dataobject?value
	 */
	public InputStream getObjectByRange(NetAppClient netAppClient, String identifier, Long start, Long end) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException,
	NoSuchAlgorithmException, CertificateException, IOException, URISyntaxException{
		DefaultHttpClient httpclient = createHttpClient(netAppClient, false);
		String range = (start != null && end != null) ? ":" + start + "-" + end : "";
		HttpGet httpget = new HttpGet(new URI(getCDMIObjectURIAsString(netAppClient, identifier) + "?value" + range));
		initializeHeaders(httpget, CDMIHttpHeader.CONTENT_TYPE_CDMI_OBJECT);
		setCredentials(netAppClient, httpclient, false);
		HttpResponse response = httpclient.execute(httpget);
		String value = getSpecificJSONValue(response, "value");
		InputStream content = null;
		if (value != null) {
			byte[] decoded = Base64.decode(value.getBytes());
			content = new ByteArrayInputStream(decoded);
		}
		return content;
	}

	/*
	 * DELETE /CDMI/cdmi_objectid/00006FFD00196F3200A9A3E248235D4910AFF83E61CB86E5FE HTTP/1.1
	 * Host: northstar
	 * X-CDMI-Specification-Version: 1.0.1
	 *
	 */
	public boolean deleteObject(NetAppClient netAppClient, String identifier) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException,
					NoSuchAlgorithmException, CertificateException, IOException, URISyntaxException{
		DefaultHttpClient httpclient = createHttpClient(netAppClient, false);
		HttpDelete httpdelete = new HttpDelete(getCDMIObjectURI(netAppClient, identifier));
		initializeHeaders(httpdelete, CDMIHttpHeader.CONTENT_TYPE_CDMI_OBJECT);
		setCredentials(netAppClient, httpclient, false);
		HttpResponse response = httpclient.execute(httpdelete);
		return isSuccessfulResponse(response);
	}

	/*
	 * GET /CDMI/cdmi_objectid/00006FFD00196F3200A9A3E248235D4910AFF83E61CB86E5FE?metadata HTTP/1.1
	 * Host: northstar
	 * Accept: application/cdmi-object
	 * X-CDMI-Specification-Version: 1.0.1
	 */
	public HashMap<String, String> getObjectMetadata(NetAppClient netAppClient, String identifier) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException,
					NoSuchAlgorithmException, CertificateException, IOException, URISyntaxException{
		DefaultHttpClient httpclient = createHttpClient(netAppClient, false);
		HttpGet httpget = new HttpGet(new URI(getCDMIObjectURIAsString(netAppClient, identifier)+"?metadata"));
		initializeHeaders(httpget, CDMIHttpHeader.CONTENT_TYPE_CDMI_OBJECT);
		setCredentials(netAppClient, httpclient, false);
		HttpResponse response = httpclient.execute(httpget);
		return getResponseMetadata(response, identifier);
	}


	public String getContainerURI(NetAppClient netAppClient, boolean useIngestPort) {
		return ensureOneOnlySlash(
						netAppClient.getProtocol() + "://" +
						netAppClient.getHost() + ":" +
						((useIngestPort) ? netAppClient.getIngestPort() : netAppClient.getPort()) + "/" +
						netAppClient.getContainerName()); // might have / at the end
	}

	/**
	 * This adds a forward slash ('/') to the url represented by the string if none is present, and does nothing otherwise:
	 *  ensureOneOnlySlash("http://host:port/som/url") 	=> "http://host:port/som/url/"
	 *  ensureOneOnlySlash("http://host:port/som/url/") => "http://host:port/som/url/"
	 */
	private static String ensureOneOnlySlash(String url) {
		if (!url.endsWith("/")) {
			url += "/";
		}
		return url;
	}

	public URI getCDMIObjectURI(NetAppClient netAppClient, String identifier) throws URISyntaxException, URIException {
		return new URI(getCDMIObjectURIAsString(netAppClient, identifier));
	}

	/*
	 * FIXME
	 *
	 * NOTE!! In CDMI spec requests url looks like GET /cdmi_objectid/00006FFD0010AA33D8CEF9711E0835CA HTTP/1.1
	 *
	 * In LDS-NetApp example they send: GET /CDMI/cdmi_objectid/00006FFD00196F3200A9A3E248235D4910AFF83E61CB86E5FE HTTP/1.1
	 *
	 * Note sure what is the correct option here. Going with the LDS example
	 */
	public String getCDMIObjectURIAsString(NetAppClient netAppClient, String identifier) {
		return getContainerURI(netAppClient, false) + identifier;
	}

	private HashMap<String, String> getResponseMetadata(HttpResponse response, String identifier) throws JsonParseException, IllegalStateException, IOException {
		HashMap<String, String> metadata = new HashMap<String, String>();
		InputStream content = response.getEntity().getContent();
		if (isSuccessfulResponse(response)) {
			String key, value = null;
			JsonFactory f = new JsonFactory();
			JsonParser jp = f.createJsonParser(content);
			while ((jp.nextToken()) != JsonToken.END_OBJECT) {
				key = jp.getCurrentName();
				if ("metadata".equals(key)) {
					jp.nextToken();
					System.out.println("Start parsing metadata for " + identifier);
					while ((jp.nextToken()) != JsonToken.END_OBJECT) {
						key = jp.getCurrentName();
						jp.nextToken();
						value = jp.getText();
						metadata.put(key, value);
						System.out.println(identifier + " -- Key = " + key + " : Value = " + value);
					}
					System.out.println("End parsing metadata for " + identifier);
					return metadata;
				}
			}
		} else {
			String string = IOUtils.toString(content);
			System.err.println(string);
		}
		return metadata;
	}


	private String getSpecificJSONValue(HttpResponse response, String jsonKey) throws JsonParseException, IllegalStateException, IOException {
		InputStream content = response.getEntity().getContent();
		if (isSuccessfulResponse(response)) {
			JsonFactory f = new JsonFactory();
			JsonParser jp = f.createJsonParser(content);
			while ((jp.nextToken()) != JsonToken.END_OBJECT) {
				if (jsonKey.equals(jp.getCurrentName())) {
					jp.nextToken();
					return jp.getText();
				}
			}
		} else {
			String string = IOUtils.toString(content);
			System.err.println(string);
		}
		return null;
	}

	private DefaultHttpClient createHttpClient(NetAppClient netAppClient, boolean useIngestPort) throws KeyStoreException, NoSuchAlgorithmException,
				CertificateException, IOException, KeyManagementException, UnrecoverableKeyException {
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);

        SSLContext ctx = SSLContext.getInstance("TLS");
        X509TrustManager tm = new CustomX509TrustManager();
        ctx.init(null, new TrustManager[]{tm}, null);
        SSLSocketFactory ssf = new SSLSocketFactory(ctx);
        ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        SchemeRegistry registry = new SchemeRegistry();
        if(netAppClient.getProtocol() != null && "https".equalsIgnoreCase(netAppClient.getProtocol())){
        	// defined port for https, default for http
        	registry.register(new Scheme("https", useIngestPort ? netAppClient.getIngestPort() : netAppClient.getPort() , ssf));
        	registry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        }
        else{
        	// defined port for http, default for https
            registry.register(new Scheme("http", useIngestPort ? netAppClient.getIngestPort() : netAppClient.getPort(), PlainSocketFactory.getSocketFactory()));
            registry.register(new Scheme("https", 443, ssf));
        }

        ClientConnectionManager ccm = new ThreadSafeClientConnManager(registry);

        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(ccm, params);
        setCredentials(netAppClient, defaultHttpClient, useIngestPort);
		return defaultHttpClient;
	}

	private void initializeHeaders(HttpRequestBase httpput, String contentType) {
		httpput.setHeader(CDMIHttpHeader.ACCEPT, CDMIHttpHeader.ACCEPT_VALUE);
		httpput.setHeader(CDMIHttpHeader.CONTENT_TYPE, contentType);
		httpput.setHeader(CDMIHttpHeader.CDMI_VER, CDMIHttpHeader.CDMI_VER_VALUE);
	}

	/*
	 * If authentication needed:
	 */
	private void setCredentials(NetAppClient netAppClient, DefaultHttpClient httpclient, boolean useIngestPort) {
		if(!StringUtils.isEmpty(netAppClient.getUsername()) && !StringUtils.isEmpty(netAppClient.getPassword())){
			Credentials credentials = new UsernamePasswordCredentials(netAppClient.getUsername(), netAppClient.getPassword());
			httpclient.getCredentialsProvider().setCredentials(new AuthScope(netAppClient.getHost(), useIngestPort ? netAppClient.getIngestPort() : netAppClient.getPort()), credentials);
		}
	}


	private boolean isSuccessfulResponse(HttpResponse response) {
		return (response.getStatusLine().getStatusCode() <= CDMIResponseStatus.No_Content);
	}
}
