package it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.effect.Effetti.InspiredEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Ispirazione implements Action {
    private final int cost = 4;
    private final String nome = "ispira";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :NON ARRENDERTI " + target.getNome());
        } else {
            System.out.println(source.getNome() + " utilizza " + this.nome + " su " + target.getNome());
        }

        target.getEffectManager().addEffect(new InspiredEffect());
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

    @Override
    public int getUnlockLvl() {
        return 5;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.TANK;
    }

}
