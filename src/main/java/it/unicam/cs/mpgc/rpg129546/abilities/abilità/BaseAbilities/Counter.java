package it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.effect.Effetti.CounterEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Counter implements Action {
    private final int cost = 6;
    private final String nome = "contrattacco";

    @Override
    public void execute(Entity source, Entity target) {

    if(source.getStatusManager().getAp() < cost) return;
    source.getStatusManager().consumeAp(cost);

    System.out.println(source.getNome() + " :SONO PRONTO...");
    source.getEffectManager().addEffect(new CounterEffect());
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
    public TargetType getTargetType(){ return TargetType.SELF;}

}
