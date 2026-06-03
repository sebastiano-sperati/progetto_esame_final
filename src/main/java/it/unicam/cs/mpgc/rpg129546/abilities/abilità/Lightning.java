package it.unicam.cs.mpgc.rpg129546.abilities.abilità;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

import java.util.List;

public class Lightning implements SplashAbility{
    private final int cost = 8;
    private final String nome = "fulmine";

    @Override
    public void executeSplash(Entity source, Entity target, List<? extends Entity> ctx) {
        if(source.getStatusManager().getAp() < cost)return;
        source.getStatusManager().consumeAp(cost);
        List<? extends Entity> targets = ctx;
        int index = targets.indexOf(target);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :BAHAMU CONCEDIMI LA FORZA " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }
        BaseAtk.applyAttack(source,target,1.0);
        if(index > 0){
            BaseAtk.applyAttack(source, targets.get(index-1),0.5);
        }
        if(index < targets.size()-1){
            BaseAtk.applyAttack(source, targets.get(index+1),0.5);
        }
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
