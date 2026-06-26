package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.attackType;
import it.unicam.cs.mpgc.rpg129546.Effects.Effect.DefenseEffect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.TargetType;

/**
 * Contiene la logica per far si che source applichi a se stesso un singolo effetto DefendEffect()
 */
public class Defend implements Action {
    private final int cost = 2;
    private final String name = "difesa";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :ATTENZIONE!!!");
        } else {
            System.out.println(source.getNome() + " effettua " + this.name);
        }

        source.getEffectManager().addEffect(new DefenseEffect());
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
        return 0;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return null;
    }

    @Override
    public attackType getAttackType() {
        return attackType.SELFBUFF;
    }

}
