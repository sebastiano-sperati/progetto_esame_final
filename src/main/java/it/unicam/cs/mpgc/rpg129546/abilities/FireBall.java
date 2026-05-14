package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.effect.FireEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class FireBall implements Action{
    private final int cost = 6;
    private final String nome = "palla di fuoco";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getAp() < cost) return;
        source.consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :LE FIAMME MI GRAZIANO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }        BaseAtk.applyAttack(source,target,1.0);
       // if(Math.random() < source.getFireChance()){
        //    target.getManager().addEffect(new FireEffect());
        //}
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
