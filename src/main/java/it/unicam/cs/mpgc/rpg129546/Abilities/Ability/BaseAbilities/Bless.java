package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.attackType;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.BlessEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

public class Bless implements Action {
    private final int cost = 6;
    private final String name = "benedici";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);

        if(source instanceof Hero) {
            System.out.println(source.getNome() + " : CHE LA GRAZIA SIA CON TE  " + target.getNome());
        } else {
            System.out.println(source.getNome() + " utilizza " + this.name + " su " + target.getNome());
        }

        source.getEffectManager().addEffect(new BlessEffect());
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
    public TargetType getTargetType(){ return TargetType.ALLY;}

    @Override
    public int getUnlockLvl() {
        return 2;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.TANK;
    }

    @Override
    public attackType getAttackType() {
        return attackType.MAGIC;
    }

}
