package com.exlibris.rosetta.plugins.repositoryTask;


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.core.sdk.formatting.DublinCore;
import com.exlibris.core.sdk.repository.TaskResults;
import com.exlibris.digitool.repository.api.IEEditor;
import com.exlibris.digitool.repository.api.RepositoryTaskPlugin;

public class DCReplacePlugin implements RepositoryTaskPlugin {

	ExLogger log = ExLogger.getExLogger(DCReplacePlugin.class);
	private String dc = null;
	private String find = null;
	private String replaceWith = null;

	private final String FAIL_FIND_VALUE = "failed to find dc value for the expression ";
	private final String FAIL_GET_DC = "failed to get dc for IE";
	private final String dcPatternStr = "dc:[a-zA-Z]*";
	private final String xpathPatternStr = "dc:[a-zA-Z]*@[a-zA-Z]*:[a-zA-Z]*";

	public DCReplacePlugin() {
		super();
	}

	public TaskResults execute(IEEditor ieEditor, Map<String, String> initParams, TaskResults taskResults) {

		log.info("Executing DCReplacePlugin for " + ieEditor.getIEPid());

		init(initParams);
		DublinCore ieDublinCore = null;

		try {
			ieDublinCore = ieEditor.getDcForIE();
		} catch (Exception e) {
			taskResults.addResult(ieEditor.getIEPid(), null, false, FAIL_GET_DC);
			return taskResults;
		}

		String dcValue = getDCValue(ieDublinCore);

		if (dcValue == null) {
			taskResults.addResult(ieEditor.getIEPid(), null, false, FAIL_FIND_VALUE + dc);
		} else if (dcValue.trim().equalsIgnoreCase(find)) {
			updateDC(ieDublinCore, ieEditor);
			log.info("Replaced PID " + ieEditor.getIEPid() + "s " + dc + " from: " + find + " to: " + replaceWith);
		}

		return taskResults;
	}

	/**
	 * Returns the DC value of the IE DC, by the initial DC field parameter .
	 * @param ieDublinCore
	 * @return
	 */
	private String getDCValue(DublinCore ieDublinCore) {

		Pattern xpathPattern = Pattern.compile(xpathPatternStr, Pattern.CASE_INSENSITIVE);
		Pattern dcPattern = Pattern.compile(dcPatternStr, Pattern.CASE_INSENSITIVE);

		Matcher xpathMatcher = xpathPattern.matcher(dc);
		Matcher dcMatcher = dcPattern.matcher(dc);

		String dcValue = null;

		if (xpathMatcher.matches()) {
			dcValue = ieDublinCore.getValue(dc);
		} else if (dcMatcher.matches()) {
			dcValue = ieDublinCore.getDcValue(dc.split(":")[1]);
		} else if (Pattern.matches("[a-zA-Z]*", dc)) {
			dcValue = ieDublinCore.getDcValue(dc);
			dc = "dc:" + dc;
		}

		return dcValue;
	}

	private void init(Map<String, String> initParams) {
		find = initParams.get("find");
		replaceWith = initParams.get("replace_with");
		dc = initParams.get("dc").trim();
	}

	public boolean isReadOnly() {
		return false;
	}

	private void updateDC(DublinCore ieDublinCore, IEEditor ieEditor) {
		ieDublinCore.removeElemet(dc);
		ieDublinCore.addElement(dc, replaceWith);
		ieEditor.setDC(ieDublinCore, ieDublinCore.getMid());
	}

	public static void main(String[] args) {
		//ieDublinCore.getValue(DublinCore.DC_NAMESPACE, "subject", "dcterms:MESH")
		//ieDublinCore.getValue("dc:subject@dcterms:MESH")

		Pattern xpathPattern = Pattern.compile("dc:[a-zA-Z]*@[a-zA-Z]*:[a-zA-Z]*", Pattern.CASE_INSENSITIVE);
		Pattern dcPattern = Pattern.compile("dc:[a-zA-Z]*", Pattern.CASE_INSENSITIVE);
		Matcher xpathMatcher = xpathPattern.matcher("dc:subject@dcterms:MESH");
		Matcher dcMatcher = dcPattern.matcher("dc:title");
		System.out.println(xpathMatcher.matches());
		System.out.println(dcMatcher.matches());

	}

}
