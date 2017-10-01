package sound;


public class MetronomeThreadNullObject extends MetronomeThread
{
    @Override
    public boolean alive()
    {
        return false;
    }
}
