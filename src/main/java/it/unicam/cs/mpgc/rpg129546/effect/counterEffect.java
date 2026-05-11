package it.unicam.cs.mpgc.rpg129546.effect;

public class counterEffect implements Effect{
    private final int duration = 1;
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
    public int modifyDif(int dif){
        return (int) (dif * 1.5);
    }

    @Override
    public double modifyEva(double eva){
        return eva * 1.5;
    }
}
