package it.unicam.cs.mpgc.rpg129546.effect;

public class ScaredEffect implements Effect{
    private final int duration = 3;
    public int tick = duration;
    public String nome = "spaventato";
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
    public String getNome() {
        return nome;
    }

    @Override
    public int getTick() {
        return tick;
    }

    @Override
    public tickType getType() {
        return tickType.STATMOD;
    }

    @Override
    public int modifyDif(int dif){
        return (int) (dif * 0.75);
    }
}
