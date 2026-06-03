package it.unicam.cs.mpgc.rpg129546.abilities.abilità;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Heal implements Action{
    private final int cost = 6;
    private final String nome = "cura";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :che gli dei abbiano cura di te " + target.getNome());
        } else {
            System.out.println(source.getNome() + " utilizza " + this.nome + " su " + target.getNome());
        }

        int heal = (int) (10 + (target.getStatusManager().getMaxHp() - target.getStatusManager().getHp()) * 0.3);
        target.getStatusManager().Heal(heal);
    }
    @Override
    public String getNome(){
        return this.nome;
    }@Override
    public int getCosto(){
        return this.cost;
    }
    @Override
    public TargetType getTargetType(){ return TargetType.ALLY;}

}
