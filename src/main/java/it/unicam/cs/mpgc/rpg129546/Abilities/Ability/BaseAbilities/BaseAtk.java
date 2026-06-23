package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.attackType;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.CounterEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

public class BaseAtk implements Action {
    private final int cost = 0;
    private final String name = "attacco base";

    @Override
    public void execute(Entity source, Entity target) {
        if (source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);

        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :PRENDI QUESTO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.name + " contro " + target.getNome());
        }
        applyAttack(source, target,1.0);
    }
    public static void applyAttack(Entity source, Entity target , double multiplier){
        //EVA
        if(Math.random() < target.getEffectaApplier().modifyEva(target)){
            System.out.println(target.getNome() + " ha evitato l'attacco!");
            //COUNTER
            if(target.getEffectManager().hasEffect(CounterEffect.class)){
                System.out.println(target.getNome() + " effettua un contrattacco!");

                int dmg = target.getEffectaApplier().modifyDmg(target);
                dmg = (int)(dmg * 1.5);
                dmg -= source.getEffectaApplier().modifyDif(source);
                if (dmg < 0) dmg = 0;
                source.getStatusManager().takeDamage(dmg);
            }
        return;
        }
        int dmg = source.getEffectaApplier().modifyDmg(source);
        dmg = (int)(dmg * multiplier);

        if (Math.random() < source.getEffectaApplier().modifyCC(source)) {
            System.out.println(source.getNome() + " effettua un attacco critico!");
            dmg = (int)(dmg * source.getEffectaApplier().modifyCM(source));
        }
        dmg -= target.getEffectaApplier().modifyDif(target);
        if (dmg < 0) dmg = 0;
        target.getStatusManager().takeDamage(dmg);
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
        return 0;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return null;
    }

    @Override
    public attackType getAttackType() {
        return attackType.MELE;
    }
}

