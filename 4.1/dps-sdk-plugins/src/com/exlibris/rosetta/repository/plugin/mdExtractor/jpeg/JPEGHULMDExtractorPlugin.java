package com.exlibris.rosetta.repository.plugin.mdExtractor.jpeg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;

public class JPEGHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(JPEGHULMDExtractorPlugin.class);
    private static String jhoveModule =  "JPEG-hul";
    private static String multiPagePropertyToCheck = "Images";
    private static String multiPagePropertyToCount = "Image";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
         static {
        	 attList.add("JPEGMetadata.ApplicationSegments");
        	 attList.add("JPEGMetadata.Comments");
        	 attList.add("JPEGMetadata.CompressionType");
        	 attList.add("JPEGMetadata.Images.Image.Exif.ApertureValue");
        	 attList.add("JPEGMetadata.Images.Image.Exif.ColorSpace");
        	 attList.add("JPEGMetadata.Images.Image.Exif.ComponentsConfiguration");
        	 attList.add("JPEGMetadata.Images.Image.Exif.CompressedBitsPerPixel");
        	 attList.add("JPEGMetadata.Images.Image.Exif.CustomRendered");
        	 attList.add("JPEGMetadata.Images.Image.Exif.DateTimeOriginal");
        	 attList.add("JPEGMetadata.Images.Image.Exif.ExifVersion");
        	 attList.add("JPEGMetadata.Images.Image.Exif.ExposureBiasValue");
        	 attList.add("JPEGMetadata.Images.Image.Exif.ExposureProgram");
        	 attList.add("JPEGMetadata.Images.Image.Exif.ExposureTime");
        	 attList.add("JPEGMetadata.Images.Image.Exif.FileSource");
        	 attList.add("JPEGMetadata.Images.Image.Exif.Flash");
        	 attList.add("JPEGMetadata.Images.Image.Exif.FlashpixVersion");
        	 attList.add("JPEGMetadata.Images.Image.Exif.FNumber");
        	 attList.add("JPEGMetadata.Images.Image.Exif.FocalLength");
        	 attList.add("JPEGMetadata.Images.Image.Exif.FocalLengthIn35mmFilm");
        	 attList.add("JPEGMetadata.Images.Image.Exif.FocalPlaneResolutionUnit");
        	 attList.add("JPEGMetadata.Images.Image.Exif.LightSource");
        	 attList.add("JPEGMetadata.Images.Image.Exif.MakerNote");
        	 attList.add("JPEGMetadata.Images.Image.Exif.MaxApertureValue");
        	 attList.add("JPEGMetadata.Images.Image.Exif.MeteringMode");
        	 attList.add("JPEGMetadata.Images.Image.Exif.PixelXDimension");
        	 attList.add("JPEGMetadata.Images.Image.Exif.PixelYDimension");
        	 attList.add("JPEGMetadata.Images.Image.Exif.Saturation");
        	 attList.add("JPEGMetadata.Images.Image.Exif.SceneCaptureType");
        	 attList.add("JPEGMetadata.Images.Image.Exif.SceneType");
        	 attList.add("JPEGMetadata.Images.Image.Exif.Sharpness");
        	 attList.add("JPEGMetadata.Images.Image.Exif.ShutterSpeedValue");
        	 attList.add("JPEGMetadata.Images.Image.Exif.SubjectDistance");
        	 attList.add("JPEGMetadata.Images.Image.Exif.SubjectDistanceRange");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.AutoFocus");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.BackLight");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.BitsPerSample");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.Brightness");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ByteOrder");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ChecksumMethod");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ChecksumValue");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.Class");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ColormapBitCodeValue");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ColormapBlueValue");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ColormapGreenValue");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ColormapRedValue");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ColormapReference");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ColorSpace");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ColorTemp");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.CompressionLevel");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.CompressionScheme");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.DateTimeCreated");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.DateTimeProcessed");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.DeviceSource");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.DigitalCameraManufacturer");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.DigitalCameraModel");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.DisplayOrientation");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ExposureBias");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ExposureIndex");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ExposureTime");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ExtraSamples");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.FileSize");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.Flash");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.FlashEnergy");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.FlashReturn");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.FNumber");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.FocalLength");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.GrayResponseCurve");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.GrayResponseUnit");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.HostComputer");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ImageData");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ImageIdentifier");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ImageIdentifierLocation");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ImageLength");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ImageProducer");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ImageWidth");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.MeteringMode");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.Methodology");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.MimeType");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.Orientation");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.OS");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.OSVersion");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PerformanceData");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PixelSize");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PlanarConfiguration");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PreferredPresentation");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesBlueX");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesBlueY");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesGreenX");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesGreenY");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesRedX");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesRedY");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ProcessingActions");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ProcessingAgency");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ProcessingSoftwareName");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ProcessingSoftwareVersion");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ProfileName");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.Profiles");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ProfileURL");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ReferenceBlackWhite");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.RowsPerStrip");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SamplesPerPixel");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SamplingFrequencyPlane");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SamplingFrequencyUnit");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ScannerManufacturer");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ScannerModelName");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ScannerModelNumber");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ScannerModelSerialNo");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ScanningSoftware");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ScanningSoftwareVersionNo");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SceneIlluminant");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SegmentType");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.Sensor");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SourceData");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SourceID");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SourceType");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SourceXDimension");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SourceXDimensionUnit");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SourceYDimension");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SourceYDimensionUnit");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.StripByteCounts");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.StripOffsets");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.SubjectDistance");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TargetIDManufacturer");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TargetIDMedia");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TargetIDName");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TargetIDNo");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TargetType");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TileByteCounts");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TileLength");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TileOffsets");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.TileWidth");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.ViewerData");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.WhitePointXValue");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.WhitePointYValue");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.XPhysScanResolution");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.XPrintAspectRatio");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.XSamplingFrequency");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.XTargetedDisplayAR");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.YCbCrCoefficients");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.YCbCrPositioning");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.YCbCrSubSampling");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.YPhysScanResolution");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.YPrintAspectRatio");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.YSamplingFrequency");
        	 attList.add("JPEGMetadata.Images.Image.NisoImageMetadata.YTargetedDisplayAR");
        	 attList.add("JPEGMetadata.Images.Image.PixelAspectRatio.PixelAspectRatioX");
        	 attList.add("JPEGMetadata.Images.Image.PixelAspectRatio.PixelAspectRatioY");
        	 attList.add("JPEGMetadata.Images.Image.QuantizationTables.QuantizationTable.DestinationIdentifier");
        	 attList.add("JPEGMetadata.Images.Image.QuantizationTables.QuantizationTable.Precision");
        	 attList.add("JPEGMetadata.Images.Image.RestartInterval");
        	 attList.add("JPEGMetadata.Images.Image.Scans");
        	 attList.add("JPEGMetadata.Images.Number");
        	 attList.add("JPEGMetadata.Images.Image.XMP");

         }

    @Override
    public void extract(String fileName) throws Exception {
    	super.extract(fileName,jhoveModule, multiPagePropertyToCheck, multiPagePropertyToCount,pluginVersion);
    }

    @Override
    public List<String> getSupportedAttributeNames() {
        return attList;
    }

    public String getAgentName()
    {
    	return "JHOVE , JPEG-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}
}
