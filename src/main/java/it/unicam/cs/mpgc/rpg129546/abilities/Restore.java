package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class Restore implements Action{
    private final int cost = 6;
    @Override
    public void execute(Entity source, Entity target) {
        if(!source.isAlly(target)){
            System.out.println("non puoi aiutare un nemico");
            return;
        }
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        target.restore(6);
    }
}
