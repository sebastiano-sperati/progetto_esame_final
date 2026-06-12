package it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Revivify implements Action {
    private final int cost = 8;
    private final String nome = "resurrezione";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :ANCORA UNA VOLTA " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }

        target.getStatusManager().setAlive(true);
        int heal = target.getStatusManager().getMaxAp()/2;
        target.getStatusManager().Heal(heal);
    }
    @Override
    public String getNome(){
        return this.nome;
    }
    @Override
    public int getCosto(){
        return this.cost;
    }
    @Override
    public TargetType getTargetType(){ return TargetType.ALLY;}

    @Override
    public int getUnlockLvl() {
        return 7;
    }

    @Override
    public CharacterAllocation getCaracterAllocation() {
        return CharacterAllocation.HEALER;
    }

}
