package com.exlibris.rosetta.repository.plugin.mdExtractor.pdf;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;

public class PDFHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(PDFHULMDExtractorPlugin.class);
    private static String jhoveModule =  "PDF-hul";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
    static {

    	attList.add("PDFMetadata.DocumentCatalog.PageLayout");
    	attList.add("PDFMetadata.DocumentCatalog.PageMode");
    	attList.add("PDFMetadata.Encryption.Algorithm");
    	attList.add("PDFMetadata.Encryption.EFF");
    	attList.add("PDFMetadata.Encryption.KeyLength");
    	attList.add("PDFMetadata.Encryption.SecurityHandler");
    	attList.add("PDFMetadata.Encryption.StandardSecurityHandler.OwnerString");
    	attList.add("PDFMetadata.Encryption.StandardSecurityHandler.Revision");
    	attList.add("PDFMetadata.Encryption.StandardSecurityHandler.UserAccess");
    	attList.add("PDFMetadata.Encryption.StandardSecurityHandler.UserString");
    	attList.add("PDFMetadata.Filters.FilterPipeline");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.BaseFont");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.EncodingDictionary.BaseEncoding");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.EncodingDictionary.Differences");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.FirstChar");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.FontDescriptor.Flags");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.FontDescriptor.FontBBox");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.FontDescriptor.FontFile2");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.FontDescriptor.FontName");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.FontSubset");
    	attList.add("PDFMetadata.Fonts.TrueType.Font.LastChar");
    	attList.add("PDFMetadata.Fonts.Type1.Font.BaseFont");
    	attList.add("PDFMetadata.FreeObjects");
    	attList.add("PDFMetadata.ID");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.AutoFocus");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.BackLight");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.BitsPerSample");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.Brightness");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ByteOrder");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ChecksumMethod");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ChecksumValue");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.Class");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ColormapBitCodeValue");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ColormapBlueValue");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ColormapGreenValue");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ColormapRedValue");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ColormapReference");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ColorSpace");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ColorTemp");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.CompressionLevel");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.CompressionScheme");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.DateTimeCreated");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.DateTimeProcessed");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.DeviceSource");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.DigitalCameraManufacturer");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.DigitalCameraModel");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.DisplayOrientation");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ExposureBias");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ExposureIndex");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ExposureTime");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ExtraSamples");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.FileSize");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.Flash");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.FlashEnergy");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.FlashReturn");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.FNumber");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.FocalLength");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.GrayResponseCurve");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.GrayResponseUnit");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.HostComputer");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ImageData");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ImageIdentifier");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ImageIdentifierLocation");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ImageLength");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ImageProducer");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ImageWidth");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.MeteringMode");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.Methodology");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.MimeType");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.Orientation");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.OS");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.OSVersion");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PerformanceData");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PixelSize");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PlanarConfiguration");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PreferredPresentation");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesBlueX");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesBlueY");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesGreenX");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesGreenY");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesRedX");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.PrimaryChromaticitiesRedY");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ProcessingActions");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ProcessingAgency");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ProcessingSoftwareName");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ProcessingSoftwareVersion");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ProfileName");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.Profiles");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ProfileURL");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ReferenceBlackWhite");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.RowsPerStrip");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SamplesPerPixel");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SamplingFrequencyPlane");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SamplingFrequencyUnit");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ScannerManufacturer");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ScannerModelName");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ScannerModelNumber");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ScannerModelSerialNo");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ScanningSoftware");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ScanningSoftwareVersionNo");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SceneIlluminant");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SegmentType");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.Sensor");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SourceData");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SourceID");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SourceType");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SourceXDimension");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SourceXDimensionUnit");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SourceYDimension");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SourceYDimensionUnit");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.StripByteCounts");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.StripOffsets");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.SubjectDistance");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TargetIDManufacturer");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TargetIDMedia");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TargetIDName");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TargetIDNo");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TargetType");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TileByteCounts");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TileLength");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TileOffsets");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.TileWidth");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.ViewerData");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.WhitePointXValue");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.WhitePointYValue");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.XPhysScanResolution");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.XPrintAspectRatio");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.XSamplingFrequency");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.XTargetedDisplayAR");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.YCbCrCoefficients");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.YCbCrPositioning");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.YCbCrSubSampling");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.YPhysScanResolution");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.YPrintAspectRatio");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.YSamplingFrequency");
    	attList.add("PDFMetadata.Images.Image.NisoImageMetadata.YTargetedDisplayAR");
    	attList.add("PDFMetadata.IncrementalUpdates");
    	attList.add("PDFMetadata.Info.Author");
    	attList.add("PDFMetadata.Info.CreationDate");
    	attList.add("PDFMetadata.Info.Creator");
    	attList.add("PDFMetadata.Info.Keywords");
    	attList.add("PDFMetadata.Info.ModDate");
    	attList.add("PDFMetadata.Info.Producer");
    	attList.add("PDFMetadata.Info.Subject");
    	attList.add("PDFMetadata.Info.Title");
    	attList.add("PDFMetadata.Objects");
    	attList.add("PDFMetadata.Pages.Page.Sequence");
    	attList.add("PDFMetadata.XMP");

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
    	return "JHOVE , PDF-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}




}
