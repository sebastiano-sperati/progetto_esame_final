package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class Lightning implements Action{
    private final int cost = 8;
    private final String nome = "fulmine";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost)return;
        source.consumeAp(cost);
        //inserire metodo ber bersagliare si il nemico più i nemici ai suoi fianchi, con dmg -50%
    }
    @Override
    public String getNome(){
        return this.nome;
    }
    @Override
    public int getCosto(){
        return this.cost;
    }
}
