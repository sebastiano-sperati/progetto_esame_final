package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class Revivify implements Action{
    private final int cost = 8;
    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        target.setAlive(true);
        int heal = target.getScaledHp()/2;
        target.Heal(heal);
    }
}
