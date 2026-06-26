package it.unicam.cs.mpgc.rpg129546.Effects.Effect;

import it.unicam.cs.mpgc.rpg129546.Effects.TickType;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

/**
 * fa si che un entita prenda @param dmg danni ogni tick per 3 turni
 */
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
    public TickType getType() {
        return TickType.DOT;
    }

    @Override
    public void damageOverTime(Entity e){
        System.out.println(e.getNome() + " subisce " + dmg + " danni da " + nome);
        e.getStatusManager().takeDamage(dmg);
    }
}
