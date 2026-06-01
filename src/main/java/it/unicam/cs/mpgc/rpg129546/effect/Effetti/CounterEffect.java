package it.unicam.cs.mpgc.rpg129546.effect.Effetti;

import it.unicam.cs.mpgc.rpg129546.effect.TickType;

public class CounterEffect implements Effect{
    private final int duration = 1;
    public int tick = duration;
    private String nome = "contrattacco";
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
    public TickType getType() {
        return TickType.STATMOD;
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
