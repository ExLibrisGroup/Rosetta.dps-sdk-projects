package com.exlibris.rosetta.repository.plugin.mdExtractor.tiff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;

import edu.harvard.hul.ois.jhove.Property;
import edu.harvard.hul.ois.jhove.RepInfo;


public class TIFFHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(TIFFHULMDExtractorPlugin.class);
    private static String jhoveModule =  "TIFF-hul";
    private static String multiPagePropertyToCheck = "IFDs";
    private static String multiPagePropertyToCount = "IFD";
    private static String multiPagePropertyValueToCount = "TIFF";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;


    private static List<String> attList = new ArrayList<String>();
         static {
        	 attList.add("TIFFMetadata.ByteOrder");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DateTime");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.AnalogBalance");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.AsShotNeutral");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.BaselineExposure");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.BaselineNoise");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.BaselineSharpness");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.CalibrationIlluminant1");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.CalibrationIlluminant2");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.ColorMatrix1");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.ColorMatrix2");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.DNGBackwardVersion");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.DNGVersion");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.LensInfo");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.LinearResponseLimit");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.LocalizedCameraModel");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DNGProperties.UniqueCameraModel");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DocmentName");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.DotRange");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.ImageDescription");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.InkSet");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.JPEGTables");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.MaxSampleValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.MinSampleValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NewSubfileType");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.AutoFocus");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.BackLight");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.BitsPerSample");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.Brightness");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ByteOrder");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ChecksumMethod");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ChecksumValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.Class");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ColormapBitCodeValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ColormapBlueValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ColormapGreenValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ColormapRedValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ColormapReference");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ColorSpace");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ColorTemp");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.CompressionLevel");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.CompressionScheme");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.DateTimeCreated");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.DateTimeProcessed");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.DeviceSource");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.DigitalCameraManufacturer");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.DigitalCameraModel");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.DisplayOrientation");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ExposureBias");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ExposureIndex");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ExposureTime");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ExtraSamples");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.FileSize");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.Flash");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.FlashEnergy");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.FlashReturn");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.FNumber");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.FocalLength");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.GrayResponseCurve");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.GrayResponseUnit");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.HostComputer");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ImageData");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ImageIdentifier");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ImageIdentifierLocation");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ImageLength");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ImageProducer");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ImageWidth");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.MeteringMode");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.Methodology");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.MimeType");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.Orientation");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.OS");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.OSVersion");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PerformanceData");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PixelSize");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PlanarConfiguration");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PreferredPresentation");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PrimaryChromaticitiesBlueX");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PrimaryChromaticitiesBlueY");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PrimaryChromaticitiesGreenX");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PrimaryChromaticitiesGreenY");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PrimaryChromaticitiesRedX");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.PrimaryChromaticitiesRedY");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ProcessingActions");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ProcessingAgency");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ProcessingSoftwareName");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ProcessingSoftwareVersion");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ProfileName");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.Profiles");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ProfileURL");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ReferenceBlackWhite");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.RowsPerStrip");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SamplesPerPixel");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SamplingFrequencyPlane");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SamplingFrequencyUnit");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ScannerManufacturer");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ScannerModelName");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ScannerModelNumber");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ScannerModelSerialNo");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ScanningSoftware");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ScanningSoftwareVersionNo");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SceneIlluminant");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SegmentType");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.Sensor");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SourceData");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SourceID");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SourceType");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SourceXDimension");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SourceXDimensionUnit");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SourceYDimension");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SourceYDimensionUnit");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.StripByteCounts");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.StripOffsets");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.SubjectDistance");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TargetIDManufacturer");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TargetIDMedia");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TargetIDName");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TargetIDNo");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TargetType");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TileByteCounts");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TileLength");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TileOffsets");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.TileWidth");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.ViewerData");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.WhitePointXValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.WhitePointYValue");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.XPhysScanResolution");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.XPrintAspectRatio");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.XSamplingFrequency");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.XTargetedDisplayAR");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.YCbCrCoefficients");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.YCbCrPositioning");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.YCbCrSubSampling");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.YPhysScanResolution");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.YPrintAspectRatio");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.YSamplingFrequency");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NisoImageMetadata.YTargetedDisplayAR");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.NumberOfInks");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.SampleFormat");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.Threshholding");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFEPProperties.ImageNumber");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFEPProperties.InterColourProfile");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFEPProperties.TimeZoneOffset");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFITProperties.BackgroundColorIndicator");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFITProperties.BitsPerExtendedRunLength");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFITProperties.BitsPerRunLength");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFITProperties.ImageColorIndicator");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFITProperties.PixelIntensityRange");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFITProperties.RasterPadding");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TIFFITProperties.TransparencyIndicator");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.TransferRange");
        	 attList.add("TIFFMetadata.IFDs.IFD.Entries.XMP");
        	 attList.add("TIFFMetadata.IFDs.IFD.Offset");
        	 attList.add("TIFFMetadata.IFDs.IFD.Type");
        	 attList.add("TIFFMetadata.IFDs.Number");

         }

    @Override
    public void extract(String fileName) throws Exception {

            super.extract(fileName,jhoveModule,pluginVersion);
            super.setImageCount(sumMultiplePage());

    }

    private int sumMultiplePage(){
    	int sum=0;
    	RepInfo ri = super.getRepinfo();
    	if (ri == null)
    		return 0;

    	Property prop = ri.getByName(multiPagePropertyToCheck);
    	if (prop == null)
    		return 0;

    	List<Property> propertyList = (List)prop.getValue();
    	for(Property property : propertyList){
    		if(property.getName().equalsIgnoreCase(multiPagePropertyToCount)){
    			Property[] IFDPropertyList = (Property[])property.getValue();
    			if(IFDPropertyList[1].getValue().equals(multiPagePropertyValueToCount)){
    				sum++;
    			}
    		}
    	}
    	return sum;
    }

    @Override
    public List<String> getSupportedAttributeNames() {
        return attList;
    }


    public String getAgentName()
    {
    	return "JHOVE , TIFF-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}

}
