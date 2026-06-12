package it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.effect.Effetti.DefenseEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Defend implements Action {
    private final int cost = 2;
    private final String nome = "difesa";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :ATTENZIONE!!!");
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome);
        }

        source.getEffectManager().addEffect(new DefenseEffect());
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

    @Override
    public int getUnlockLvl() {
        return 0;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return null;
    }

}
