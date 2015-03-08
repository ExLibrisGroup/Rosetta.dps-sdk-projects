package com.exlibris.rosetta.repository.plugin.mdExtractor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exlibris.dps.sdk.techmd.MDExtractorPlugin;

/**
 * @author yaarac
 *
 */
public class DummyMDExtractorPlugin implements MDExtractorPlugin  {

	/*
	 * The extractor agent name.
	 */
	private static final String REG_SA_DUMMY = "REG_SA_DUMMY";

	/*
	 * Any Object to hold data or extract metadata content
	 */
	private DataHandler handler;

	/**
	 * List of extracted properties. In order for the extracted properties to be stored in the AIP
	 * in the dnx.significantProperties section, the following configuration actions should be taken:
	 * 1. Mapping of the extracted properties to dnx properties using Rosetta UI - Home > Preservation > Manage Global Libraries > List of Extractors > Mapping Fields.
	 * 2. Assign the deployed extractor to a Classification Group.
	 * 3. Create a list of the dnx properties to be stored using Rosetta UI - Home > Preservation > Manage Global Libraries > List of Classification Groups > Related Properties
	 *
	 * Example: If DUMMY.HEADER.COMMENT should be stored in the AIP, it should be mapped to a dnx significant property object.comment
	 * The extractor then uses DUMMY.HEADER.COMMENT as a key to get the extracted value.
	 * The extracted value will be written later to the dnx object.comment.
	 **/
	private static List<String> attList = new ArrayList<String>();
	static {
		attList.add("DUMMY.HEADER.COMMENT");
		attList.add("DUMMY.HEADER.CONTENT-TYPE");
		attList.add("DUMMY.HEADER.COPYRIGHT");
		attList.add("DUMMY.HEADER.TITLE");
		attList.add("DUMMY.METADATA.DATE");
		attList.add("DUMMY.METADATA.PATH");
		attList.add("DUMMY.METADATA.URL");
		attList.add("DUMMY.METADATA.MODE");
		attList.add("DUMMY.METADATA.VERSION");
	}

    @Override
	public void extract(String fileName) throws Exception {
		 File file = new File(fileName);
		 handler = new DataHandler();
		 handler.process(file);
	}


	@Override
	public String getAgent() {
		return REG_SA_DUMMY;
	}


	@Override
	public String getAttributeByName(String attributeName) {
		return handler.getValue(attributeName);
	}

	@Override
	public String getFormatName() {
		return handler.getFormat();
	}

	@Override
	public String getFormatVersion() {
		return handler.getFormatVersion();
	}

	@Override
	public Integer getImageCount() {
		return 0;
	}

	@Override
	public String getMimeType() {
		return handler.getMimeType();
	}

	@Override
	public List<String> getSupportedAttributeNames() {
		return attList;
	}

	public List<String> getExtractionErrors() {
		return handler.getErrors();
	}

	/**
	 * Class that handles extraction of significant properties.
	 */
	public class DataHandler {

		/**
		 * Data structure that holds the extracted significant properties
		 */
		private Map<String, String> content;
		private List<String> errors;
		private String mimeType;
		private String format;
		private String formatVersion;
		private int valid;
		private int wellFormed;

		/**
		 * Extracts significant properties for the given file, fill
		 * internal data structures with information.
		 * @param file
		 */
		public void process(File file) {
			// pasre file, extract properites
			 content = new HashMap<String, String>();
			 content.put("DUMMY.HEADER.COMMENT", "comment");
			 content.put("DUMMY.HEADER.CONTENT-TYPE", "type");
			 content.put("DUMMY.HEADER.COPYRIGHT", "copyright");
			 content.put("DUMMY.HEADER.TITLE","title");
			 content.put("DUMMY.METADATA.DATE", "date");
			 content.put("DUMMY.METADATA.PATH", "path");
			 content.put("DUMMY.METADATA.URL", "url");
			 content.put("DUMMY.METADATA.MODE", "mode");
			 content.put("DUMMY.METADATA.VERSION", "version");

			 mimeType = "file mime type";
			 format = "dummyFormat";
			 formatVersion = "v1";
			 valid = 0;
			 wellFormed = 0;
		}

		/**
		 * Returns the extracted value of a given attribute
		 * @param key the name of the attribute as kept in the internal handler structures
		 * @return the value of the given attribute
		 */
		public String getValue(String key) {
			return content.get(key);
		}

		/**
		 * Returns extraction errors
		 * @return list of extraction errors
		 */
		public List<String> getErrors() {
			return errors;
		}

		/**
		 * Returns extracted file mime type.
		 * @return file's mime type
		 */
		public String getMimeType() {
			return mimeType;
		}

		/**
		 * Returns the extracted file format
		 * @return file format
		 */
	    public String getFormat(){
	    	return format;
	    }

	    /**
	     * Returns file format version
	     * @return format version
	     */
	    public String getFormatVersion() {
	    	return formatVersion;
	    }

	    /**
	     * Indicates whether the file is valid
	     * @return 0 if valid
	     */
	    public int getValid() {
	    	return valid;
	    }

	    /**
	     * Indicates whether the file is well formed
	     * @return 0 if well formed
	     */
	    public int getWellFormed() {
	    	return wellFormed;
	    }
	}

	 /**
     * Indicates whether the file is valid
     * @return 0 if valid
     */
    public boolean isValid() {
    	return handler.valid == 0 ? true : false;
    }

    /**
     * Indicates whether the file is well formed
     * @return 0 if well formed
     */
    public boolean isWellFormed() {
    	return handler.wellFormed == 0 ? true : false;
    }
}

