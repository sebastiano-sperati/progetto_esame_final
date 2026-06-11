package it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities.MultiAtk;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

import java.util.List;

public class WorldSlash implements SplashAbility, Ultimate {

    private final int cost = 30;
    private final String nome = "taglia mondi";

    private int charge = 0;

    @Override
    public void executeSplash(Entity source, Entity target, List<? extends Entity> ctx) {
        if(!isReady()){
            System.out.println("non è ancora il momento...");
            return;
        }
        if(source.getStatusManager().getAp() < cost)return;
        source.getStatusManager().consumeAp(cost);
        List<? extends Entity> targets = ctx;
        int index = targets.indexOf(target);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :E' IL MOMENTO ");
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }
        MultiAtk.attack(source,target,1.5);
        if(index > 0){
            MultiAtk.attack(source,targets.get(index-1),1.5);
        }
        if(index < targets.size()-1) {
            MultiAtk.attack(source, targets.get(index+1), 1.5);
        }
        resetCharge();
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getCosto() {
        return cost;
    }

    @Override
    public TargetType getTargetType() {
        return TargetType.ENEMY;
    }

    @Override
    public int getCharge() {
        return charge;
    }

    @Override
    public void increaseCharge() {
        charge++;
        if(charge > getRequiredCharge()) charge = getRequiredCharge();
    }

    @Override
    public void resetCharge() {
        charge = 0;
    }

    @Override
    public int getRequiredCharge() {
        return 5;
    }

    @Override
    public CharacterAllocation getCharacterAllocation() {
        return CharacterAllocation.DPS;
    }
}
