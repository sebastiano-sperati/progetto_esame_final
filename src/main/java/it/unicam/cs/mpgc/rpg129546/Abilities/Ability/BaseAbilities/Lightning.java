package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.attackType;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.TargetType;

import java.util.List;

/**
 * contiene la logica per far si che un nemico prenda danno da attacco e,
 * a catena, i nemici affianco subiscano metà danno
 */
public class Lightning implements SplashAbility {
    private final int cost = 8;
    private final String name = "fulmine";

    @Override
    public void executeSplash(Entity source, Entity target, List<? extends Entity> ctx) {
        if(source.getStatusManager().getAp() < cost)return;
        source.getStatusManager().consumeAp(cost);
        List<? extends Entity> targets = ctx;
        int index = targets.indexOf(target);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :BAHAMU CONCEDIMI LA FORZA " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.name + " contro " + target.getNome());
        }
        BaseAtk.applyAttack(source,target,1.0);
        if(index > 0){
            BaseAtk.applyAttack(source, targets.get(index-1),0.5);
        }
        if(index < targets.size()-1){
            BaseAtk.applyAttack(source, targets.get(index+1),0.5);
        }
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.MAGE;
    }

    @Override
    public attackType getAttackType() {
        return attackType.MAGIC;
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
}
