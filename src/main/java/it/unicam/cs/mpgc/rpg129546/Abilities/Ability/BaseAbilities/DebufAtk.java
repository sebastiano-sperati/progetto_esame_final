package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.AtkDebuffEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

public class DebufAtk implements Action {
    private final int cost = 4;
    private final String name = "colpo debilitante";

    @Override
    public void execute(Entity source, Entity target) {
        if (source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :VEDIAMO COME TE LA CAVI " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.name + " contro " + target.getNome());
        }

        BaseAtk.applyAttack(source,target,0.7);
        target.getEffectManager().addEffect(new AtkDebuffEffect());
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
        return 2;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.DPS;
    }

}
