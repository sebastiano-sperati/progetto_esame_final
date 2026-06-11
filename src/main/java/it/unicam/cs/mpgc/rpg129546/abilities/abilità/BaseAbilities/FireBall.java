package it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.effect.Effetti.FireEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class FireBall implements Action {
    private final int cost = 6;
    private final String nome = "palla di fuoco";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);

        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :LE FIAMME MI GRAZIANO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }

        attack(source,target,1.0);
    }

    public static void attack(Entity source, Entity target, double modifier){
        BaseAtk.applyAttack(source,target,modifier);
        double fireChance = 0.25;
        if(Math.random()< fireChance) target.getEffectManager().addEffect(new FireEffect());
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
