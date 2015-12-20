package com.exlibris.rosetta.repository.plugin.mdExtractor.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.io.File;

import com.exlibris.core.sdk.utils.FSUtil;

import org.apache.commons.io.IOUtils;

import edu.harvard.hul.ois.jhove.JhoveBase;

import net.lingala.zip4j.core.*;
import net.lingala.zip4j.model.*;
import net.lingala.zip4j.util.*;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class XMLHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(XMLHULMDExtractorPlugin.class);
    private static String schemaFilesSrc = "conf/schema_files.zip";
    private static String jhoveModule =  "XML-hul";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
    static{
    	attList.add("XMLMetadata.TextMDMetadata.Linebreak");
    	attList.add("XMLMetadata.TextMDMetadata.Markup_basis");
    	attList.add("XMLMetadata.TextMDMetadata.Markup_basis_version");
    	attList.add("XMLMetadata.TextMDMetadata.Markup_language");
    	attList.add("XMLMetadata.TextMDMetadata.setMarkup_language_version");
    	attList.add("XMLMetadata.TextMDMetadata.Charset");
    	attList.add("XMLMetadata.TextMDMetadata.Byte_order");
    	attList.add("XMLMetadata.TextMDMetadata.Byte_size");
    	attList.add("XMLMetadata.TextMDMetadata.Character_size");

    	attList.add("XMLMetadata.Parser");
    	attList.add("XMLMetadata.Encoding");
    	attList.add("XMLMetadata.Schemas.Schema.NamespaceURI");
    	attList.add("XMLMetadata.Schemas.Schema.SchemaLocation");
    	attList.add("XMLMetadata.Root");
    	attList.add("XMLMetadata.Namespaces.Namespace.Prefix");
    	attList.add("XMLMetadata.Namespaces.Namespace.URI");


		}

    @Override
    public void extract(String fileName) throws Exception {
    	copySchemaFiles();
    	super.extract(fileName,jhoveModule,pluginVersion);

    }


    @Override
    public List<String> getSupportedAttributeNames() {
        return attList;
    }


    public String getAgentName()
    {
    	return "JHOVE , XML-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}

    public void copySchemaFiles() throws Exception {
    	JhoveBase je = new JhoveBase();
    	String uniqueId = jhoveModule + je.getRelease() + "-Ver" + pluginVersion;
        String schemaFilesTarget = jhoveDir + "schema_files" + uniqueId + ".zip";
    	File schemas = new File(schemaFilesTarget);
    	if(!schemas.exists()) {
    		synchronized (XMLHULMDExtractorPlugin.class) {
	    		InputStream is = null;
	    		FileOutputStream os = null;
	    		try {
	    			schemas.getParentFile().mkdirs();
	    			schemas.createNewFile();
	    			is = this.getClass().getClassLoader().getResourceAsStream(schemaFilesSrc);
	    			os = new FileOutputStream(schemas);
	    			IOUtils.copy(is, os);
	    			ZipFile zipFile = new ZipFile(schemaFilesTarget);
	    	        zipFile.extractAll(jhoveDir);
	    		} catch(Exception e) {
	    			log.warn("failed to copy schema_files.zip, JHOVE will use external links to retrieve the schemas", e);
	    			if(schemas.exists()) {
	    				schemas.delete();
	    			}
	    		} finally {
	    			IOUtils.closeQuietly(is);
	    			IOUtils.closeQuietly(os);
	    		}
	    	}
    	}
    }

}
