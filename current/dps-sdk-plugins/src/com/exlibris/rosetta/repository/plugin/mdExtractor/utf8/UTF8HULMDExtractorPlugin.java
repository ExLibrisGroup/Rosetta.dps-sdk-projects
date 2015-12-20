package com.exlibris.rosetta.repository.plugin.mdExtractor.utf8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class UTF8HULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(UTF8HULMDExtractorPlugin.class);
    private static String jhoveModule =  "UTF8-hul";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
    static {


		attList.add("UTF8Metadata.Characters");
		attList.add("UTF8Metadata.UnicodeBlocks");
		attList.add("UTF8Metadata.LineEndings");

		attList.add("UTF8Metadata.TextMDMetadata.Charset");
		attList.add("UTF8Metadata.TextMDMetadata.Byte_order");
        attList.add("UTF8Metadata.TextMDMetadata.Byte_size");
		attList.add("UTF8Metadata.TextMDMetadata.Character_size");
		attList.add("UTF8Metadata.TextMDMetadata.Linebreak");

    }

    @Override
    public void extract(String fileName) throws Exception {

            super.extract(fileName,jhoveModule,pluginVersion);

    }

    @Override
    public List<String> getSupportedAttributeNames() {
        return attList;
    }


    public String getAgentName()
    {
    	return "JHOVE , UTF8-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}


}
