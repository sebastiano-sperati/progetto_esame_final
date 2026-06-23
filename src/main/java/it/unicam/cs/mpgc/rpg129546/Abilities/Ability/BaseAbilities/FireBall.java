package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.attackType;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.FireEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

public class FireBall implements Action {
    private final int cost = 6;
    private final String name = "palla di fuoco";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);

        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :LE FIAMME MI GRAZIANO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.name + " contro " + target.getNome());
        }

        attack(source,target,1.0);
    }

    public static void attack(Entity source, Entity target, double modifier){
        BaseAtk.applyAttack(source,target,modifier);
        double fireChance = 0.25;
        if(Math.random()< fireChance) target.getEffectManager().addEffect(new FireEffect());
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public int getCost(){
        return this.cost;
    }
    @Override
    public TargetType getTargetType(){ return TargetType.ENEMY;}

    @Override
    public int getUnlockLvl() {
        return 5;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.MAGE;
    }

    @Override
    public attackType getAttackType() {
        return attackType.MAGIC;
    }

}
