package it.unicam.cs.mpgc.rpg129546.Effects.Effect;

import it.unicam.cs.mpgc.rpg129546.Effects.TickType;

public class StrenghtEffect implements Effect{
    private final int duration = 2;
    public int tick = duration;
    public String nome = "rafforzamento";
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
    public int modifyAtk(int atk){
        return (int) (atk * 1.5);
    }
}
