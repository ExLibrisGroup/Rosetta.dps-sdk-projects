package com.exlibris.rosetta.repository.plugin.mdExtractor.jpeg2000;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class JPEG2000HULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(JPEG2000HULMDExtractorPlugin.class);
    private static String jhoveModule =  "JPEG2000-hul";
    private static String multiPagePropertyToCheck = "Codestreams";
    private static String multiPagePropertyToCount = "Codestream";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
         static {
        	 attList.add("JPEG2000Metadata.Brand");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.CodeBlockHeight");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.CodeBlockStyle");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.CodeBlockWidth");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.CodingStyle");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.MultipleComponentTransformation");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.NumberDecompositionLevels");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.NumberOfLayers");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.ProgressionOrder");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.CodingStyleDefault.Transformation");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.Comments.Comment[0]");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.Capabilities");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.CSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.SSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.XOSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.XRSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.XSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.XTOSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.XTSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.YOSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.YRSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.YSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.YTOSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.ImageAndTileSize.YTSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.AutoFocus");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.BackLight");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.BitsPerSample");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.Brightness");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ByteOrder");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ChecksumMethod");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ChecksumValue");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.Class");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ColormapBitCodeValue");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ColormapBlueValue");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ColormapGreenValue");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ColormapRedValue");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ColormapReference");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ColorSpace");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ColorTemp");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.CompressionLevel");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.CompressionScheme");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.DateTimeCreated");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.DateTimeProcessed");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.DeviceSource");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.DigitalCameraManufacturer");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.DigitalCameraModel");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.DisplayOrientation");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ExposureBias");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ExposureIndex");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ExposureTime");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ExtraSamples");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.FileSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.Flash");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.FlashEnergy");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.FlashReturn");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.FNumber");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.FocalLength");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.GrayResponseCurve");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.GrayResponseUnit");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.HostComputer");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ImageData");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ImageIdentifier");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ImageIdentifierLocation");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ImageLength");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ImageProducer");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ImageWidth");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.MeteringMode");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.Methodology");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.MimeType");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.Orientation");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.OS");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.OSVersion");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PerformanceData");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PixelSize");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PlanarConfiguration");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PreferredPresentation");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PrimaryChromaticitiesBlueX");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PrimaryChromaticitiesBlueY");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PrimaryChromaticitiesGreenX");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PrimaryChromaticitiesGreenY");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PrimaryChromaticitiesRedX");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.PrimaryChromaticitiesRedY");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ProcessingActions");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ProcessingAgency");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ProcessingSoftwareName");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ProcessingSoftwareVersion");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ProfileName");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.Profiles");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ProfileURL");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ReferenceBlackWhite");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.RowsPerStrip");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SamplesPerPixel");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SamplingFrequencyPlane");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SamplingFrequencyUnit");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ScannerManufacturer");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ScannerModelName");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ScannerModelNumber");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ScannerModelSerialNo");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ScanningSoftware");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ScanningSoftwareVersionNo");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SceneIlluminant");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SegmentType");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.Sensor");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SourceData");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SourceID");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SourceType");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SourceXDimension");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SourceXDimensionUnit");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SourceYDimension");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SourceYDimensionUnit");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.StripByteCounts");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.StripOffsets");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.SubjectDistance");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TargetIDManufacturer");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TargetIDMedia");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TargetIDName");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TargetIDNo");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TargetType");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TileByteCounts");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TileLength");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TileOffsets");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.TileWidth");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.ViewerData");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.WhitePointXValue");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.WhitePointYValue");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.XPhysScanResolution");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.XPrintAspectRatio");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.XSamplingFrequency");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.XTargetedDisplayAR");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.YCbCrCoefficients");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.YCbCrPositioning");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.YCbCrSubSampling");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.YPhysScanResolution");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.YPrintAspectRatio");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.YSamplingFrequency");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.NisoImageMetadata.YTargetedDisplayAR");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.QuantizationDefault.QuantizationStyle");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.QuantizationDefault.StepValue");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.Tiles.Tile.TilePart.Index");
        	 attList.add("JPEG2000Metadata.Codestreams.Codestream.Tiles.Tile.TilePart.Length");
        	 attList.add("JPEG2000Metadata.ColorspaceUnknown");
        	 attList.add("JPEG2000Metadata.ColorSpecs.ColorSpec.Approx");
        	 attList.add("JPEG2000Metadata.ColorSpecs.ColorSpec.EnumCS");
        	 attList.add("JPEG2000Metadata.ColorSpecs.ColorSpec.Method");
        	 attList.add("JPEG2000Metadata.ColorSpecs.ColorSpec.Precedence");
        	 attList.add("JPEG2000Metadata.ColorSpecs.ColorSpec.RestrictedICCProfile");
        	 attList.add("JPEG2000Metadata.Compatibility");
        	 attList.add("JPEG2000Metadata.DefaultDisplayResolution.HorizResolution.Denominator");
        	 attList.add("JPEG2000Metadata.DefaultDisplayResolution.HorizResolution.Exponent");
        	 attList.add("JPEG2000Metadata.DefaultDisplayResolution.HorizResolution.Numerator");
        	 attList.add("JPEG2000Metadata.DefaultDisplayResolution.VertResolution.Denominator");
        	 attList.add("JPEG2000Metadata.DefaultDisplayResolution.VertResolution.Exponent");
        	 attList.add("JPEG2000Metadata.DefaultDisplayResolution.VertResolution.Numerator");
        	 attList.add("JPEG2000Metadata.MinorVersion");
        	 attList.add("JPEG2000Metadata.XML");


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
    	return "JHOVE , JPEG2000-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}


}
