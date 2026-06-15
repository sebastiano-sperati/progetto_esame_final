package it.unicam.cs.mpgc.rpg129546.Effects.Effect;

import it.unicam.cs.mpgc.rpg129546.Effects.TickType;

public class BlessEffect implements Effect{
    private final int duration = 3;
    public int tick = duration;
    public String nome = "benedizione";
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
        return dif * 2;
    }
}
