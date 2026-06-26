package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.Ultimate;

import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.MultiAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.attackType;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.TargetType;

import java.util.List;

/**
 * contiene la logica per far si che tre nemici adieacenti subiscano un abilità MultiAtk()
 */
public class WorldSlash implements SplashAbility, Ultimate {

    private final int cost = 30;
    private final String name = "taglia mondi";

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
            System.out.println(source.getNome() + " effettua " + this.name + " contro " + target.getNome());
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
    public String getName() {
        return name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public TargetType getTargetType() {
        return TargetType.ENEMY;
    }

    @Override
    public int getUnlockLvl() {
        return 10;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.DPS;
    }

    @Override
    public attackType getAttackType() {
        return attackType.MELE;
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
    }
