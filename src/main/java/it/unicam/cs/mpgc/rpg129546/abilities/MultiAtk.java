package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class MultiAtk implements Action {
    private final int cost = 8;
    private final String nome = "multiattacco";

    @Override
    public void execute(Entity source, Entity target) {
        if (source.getAp() < cost) return;
        source.consumeAp(cost);
        BaseAtk.applyAttack(source,target,1.0);
        BaseAtk.applyAttack(source,target,1.0);
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
