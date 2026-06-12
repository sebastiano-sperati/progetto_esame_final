package it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

import java.util.List;

public class GodsBlessing implements SplashAbility, Ultimate {

    private final int cost = 35;
    private final String nome = "benevolenza divina";

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
    public String getNome() {
        return nome;
    }

    @Override
    public int getCosto() {
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
