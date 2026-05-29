package it.unicam.cs.mpgc.rpg129546.abilities.abilità;

import it.unicam.cs.mpgc.rpg129546.effect.Effetti.blessEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class bless implements Action{
    private final int cost = 6;
    private final String nome = "benedici";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " : CHE LA GRAZIA SIA CON TE  " + target.getNome());
        } else {
            System.out.println(source.getNome() + " utilizza " + this.nome + " su " + target.getNome());
        }
        source.getEffectManager().addEffect(new blessEffect());
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
