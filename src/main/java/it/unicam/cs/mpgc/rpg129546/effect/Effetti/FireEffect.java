package it.unicam.cs.mpgc.rpg129546.effect.Effetti;

import it.unicam.cs.mpgc.rpg129546.effect.TickType;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class FireEffect implements Effect{
    private final int duration = 2;
    public int tick = duration;
    private final int dmg = 10;
    public String nome = "bruciato";
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
        return TickType.DOT;
    }

    @Override
    public void damageOverTime(Entity e){
        e.getStatusManager().takeDamage(dmg);
    }

}
