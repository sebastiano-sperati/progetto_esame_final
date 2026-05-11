package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.effect.Effect;
import it.unicam.cs.mpgc.rpg129546.effect.counterEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;
import it.unicam.cs.mpgc.rpg129546.effect.Effect;

public class Counter implements Action{
    private final int cost = 6;
    private final String nome = "contrattacco";

    @Override
    public void execute(Entity source, Entity target) {
    if(source.getAp() < cost) return;
    source.consumeAp(cost);
    source.getManager().addEffect(new counterEffect());
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
