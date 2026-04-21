package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class DebufAtk implements Action{
    private final int cost = 4;
    @Override
    public void execute(Entity source, Entity target) {
        if (source.getAp() < cost) return;
        source.consumeAp(cost);

        BaseAtk.applyAttack(source,target,0.7);
    }
}
