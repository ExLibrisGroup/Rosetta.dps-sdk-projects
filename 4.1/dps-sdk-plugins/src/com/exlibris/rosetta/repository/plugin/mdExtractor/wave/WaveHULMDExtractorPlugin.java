package com.exlibris.rosetta.repository.plugin.mdExtractor.wave;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class WaveHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(WaveHULMDExtractorPlugin.class);
    private static String jhoveModule =  "WAVE-hul";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
    static {

    	attList.add("WAVEMetadata.AESAudioMetadata.AnalogDigitalFlag");
    	attList.add("WAVEMetadata.AESAudioMetadata.AudioDataEncoding");
    	attList.add("WAVEMetadata.AESAudioMetadata.ByteOrder");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.NumChannels");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.Stream.ChannelAssignment");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.CountingMode");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.FilmFraming.Framing");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.FilmFraming.Type");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.FrameCount");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Frames");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Hours");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Minutes");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Samples.NumberOfSamples");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Samples.SamplesRate");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Seconds");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.TimeBase");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.VideoField");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.CountingMode");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.FilmFraming.Framing");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.FilmFraming.Type");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.FrameCount");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Frames");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Hours");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Minutes");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Samples.NumberOfSamples");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Samples.SampleRate");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Seconds");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.TimeBase");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.VideoField");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.CountingMode");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.FilmFraming.Framing");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.FilmFraming.Type");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.FrameCount");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.Frames");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.Hours");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.Minutes");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.Samples.NumberOfSamples");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.Samples.SamplesRate");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.Seconds");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.TimeBase");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Duration.VideoField");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.CountingMode");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.FilmFraming.Framing");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.FilmFraming.Type");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.FrameCount");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.Frames");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.Hours");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.Minutes");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.Samples.NumberOfSamples");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.Samples.SampleRate");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.Seconds");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.TimeBase");
    	attList.add("WAVEMetadata.AESAudioMetadata.Face.TimeLine.Start.VideoField");
    	attList.add("WAVEMetadata.AESAudioMetadata.FirstSampleOffset");
    	attList.add("WAVEMetadata.AESAudioMetadata.Format");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.BitDepth");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecCreatorApplication");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecCreatorApplicationVersion");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecName");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecNameVersion");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecQuality");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.dataRate");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.dataRateMode");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.SampleRate");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.SoundField");
    	attList.add("WAVEMetadata.AESAudioMetadata.FormatList.FormatRegion.WordSize");
    	attList.add("WAVEMetadata.AESAudioMetadata.PrimaryIdentifier");
    	attList.add("WAVEMetadata.AESAudioMetadata.PrimaryIdentifier.IdentifierType");
    	attList.add("WAVEMetadata.AESAudioMetadata.SchemaVersion");
    	attList.add("WAVEMetadata.AESAudioMetadata.Use.OtherType");
    	attList.add("WAVEMetadata.AESAudioMetadata.Use.UseType");
    	attList.add("WAVEMetadata.AverageBytesPerSecond");
    	attList.add("WAVEMetadata.BlockAlign");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.CodingHistory");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.Description");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.OriginationDate");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.OriginationReference");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.OriginationTime");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.Originator");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.TimeReference");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.UMID");
    	attList.add("WAVEMetadata.BroadcastAudioExtension.Version");
    	attList.add("WAVEMetadata.CompressionCode");
    	attList.add("WAVEMetadata.Data.DataLength");
    	attList.add("WAVEMetadata.ListInfo.Artist");
    	attList.add("WAVEMetadata.ListInfo.Comment");
    	attList.add("WAVEMetadata.ListInfo.Track");


    }

    @Override
    public void extract(String fileName) throws Exception {

            super.extract(fileName,jhoveModule, pluginVersion);

    }

    @Override
    public List<String> getSupportedAttributeNames() {
        return attList;
    }

    public String getAgentName()
    {
    	return "JHOVE , WAVE-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}
}
