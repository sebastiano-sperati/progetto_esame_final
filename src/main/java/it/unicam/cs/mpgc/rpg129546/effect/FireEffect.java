package it.unicam.cs.mpgc.rpg129546.effect;

public class FireEffect implements Effect{
    private final int duration = 2;
    public int tick = 0;
    @Override
    public void tick() {
        tick--;
        //*molto probabilmente con lo scalare di ogni tick dato che il nemico prende danno di può benissimo richiamare take damage, ma adesso ci ragioniamo
    }

    @Override
    public boolean isExpired() {
        return tick == 0;
    }

    @Override
    public int getDuration() {
        return duration;
    }

}
