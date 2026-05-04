package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class Ispirazione implements Action{
    private final int cost = 4;
    @Override
    public void execute(Entity source, Entity target) {
        if(!source.isAlly(target)){
            System.out.println("non puoi putenziare un nemico");
            return;
        }
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        target.setInspired(true);
    }
}
