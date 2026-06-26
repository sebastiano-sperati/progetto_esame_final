package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.Ultimate;

import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.attackType;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.TargetType;

import java.util.List;

/**
 * contiene la logica per far si che, quando l'abilità è pronta, tutti gli alleati tornino in vita e vengano curati
 */
public class GodsBlessing implements SplashAbility, Ultimate {

    private final int cost = 35;
    private final String name = "benevolenza divina";

    private int charge = 0;
    @Override
    public void executeSplash(Entity source, Entity target, List<? extends Entity> ctx) {
        if(!isReady()){
            System.out.println("non è ancora il momento...");
            return;
        }
        if(source.getStatusManager().getAp() < cost) {
            System.out.println("Ap insufficienti");
            return;
        }
        source.getStatusManager().consumeAp(cost);
        for(Entity e : ctx){
            if(!e.getStatusManager().isAlive()) e.getStatusManager().setAlive(true);
            e.getStatusManager().Heal(e.getStatsManager().getScaledMaxHP()/2);
            e.getStatusManager().restore(e.getStatsManager().getScaledMaxAp()/2);
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
        return TargetType.ALLY;
    }

    @Override
    public int getUnlockLvl() {
        return 10;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.HEALER;
    }

    @Override
    public attackType getAttackType() {
        return attackType.MAGIC;
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
