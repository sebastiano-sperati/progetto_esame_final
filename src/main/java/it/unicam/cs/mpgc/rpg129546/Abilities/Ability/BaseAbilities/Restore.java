package it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

public class Restore implements Action {
    private final int cost = 6;
    private final String name = "ristoro";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :stringi i denti ancora per un po... " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.name + " contro " + target.getNome());
        }

        target.getStatusManager().restore(6);
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
        return CharacterAllocation.HEALER;
    }

}
