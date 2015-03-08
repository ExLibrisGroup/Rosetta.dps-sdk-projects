package com.exlibris.rosetta.repository.plugin.mdExtractor.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class HTMLHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(HTMLHULMDExtractorPlugin.class);
    private static String jhoveModule =  "HTML-hul";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();

    static{
    	attList.add("HTMLMetadata.TextMDMetadata.Linebreak");
    	attList.add("HTMLMetadata.TextMDMetadata.Markup_basis");
    	attList.add("HTMLMetadata.TextMDMetadata.Markup_basis_version");
    	attList.add("HTMLMetadata.TextMDMetadata.Markup_language");
    	attList.add("HTMLMetadata.TextMDMetadata.Charset");
    	attList.add("HTMLMetadata.TextMDMetadata.Byte_order");
    	attList.add("HTMLMetadata.TextMDMetadata.Byte_size");
    	attList.add("HTMLMetadata.TextMDMetadata.Character_size");

    	attList.add("HTMLMetadata.TextMDMetadata");
    	attList.add("HTMLMetadata.Title");
    	attList.add("HTMLMetadata.UnicodeEntityBlocks");
    	attList.add("HTMLMetadata.Entities");
    	attList.add("HTMLMetadata.Abbreviations");
    	attList.add("HTMLMetadata.DefinedTerms");
    	attList.add("HTMLMetadata.Citations");
    	attList.add("HTMLMetadata.Frames");
    	attList.add("HTMLMetadata.MetaTags");
    	attList.add("HTMLMetadata.Images");
    	attList.add("HTMLMetadata.Scripts");
    	attList.add("HTMLMetadata.Links");
    	attList.add("HTMLMetadata.OtherLanguages");
    	attList.add("HTMLMetadata.PrimaryLanguage");

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
    	return "JHOVE , HTML-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}

}
