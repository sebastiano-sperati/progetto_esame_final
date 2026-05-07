package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class FireBall implements Action{
    private final int cost = 6;
    private final String nome = "palla di fuoco";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        BaseAtk.applyAttack(source,target,1.0);
        if(Math.random() < source.getFireChance()){
            target.setOnFire(true);
        }
    }
    @Override
    public String getNome(){
        return this.nome;
    }
    @Override
    public int getCosto(){
        return this.cost;
    }
    @Override
    public TargetType getTargetType(){ return TargetType.ENEMY;}

}
