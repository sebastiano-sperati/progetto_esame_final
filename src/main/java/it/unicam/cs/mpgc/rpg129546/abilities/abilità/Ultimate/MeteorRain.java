package it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities.FireBall;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

import java.util.List;
import java.util.Random;

public class MeteorRain implements SplashAbility, Ultimate {
    private final int cost = 40;
    private final String nome = "pioggia di meteore";

    private int charge = 0;

    @Override
    public void executeSplash(Entity source, Entity target, List<? extends Entity> ctx) {
        if(!isReady()){
            System.out.println("non è ancora il momento...");
            return;
        }
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :PER IFRIT ");
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }
        Random random = new Random();
        for(Entity e : ctx){
            if(e.getStatusManager().isAlive()){
                int cast = random.nextInt(2)+1;
                for (int i = 0; i < cast; i++) {
                    FireBall.attack(source,e,1.0);
                }
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
        return TargetType.ENEMY;
    }

    @Override
    public int getUnlockLvl() {
        return 10;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.MAGE;
    }

    @Override
    public int getCharge() {
        return charge;
    }

    @Override
    public void increaseCharge() {
        charge++;
        if(charge>getRequiredCharge()) charge = getRequiredCharge();
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
