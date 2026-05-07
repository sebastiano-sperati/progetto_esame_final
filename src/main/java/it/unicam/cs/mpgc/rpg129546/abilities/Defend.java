package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Defend implements Action{
    private final int cost = 2;
    private final String nome = "difesa";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        source.setDefendig(true);
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
    public TargetType getTargetType(){ return TargetType.SELF;}

}
