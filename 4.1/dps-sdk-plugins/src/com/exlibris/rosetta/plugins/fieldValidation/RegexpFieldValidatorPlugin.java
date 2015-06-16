package com.exlibris.rosetta.plugins.fieldValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exlibris.dps.sdk.fieldvalidator.FieldValidatorPlugin;

public class RegexpFieldValidatorPlugin implements FieldValidatorPlugin {

	private static final String pluginType = "xsi:type=general";
	private static final String REG_EXP_PATTERN = "regexp";

	private String regexpPattern = null;
	private List<String> errors = null;

	@Override
	public List<String> getErrors() {
		return errors;
	}

	@Override
	public String getType() {
		return pluginType;
	}

	@Override
	public boolean validate(String field) {

		Pattern pattern = Pattern.compile(regexpPattern, Pattern.CASE_INSENSITIVE);
		Matcher patternMatcher = pattern.matcher(field);
		boolean isValid = patternMatcher.matches();
		if(!isValid) {
			errors = new ArrayList<String>();
			errors.add(this.getClass().getSimpleName() + " of type " + pluginType + ": the value " + field + " is not valid");
		}
		return isValid;
	}

	public void initParams(Map<String, String> initParams) {
		this.regexpPattern = initParams.get(REG_EXP_PATTERN);
	}
}
