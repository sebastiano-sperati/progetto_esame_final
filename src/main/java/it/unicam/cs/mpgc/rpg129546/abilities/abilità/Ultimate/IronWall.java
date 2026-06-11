package it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.effect.Effetti.DefenseEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

import java.util.List;

public class IronWall implements SplashAbility, Ultimate {
    private final int cost = 20;
    private final String nome = "mura di ferro";

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

    @Override
    public CharacterAllocation getCharacterAllocation() {
        return CharacterAllocation.TANK;
    }
}
