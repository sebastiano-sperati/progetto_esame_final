package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.Ultimate;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.DefenseEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

import java.util.List;

public class IronWall implements SplashAbility, Ultimate {
    private final int cost = 20;
    private final String name = "mura di ferro";

    private int charge = 0;

    @Override
    public void executeSplash(Entity source, Entity target, List<? extends Entity> ctx) {
        if(!isReady()){
            System.out.println("non è ancora il momento...");
            return;
        }
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        for(Entity e : ctx){
            if(e.getStatusManager().isAlive()){
                e.getEffectManager().addEffect(new DefenseEffect());
            }
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
        return CharacterAllocation.TANK;
    }

    @Override
    public int getCharge() {
        return charge;
    }

    @Override
    public void increaseCharge() {
        charge++;
    }

    @Override
    public void resetCharge() {
        charge=0;
    }

    @Override
    public int getRequiredCharge() {
        return 5;
    }
}
