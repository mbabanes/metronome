package sound;

import javax.sound.midi.*;


public class MetronomeThread extends Thread
{
    private long bmp;
    private Metronome metronome;

    public MetronomeThread(){}

    public MetronomeThread(long bmp)
    {
        super("Metronome");
        this.bmp = bmp;
    }

    private long countIntervalTime()
    {
        float intervalTime = 1000 / (bmp / 60.f);
        return (long) intervalTime;
    }

    @Override
    public void run()
    {
        long intervalTime = countIntervalTime();
        try
        {
            metronome = new Metronome(intervalTime);
            metronome.play();
        }
        catch (MidiUnavailableException e)
        {
        }
        catch (InterruptedException e)
        {
        }
    }

    @Override
    public void interrupt()
    {
        super.interrupt();
        metronome.closeSynthesizer();
    }

    public boolean alive()
    {
        return isAlive();
    }
}
