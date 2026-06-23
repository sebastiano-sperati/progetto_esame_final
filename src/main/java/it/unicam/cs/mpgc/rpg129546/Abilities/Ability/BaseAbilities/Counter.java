package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.attackType;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.CounterEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

public class Counter implements Action {
    private final int cost = 6;
    private final String name = "contrattacco";

    @Override
    public void execute(Entity source, Entity target) {

    if(source.getStatusManager().getAp() < cost) return;
    source.getStatusManager().consumeAp(cost);

    System.out.println(source.getNome() + " :SONO PRONTO...");
    source.getEffectManager().addEffect(new CounterEffect());
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
    public TargetType getTargetType(){ return TargetType.SELF;}

    @Override
    public int getUnlockLvl() {
        return 5;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.DPS;
    }

    @Override
    public attackType getAttackType() {
        return attackType.SELFBUFF;
    }

}
