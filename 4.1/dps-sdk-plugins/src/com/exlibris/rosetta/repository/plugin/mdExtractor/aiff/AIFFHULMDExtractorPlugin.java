package com.exlibris.rosetta.repository.plugin.mdExtractor.aiff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exlibris.core.infra.common.exceptions.logging.ExLogger;
import com.exlibris.rosetta.repository.plugin.mdExtractor.base.AbstractJhoveMDExtractorPlugin;


public class AIFFHULMDExtractorPlugin extends AbstractJhoveMDExtractorPlugin{

    private static ExLogger log = ExLogger.getExLogger(AIFFHULMDExtractorPlugin.class);
    private static String jhoveModule =  "AIFF-hul";
    private static final String PLUGIN_VERSION_INIT_PARAM = "PLUGIN_VERSION_INIT_PARAM";
    private String pluginVersion = null;

    private static List<String> attList = new ArrayList<String>();
    static {


    	attList.add("AIFFMetadata.AESAudioMetadata.AnalogDigitalFlag");
    	attList.add("AIFFMetadata.AESAudioMetadata.AudioDataEncoding");
    	attList.add("AIFFMetadata.AESAudioMetadata.ByteOrder");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.FrameCount");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.TimeBase");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.VideoField");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.CountingMode");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.Hours");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.Minutes");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.Frames");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.Samples.SampleRate");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.Samples.NumberOfSamples");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.FilmFraming.Framing");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Start.FilmFraming.Type");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.FrameCount");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.TimeBase");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.VideoField");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.CountingMode");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.Hours");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.Minutes");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.Seconds");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.Frames");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.Samples.SamplesRate");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.Samples.NumberofSamples");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.FilmFraming.Framing");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.TimeLine.Duration.FilmFraming.Type");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.NumChannels");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.FrameCount");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.TimeBase");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.VideoField");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.CountingMode");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Hours");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Minutes");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Seconds");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Frames");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Samples.SampleRate");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.Samples.NumberOfSamples");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.FilmFraming.Framing");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Start.FilmFraming.Type");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.FrameCount");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.TimeBase");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.VideoField");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.CountingMode");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Hours");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Minutes");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Seconds");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Frames");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Samples.SamplesRate");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.Samples.NumberofSamples");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.FilmFraming.Framing");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.TimeRange.Duration.FilmFraming.Type");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Region.Stream.ChannelAssignment");
    	attList.add("AIFFMetadata.AESAudioMetadata.FirstSampleOffset");
    	attList.add("AIFFMetadata.AESAudioMetadata.Format");
    	attList.add("AIFFMetadata.AESAudioMetadata.Format.SpecificationVersion");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.BitDepth");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.SampleRate");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecName");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecNameVersion");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecCreatorApplication");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecCreatorApplicationVersion");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.codecQuality");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.dataRate");
    	attList.add("AIFFMetadata.AESAudioMetadata.FormatList.FormatRegion.BitrateReduction.dataRateMode");
    	attList.add("AIFFMetadata.AESAudioMetadata.PrimaryIdentifier");
    	attList.add("AIFFMetadata.AESAudioMetadata.PrimaryIdentifier.Identifier Type");
    	attList.add("AIFFMetadata.AESAudioMetadata.SampleFrames");
    	attList.add("AIFFMetadata.AESAudioMetadata.SchemaVersion");
    	attList.add("AIFFMetadata.SoundData.Offset");
    	attList.add("AIFFMetadata.SoundData.BlockSize");
    	attList.add("AIFFMetadata.SoundData.DataLength");
    	attList.add("AIFFMetadata.AESAudioMetadata.Use.UseType");
    	attList.add("AIFFMetadata.AESAudioMetadata.Use.OtherType");
    	attList.add("AIFFMetadata.Annotations");
    	attList.add("AIFFMetadata.Author");
    	attList.add("AIFFMetadata.CompressionName");
    	attList.add("AIFFMetadata.CompressionType");
    	attList.add("AIFFMetadata.Copyright");
    	attList.add("AIFFMetadata.FormatVersion");
    	attList.add("AIFFMetadata.Instrument.Basenote");
    	attList.add("AIFFMetadata.Instrument.Detune");
    	attList.add("AIFFMetadata.Instrument.Gain");
    	attList.add("AIFFMetadata.Instrument.HighNote");
    	attList.add("AIFFMetadata.Instrument.Highvelocity");
    	attList.add("AIFFMetadata.Instrument.LowNote");
    	attList.add("AIFFMetadata.Instrument.Lowvelocity");
    	attList.add("AIFFMetadata.Instrument.ReleaseLoop.PlayMode");
    	attList.add("AIFFMetadata.Instrument.ReleaseLoop.BeginLoop");
    	attList.add("AIFFMetadata.Instrument.ReleaseLoop.EndLoop");
    	attList.add("AIFFMetadata.Instrument.SustainLoop.PlayMode");
    	attList.add("AIFFMetadata.Instrument.SustainLoop.BeginLoop");
    	attList.add("AIFFMetadata.Instrument.SustainLoop.EndLoop");
    	attList.add("AIFFMetadata.Name");
    	attList.add("AIFFMetadata.Profiles");
    	attList.add("AIFFMetadata.SamplesFrames");
    	attList.add("AIFFMetadata.AESAudioMetadata.Face.Timeline.Start.Seconds");


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
    	return "JHOVE , AIFF-hul " + getRelease();
    }

    public String getAgent()
    {
    	return getAgentName() + " , Plugin Version " + pluginVersion;
    }

    public void initParams(Map<String, String> initParams) {
		this.pluginVersion = initParams.get(PLUGIN_VERSION_INIT_PARAM);
	}
}
