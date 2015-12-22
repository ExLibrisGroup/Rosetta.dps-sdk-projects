package com.exlibris.rosetta.repository.plugin.mdExtractor.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.URL;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.core.sdk.utils.FSUtil;
import com.exlibris.dps.sdk.techmd.MDExtractorPlugin;

import org.apache.commons.io.IOUtils;

import edu.harvard.hul.ois.jhove.AESAudioMetadata;
import edu.harvard.hul.ois.jhove.App;
import edu.harvard.hul.ois.jhove.ErrorMessage;
import edu.harvard.hul.ois.jhove.HandlerBase;
import edu.harvard.hul.ois.jhove.JhoveBase;
import edu.harvard.hul.ois.jhove.Message;
import edu.harvard.hul.ois.jhove.Module;
import edu.harvard.hul.ois.jhove.NisoImageMetadata;
import edu.harvard.hul.ois.jhove.OutputHandler;
import edu.harvard.hul.ois.jhove.Property;
import edu.harvard.hul.ois.jhove.PropertyArity;
import edu.harvard.hul.ois.jhove.PropertyType;
import edu.harvard.hul.ois.jhove.RepInfo;
import edu.harvard.hul.ois.jhove.TextMDMetadata;

public abstract class AbstractJhoveMDExtractorPlugin implements MDExtractorPlugin {

    public abstract void extract(String file) throws Exception;
    public abstract List<String> getSupportedAttributeNames();

    private static ExLogger log = ExLogger.getExLogger(AbstractJhoveMDExtractorPlugin.class);

    protected static String jhoveConfigFileSrc = "conf/jhove.conf";
    protected static String jhoveXsdFileSrc = "conf/jhoveConfig.xsd";
    protected static String defaultjhoveConfigFile = FSUtil.getSystemDir() + "conf/jhove.conf";
    protected static String jhoveDir = FSUtil.getSystemDir() + "conf/jhove/";

    public static App jhoveApplication  = new App (
		"Jhove",
		"1.1 (pre-release g)",
		new int[] {2007, 8, 30},
		("java Jhove [-c config] [-m module] [-h handler] [-e encoding] [-H handler] [-o output] [-x saxclass] [-t tempdir] [-b bufsize] [-l loglevel] [[-krs] dir-file-or-uri [...]]"),
		("Copyright 2004-2007 by the President and Fellows of Harvard College. Released under the GNU Lesser General Public License."));

    public String release = null;
    public RepInfo repinfo = null;
    private List<String> errorMessages = null;
    private Integer multiPageSize = 0;

    public void extract(String fileName, String jhoveModule, String pluginVersion) throws Exception
    {
		this.extract(fileName, jhoveModule, null, null, pluginVersion);
    }

    private void logRepinfoMessages()
    {
    	if (repinfo == null)
    		return;

    	List<Message> list = repinfo.getMessage();
    	if (list == null)
    		return;

    	for (Message message: list) {
    		log.warn("jhove message: " + message.getMessage());
    		if (message instanceof ErrorMessage){
    			addError(message.getMessage());
    		}
    	}
    }

    public void extract(String fileName, String jhoveModule, String multiplePropertiesToCheck, String muliplePropertiesToCount, String pluginVersion) throws Exception {

    		JhoveBase je = new JhoveBase();
			je.setLogLevel("SEVERE");
			String jhoveConfigFileName = getConfFile(jhoveModule + je.getRelease() + "-Ver" + pluginVersion);
			je.init(jhoveConfigFileName, null);
			String tempDir = je.getTempDirectory();
			createTempDir(tempDir);
			File file = new File(fileName);
			// use appropriate module (specified in the mapping)
			Module module = je.getModule(jhoveModule);
			// actually process
			DpsHandler dpsHandler = new DpsHandler();
			je.process(jhoveApplication, module, dpsHandler , file.getAbsolutePath());
			repinfo = dpsHandler.getRepinfo();
			release = module.getRelease();
			logRepinfoMessages();

			//if no property is returned - throw exception
			if ((repinfo.getProperty() == null) || (repinfo.getProperty().isEmpty())) {
				addError("Failed to retrieve extractor properties");
			}

			//throw new DigitoolException(DescriptorConstants.GN_UnexpectedError, "JHOVE Tech Md Extractor failed to retrieve extractor properties");

    }

    public void createTempDir(String tempDir) {

    	File jhoveTempDir = new File(tempDir);
    	if(!jhoveTempDir.exists()) {
    		jhoveTempDir.mkdirs();
    	}
    }

    public String getConfFile(String uniqueId) {
    	String confFilePath = jhoveDir + uniqueId + File.separator + "jhove.conf";
    	String xsdFilePath = jhoveDir + uniqueId + File.separator + "jhoveConfig.xsd";
    	File confFile = new File(confFilePath);
    	File xsdFile = new File(xsdFilePath);
    	if(!confFile.exists() || !xsdFile.exists()) {
    		InputStream is = null;
    		FileOutputStream os = null;
    		try {

    			//copy jove.conf file to temp dir
    			confFile.getParentFile().mkdirs();
    			confFile.createNewFile();
    			is = this.getClass().getClassLoader().getResourceAsStream(jhoveConfigFileSrc);
    			os = new FileOutputStream(confFile);
    			IOUtils.copy(is, os);
    			IOUtils.closeQuietly(is);
    			IOUtils.closeQuietly(os);

    			//copy jhoveConfig.xsd file to temp dir
    			xsdFile.getParentFile().mkdirs();
    			xsdFile.createNewFile();
    			is = this.getClass().getClassLoader().getResourceAsStream(jhoveXsdFileSrc);
    			os = new FileOutputStream(xsdFile);
    			IOUtils.copy(is, os);

    		} catch(Exception e) {
    			log.warn("failed to copy plugin's jhove.conf for " + uniqueId + ". using default jhove.conf from dps_conf", e);
    			return defaultjhoveConfigFile;
    		} finally {
    			IOUtils.closeQuietly(is);
    			IOUtils.closeQuietly(os);
    		}
    	}

    	return confFilePath;
    }

    public boolean isValid()
    {
    	if (repinfo == null)
    		return false;

    	if (repinfo.getValid() == 0)
    		return false;

    	return true;
    }

    public boolean isWellFormed()
    {
    	if (repinfo == null)
    		return false;

    	if (repinfo.getWellFormed() == 0)
    		return false;

    	return true;
    }

    public void setImageCount(int count){
    	this.multiPageSize = count;
    }

    public RepInfo getRepinfo() {
		return repinfo;
	}

    public String getRelease() {
		return release;
	}

    public Integer getImageCount(){
    	return this.multiPageSize;
    }

    protected static String extractJhoveValue(String[] fieldPath, Property parentProperty,
	    int fieldPathCurrentSegment) {

    //end of path - property not found
	if(null == fieldPath || null == parentProperty || fieldPathCurrentSegment < 0)
	    return null;

	//last property in the path - return value
	if(fieldPathCurrentSegment >= fieldPath.length - 1)
		return getPropertyStringValue(parentProperty.getValue());

	//NisoImageMetadata
	if(PropertyType.NISOIMAGEMETADATA.equals(parentProperty.getType())){
	    NisoImageMetadata nisoMetadata = (NisoImageMetadata) parentProperty.getValue();
	    try {
		// getter reflection
		Object object = nisoMetadata.getClass().getMethod(
			"get" + fieldPath[++fieldPathCurrentSegment]).invoke(nisoMetadata);
		return getPropertyStringValue(object);

	    } catch (Exception e) {
		log.error(e.toString());
	    }
	    return null;
	}


	//TextMDMetadata
	if(PropertyType.TEXTMDMETADATA.equals(parentProperty.getType())){
	    TextMDMetadata textMDMetadata = (TextMDMetadata) parentProperty.getValue();
	    try {
		// getter reflection
		Object object = textMDMetadata.getClass().getMethod(
			"get" + fieldPath[++fieldPathCurrentSegment]).invoke(textMDMetadata);
		return getPropertyStringValue(object);

	    } catch (Exception e) {
		log.error(e.toString());
	    }
	    return null;
	}


	//AESAudioMedata
	if (PropertyType.AESAUDIOMETADATA.equals(parentProperty.getType())) {
	    AESAudioMetadata aesMetadata = (AESAudioMetadata) parentProperty.getValue();
	    try {
		// getter reflection
		Object object = aesMetadata.getClass().getMethod(
			"get" + fieldPath[++fieldPathCurrentSegment]).invoke(aesMetadata);
		return getPropertyStringValue(object);
	    } catch (Exception e) {
		log.error(e.toString());
	    }
	    return null;
	}

	//get next property from the path - continue recursion
	//try to extract the child property using get "getByName"
	//in case that the parent property is scalar and the still has child - using "getValue".
	fieldPathCurrentSegment++;
	String nextPropName=fieldPath[fieldPathCurrentSegment];
	Property nextProp = parentProperty.getByName(nextPropName);

		if (nextProp == null && parentProperty.getArity().equals(PropertyArity.SCALAR)&& parentProperty.getValue()!= null){

			nextProp = (Property)parentProperty.getValue();
		}


	return extractJhoveValue(fieldPath, nextProp, fieldPathCurrentSegment);
    }



    /********************************************************************
     * If object is of type collection/array - return content of object in
     * array form: [x, y, ..., z]
     * Otherwise return object content in simple string form (object.toString())
     ******************************************************************/
    private static String getPropertyStringValue(Object object)
    {

    	if (object == null)
    		return null;

    	//int array
    	if ((object instanceof int[]))
    		return Arrays.toString((int[]) object);

    	//long array
    	if ((object instanceof long[]))
    		return Arrays.toString((long[]) object);

    	//double array
    	if ((object instanceof double[]))
    		return Arrays.toString((double[]) object);


    	//Object array
    	if ((object instanceof Object[])){

    		Object[] arr = (Object[]) object;
    		for(int i = 0; i< arr.length; i++){
    			if (! (arr[i] instanceof Property)){
    				return Arrays.toString((Object[]) object);
    				}
    			}
    		String propString = ColectionPropertyToString( object);
    		return "["+propString.substring(0, propString.length()-2)+"]";
    	}



    	//Collection
    	if ((object instanceof Collection))
    	{
    		Object[] arr = ((Collection)object).toArray();

    		for(int i = 0; i< arr.length; i++){
    			if (! (arr[i] instanceof Property)){
    				return Arrays.toString(arr);
    				}
    			}
    		String propString = ColectionPropertyToString(((Collection)object).toArray());
    			return "["+propString.substring(0, propString.length()-2)+"]";
    	}

    	//scalar
    	String scalar = object.toString();

    	try { //avoid -1 values
    		return (Double.valueOf(scalar) == -1) ? null : scalar;
    	} catch (Exception e) {}

    	return scalar;
    }

    public String getAttributeByName(String attributeName) {

    	// avoid null pointer exception in case property is null.
    	if (repinfo.getProperty() == null) {
    		return null;
    	}

    	try {
	    	String[] jhoveFieldPath = attributeName.split("\\.");
	     	String propertyValue = extractJhoveValue(jhoveFieldPath, repinfo.getByName(jhoveFieldPath[0]), 0);
	    	return propertyValue;
    	} catch (Throwable e) {
			return null;
		}
    }

    public String getFormatName(){
    	return repinfo.getFormat();
    }
    public String getFormatVersion() {
    	return repinfo.getVersion();
    }
    public String getMimeType() {
    	return repinfo.getMimeType();
    }

    public List<String> getExtractionErrors() {
    	return errorMessages;
    }

    private static String ColectionPropertyToString(Object object){

    	String res = "";

    	//if object is [] object
    	if (object  instanceof Object[]) {
    		Object [] arr = (Object[]) object;
    		for (int i = 0; i< arr.length ;i++){
    			res+= ColectionPropertyToString((Property)arr[i]);
    		}
    	}
    	// if object is a property of array
    	else if (object  instanceof  Property && ((Property)object).getArity().equals(PropertyArity.ARRAY)){

    		return ColectionPropertyToString(((Property)object).getValue());
    	}

    	// object is a property of scalar
    	else if (object  instanceof  Property && ((Property)object).getArity().equals(PropertyArity.SCALAR)){

    		Property prop = (Property)object;
    		return prop.getName() + "=" + prop.getValue() + " ;";
    	}

    	return res;
    }

    private void addError(String message) {
    	if (errorMessages == null) {
    		errorMessages = new ArrayList<String>();
    	}
    	errorMessages.add(message);
    }

    public class DpsHandler extends HandlerBase {

    	private RepInfo repinfo;

    	public DpsHandler() {
    		super("DPSHandler","v1",new int[3],"note","right");
    	}

    	public RepInfo getRepinfo() {
    		return repinfo;
    	}

    	@Override
    	public void show() {
    		// TODO DpsHandler.show

    	}

    	@Override
    	public void show(Module module) {
    		// TODO DpsHandler.show

    	}

    	@Override
    	public void show(RepInfo repinfo) {
    		this.repinfo = repinfo;
    	}

    	@Override
    	public void show(OutputHandler outputhandler) {
    		// TODO DpsHandler.show

    	}

    	@Override
    	public void show(App app) {
    		// TODO DpsHandler.show

    	}

    	@Override
    	public void showFooter() {
    		// TODO DpsHandler.showFooter

    	}

    	@Override
    	public void showHeader() {
    		// TODO DpsHandler.showHeader

    	}

    }

}