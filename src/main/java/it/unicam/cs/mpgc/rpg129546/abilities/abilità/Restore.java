package it.unicam.cs.mpgc.rpg129546.abilities.abilità;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Restore implements Action{
    private final int cost = 6;
    private final String nome = "ristoro";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :stringi i denti ancora per un po... " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }

        target.restore(6);
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
