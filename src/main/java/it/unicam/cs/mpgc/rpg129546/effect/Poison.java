package it.unicam.cs.mpgc.rpg129546.effect;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class Poison implements Effect{
    private final int duration = 3;
    public int tick = duration;
    public String nome = "avvelenato";
    private final int dmg = 5;
    @Override
    public void tick() {
        tick--;
    }

    @Override
    public boolean isExpired() {
        return tick==0;
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
        return tickType.DOT;
    }

    @Override
    public void damageOverTime(Entity e){
        e.takeDamage(dmg);
    }
}
