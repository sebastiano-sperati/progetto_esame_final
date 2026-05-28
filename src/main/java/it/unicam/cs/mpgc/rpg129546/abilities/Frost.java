package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.effect.FrostEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Frost implements Action{
    private final int cost = 4;
    private final String nome = "congelamento";
    private final double frostChance = 0.25;

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :LE DEE DEL GHIACCIO MI BENEDICONO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }
        BaseAtk.applyAttack(source, target, 0.7);
        if(Math.random()<frostChance) target.getManager().addEffect(new FrostEffect());
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
