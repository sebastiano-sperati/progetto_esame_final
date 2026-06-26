package it.unicam.cs.mpgc.rpg129546.Effects.Effect;

import it.unicam.cs.mpgc.rpg129546.Effects.TickType;

/**
 * applica ad un entità  una riduzione al danno del 25% per 3 turni
 */
public class AtkDebuffEffect implements Effect{
    private final int duration = 3;
    public int tick = duration;
    public String nome = "debilitazione";
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
    public int modifyAtk(int atk) {
        return (int) (atk * 0.75);
    }

}
