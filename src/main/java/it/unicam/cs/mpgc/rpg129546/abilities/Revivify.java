package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Revivify implements Action{
    private final int cost = 8;
    private final String nome = "resurrezione";

    @Override
    public void execute(Entity source, Entity target) {
        if(!source.isAlly(target)){
            System.out.println("non puoi rianimare un nemico");
            return;
        }
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        target.setAlive(true);
        int heal = target.getScaledHp()/2;
        target.Heal(heal);
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
    public TargetType getTargetType(){ return TargetType.ALLY;}

}
