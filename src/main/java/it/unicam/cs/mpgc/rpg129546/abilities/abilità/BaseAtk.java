package it.unicam.cs.mpgc.rpg129546.abilities.abilità;

import it.unicam.cs.mpgc.rpg129546.effect.Effetti.CounterEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class BaseAtk implements Action {
    private final int cost = 0;
    private final String nome = "attacco base";

    @Override
    public void execute(Entity source, Entity target) {
        // controlla se l'abilità può essere effettuata
        if (source.getAp() < cost) return;
        source.consumeAp(cost);

        if(source instanceof Hero) {
            System.out.println(source.getNome() + " :PRENDI QUESTO " + target.getNome());
        } else {
            System.out.println(source.getNome() + " effettua " + this.nome + " contro " + target.getNome());
        }
        //applica l'attacco con modificatore
        applyAttack(source, target,1.0);
    }
    public static void applyAttack(Entity source, Entity target , double multiplier){
        //EVA
        if(Math.random() < target.getEffectaApplier().modifyEva(target)){
            System.out.println(target.getNome() + " ha evitato l'attacco!");
            //COUNTER
            if(target.getEffectManager().hasEffect(CounterEffect.class)){
                System.out.println(target.getNome() + " effettua un contrattacco!");

                int dmg = target.getEffectaApplier().modifyAtk(target);
                dmg = (int)(dmg * 1.5);
                dmg -= source.getEffectaApplier().modifyDif(source);
                if (dmg < 0) dmg = 0;
                source.takeDamage(dmg);
            }
        return;
        }
        // calcolo danno
        int dmg = source.getEffectaApplier().modifyAtk(source);
        dmg = (int)(dmg * multiplier);

        if (Math.random() < source.getEffectaApplier().modifyCC(source)) {
            System.out.println(source.getNome() + " effettua un attacco critico!");
            dmg = (int)(dmg * source.getEffectaApplier().modifyCM(source));
        }
        dmg -= target.getEffectaApplier().modifyDif(target);
        if (dmg < 0) dmg = 0;
        target.takeDamage(dmg);
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

