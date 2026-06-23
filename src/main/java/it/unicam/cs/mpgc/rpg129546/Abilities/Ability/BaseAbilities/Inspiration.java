package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.attackType;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.InspiredEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

public class Inspiration implements Action {
    private final int cost = 4;
    private final String name = "ispira";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :NON ARRENDERTI " + target.getNome());
        } else {
            System.out.println(source.getNome() + " utilizza " + this.name + " su " + target.getNome());
        }

        target.getEffectManager().addEffect(new InspiredEffect());
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
        return 5;
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
