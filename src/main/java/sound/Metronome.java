package sound;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Metronome
{
    private static final int KICK = 2;
    private static final int CLASH = 1;
    private static final int NOTE = 45;
    private static final int CLASH_VOLUME = 93;
    private static final int KICK_VOLUME = 93;


    private long intervalTime;
    private Synthesizer synthesizer;
    private MidiChannel[] midiChannel;


    public Metronome(long intervalTime) throws MidiUnavailableException
    {
        this.intervalTime = intervalTime;

        initAndOpenSynthesizerAndInitMidiChannels();
        changeInstrumentsInChannels();
    }

    public void play() throws InterruptedException
    {
        Thread.sleep(50);
        while (true)
        {
            playClash();
            playThreeKicks();
        }
    }


    public void closeSynthesizer()
    {
        synthesizer.close();
    }

    private void initAndOpenSynthesizerAndInitMidiChannels() throws MidiUnavailableException
    {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        midiChannel = synthesizer.getChannels();
    }

    private void changeInstrumentsInChannels()
    {
        midiChannel[CLASH].programChange(12);
        midiChannel[KICK].programChange(11);
    }

    private void playClash() throws InterruptedException
    {
        midiChannel[CLASH].noteOn(NOTE, CLASH_VOLUME);
        midiChannel[CLASH].allNotesOff();
        Thread.sleep(intervalTime);
    }

    private void playThreeKicks() throws InterruptedException
    {
        for (int j = 0; j < 3; j++)
        {
            midiChannel[KICK].noteOn(NOTE, KICK_VOLUME);
            midiChannel[KICK].allNotesOff();
            Thread.sleep(intervalTime);
        }
    }


}
