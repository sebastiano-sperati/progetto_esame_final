package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.attackType;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.ScaredEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.TargetType;

/**
 * Contiene la logica per far si che venga aggiunto a target
 * un singolo effetto ScaredEffect()
 */
public class Fear implements Action {
    private final int cost = 8;
    private final String name = "intimidire";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :SEI MIOOOOO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.name + " contro " + target.getNome());
        }

        target.getEffectManager().addEffect(new ScaredEffect());
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
        return 7;
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
