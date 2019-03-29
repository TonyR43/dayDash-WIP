package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sound
{
    @Id
    private int soundId;
    private byte[] sound;

    public int getSoundId()
    {
        return soundId;
    }

    public byte[] getSound()
    {
        return sound;
    }
}
