package it.unicam.cs.mpgc.rpg129546.effect;

public class AtkDebuffEffect implements Effect{
    private final int duration = 3;
    public int tick = 0;
    @Override
    public void tick() {
        tick--;
    }

    @Override
    public boolean isExpired() {
        return tick == 0;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public int modifyAtk(int atk) {
        return (int) (atk * 0.75);
    }

}
