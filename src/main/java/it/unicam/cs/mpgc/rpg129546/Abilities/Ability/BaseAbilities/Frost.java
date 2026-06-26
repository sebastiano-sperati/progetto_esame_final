package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.attackType;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.FrostEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.TargetType;

/**
 * contiene la logica per far si che il nemico subisca danno da un attacco
 * e abbia il 25 di probabilitòà di ricevere l'effetto FrostEffect()
 */
public class Frost implements Action {
    private final int cost = 4;
    private final String name = "congelamento";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :LE DEE DEL GHIACCIO MI BENEDICONO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.name + " contro " + target.getNome());
        }
        BaseAtk.applyAttack(source, target, 0.7);
        double frostChance = 0.25;
        if(Math.random()< frostChance) target.getEffectManager().addEffect(new FrostEffect());
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
        return CharacterAllocation.MAGE;
    }

    @Override
    public attackType getAttackType() {
        return attackType.MAGIC;
    }

}
