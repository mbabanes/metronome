package sound;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class A2Tone
{
    private static final int A2_TONE = 45;
    private static final int VOLUME = 193;

    private Synthesizer synthesizer;
    private MidiChannel[] midiChannels;

    private void initAndOpenSynthesizerAndInitMidiChannels()throws MidiUnavailableException
    {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        midiChannels = synthesizer.getChannels();
    }

    public void play() throws MidiUnavailableException
    {
        initAndOpenSynthesizerAndInitMidiChannels();
        midiChannels[1].noteOn(A2_TONE, VOLUME);
//        closeSynthesizer();
    }

    public void closeSynthesizer()
    {
        synthesizer.close();
    }
}
