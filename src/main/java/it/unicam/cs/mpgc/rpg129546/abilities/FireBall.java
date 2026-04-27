package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class FireBall implements Action{
    private final int cost = 6;
    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        BaseAtk.applyAttack(source,target,1.0);
        if(Math.random() < source.getFireChance()){
            target.setOnFire(true);
        }
    }
}
