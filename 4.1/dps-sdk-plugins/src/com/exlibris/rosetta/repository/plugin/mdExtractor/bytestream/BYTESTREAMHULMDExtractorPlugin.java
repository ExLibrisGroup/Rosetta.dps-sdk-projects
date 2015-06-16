package com.exlibris.rosetta.repository.plugin.mdExtractor.bytestream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class BYTESTREAMHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(BYTESTREAMHULMDExtractorPlugin.class);
    private static String jhoveModule =  "BYTESTREAM-hul";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();

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
    	return "JHOVE , BYTESTREAM " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}

}
