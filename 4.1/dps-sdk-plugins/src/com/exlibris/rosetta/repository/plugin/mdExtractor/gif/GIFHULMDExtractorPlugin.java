package com.exlibris.rosetta.repository.plugin.mdExtractor.gif;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class GIFHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(GIFHULMDExtractorPlugin.class);
    private static String jhoveModule =  "GIF-hul";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
    static {

    	attList.add("GIFMetadata.Blocks.GlobalColorTable");
    	attList.add("GIFMetadata.Blocks.GraphicControlExtension.DelayTime");
    	attList.add("GIFMetadata.Blocks.GraphicControlExtension.DisposalMethod");
    	attList.add("GIFMetadata.Blocks.GraphicControlExtension.TransparencyFlag");
    	attList.add("GIFMetadata.Blocks.GraphicControlExtension.TransparentColorIndex");
    	attList.add("GIFMetadata.Blocks.GraphicControlExtension.UserInputFlag");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.ImageLeftPosition");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.ImageTopPosition");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.InterlaceFlag");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.LocalColorTableFlag");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.LocalColorTableSize");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.LocalColorTableSortFlag");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.AutoFocus");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.BackLight");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.BitsPerSample");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.Brightness");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ByteOrder");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ChecksumMethod");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ChecksumValue");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.Class");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ColormapBitCodeValue");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ColormapBlueValue");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ColormapGreenValue");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ColormapRedValue");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ColormapReference");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ColorSpace");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ColorTemp");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.CompressionLevel");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.CompressionScheme");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.DateTimeCreated");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.DateTimeProcessed");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.DeviceSource");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.DigitalCameraManufacturer");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.DigitalCameraModel");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.DisplayOrientation");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ExposureBias");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ExposureIndex");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ExposureTime");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ExtraSamples");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.FileSize");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.Flash");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.FlashEnergy");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.FlashReturn");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.FNumber");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.FocalLength");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.GrayResponseCurve");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.GrayResponseUnit");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.HostComputer");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ImageData");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ImageIdentifier");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ImageIdentifierLocation");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ImageLength");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ImageProducer");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ImageWidth");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.MeteringMode");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.Methodology");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.MimeType");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.Orientation");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.OS");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.OSVersion");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PerformanceData");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PixelSize");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PlanarConfiguration");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PreferredPresentation");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PrimaryChromaticitiesBlueX");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PrimaryChromaticitiesBlueY");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PrimaryChromaticitiesGreenX");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PrimaryChromaticitiesGreenY");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PrimaryChromaticitiesRedX");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.PrimaryChromaticitiesRedY");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ProcessingActions");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ProcessingAgency");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ProcessingSoftwareName");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ProcessingSoftwareVersion");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ProfileName");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.Profiles");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ProfileURL");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ReferenceBlackWhite");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.RowsPerStrip");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SamplesPerPixel");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SamplingFrequencyPlane");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SamplingFrequencyUnit");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ScannerManufacturer");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ScannerModelName");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ScannerModelNumber");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ScannerModelSerialNo");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ScanningSoftware");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ScanningSoftwareVersionNo");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SceneIlluminant");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SegmentType");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.Sensor");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SourceData");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SourceID");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SourceType");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SourceXDimension");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SourceXDimensionUnit");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SourceYDimension");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SourceYDimensionUnit");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.StripByteCounts");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.StripOffsets");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.SubjectDistance");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TargetIDManufacturer");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TargetIDMedia");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TargetIDName");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TargetIDNo");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TargetType");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TileByteCounts");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TileLength");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TileOffsets");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.TileWidth");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.ViewerData");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.WhitePointXValue");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.WhitePointYValue");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.XPhysScanResolution");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.XPrintAspectRatio");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.XSamplingFrequency");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.XTargetedDisplayAR");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.YCbCrCoefficients");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.YCbCrPositioning");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.YCbCrSubSampling");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.YPhysScanResolution");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.YPrintAspectRatio");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.YSamplingFrequency");
    	attList.add("GIFMetadata.Blocks.ImageDescriptor.NisoImageMetadata.YTargetedDisplayAR");
    	attList.add("GIFMetadata.Blocks.LogicalScreenDescriptor.BackgroundColorIndex");
    	attList.add("GIFMetadata.Blocks.LogicalScreenDescriptor.ColorResolution");
    	attList.add("GIFMetadata.Blocks.LogicalScreenDescriptor.GlobalColorTableFlag");
    	attList.add("GIFMetadata.Blocks.LogicalScreenDescriptor.GlobalColorTableSize");
    	attList.add("GIFMetadata.Blocks.LogicalScreenDescriptor.GlobalColorTableSortFlag");
    	attList.add("GIFMetadata.Blocks.LogicalScreenDescriptor.LogicalScreenHeight");
    	attList.add("GIFMetadata.Blocks.LogicalScreenDescriptor.LogicalScreenWidth");
    	attList.add("GIFMetadata.Blocks.LogicalScreenDescriptor.PixelAspectRatio");
    	attList.add("GIFMetadata.GraphicRenderingBlocks");


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
    	return "JHOVE , GIF-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}


}
