package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.effect.ScaredEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Fear implements Action{
    private final int cost = 8;
    private final String nome = "intimidire";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.isAlly(target)){
            System.out.println("non puoi attaccare un alleato");
            return;
        }
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        target.getManager().addEffect(new ScaredEffect());
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
