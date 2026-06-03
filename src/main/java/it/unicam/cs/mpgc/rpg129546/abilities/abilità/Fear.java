package it.unicam.cs.mpgc.rpg129546.abilities.abilità;

import it.unicam.cs.mpgc.rpg129546.effect.Effetti.ScaredEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class Fear implements Action{
    private final int cost = 8;
    private final String nome = "intimidire";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.getStatusManager().getAp() < cost) return;
        source.getStatusManager().consumeAp(cost);
        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :SEI MIOOOOO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }

        target.getEffectManager().addEffect(new ScaredEffect());
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
    public TargetType getTargetType(){ return TargetType.ENEMY;}

}
