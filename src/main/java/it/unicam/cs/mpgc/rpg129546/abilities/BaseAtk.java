package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.effect.counterEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public class BaseAtk implements Action {
    private final int cost = 0;
    private final String nome = "attacco base";

    @Override
    public void execute(Entity source, Entity target) {
        if(source.isAlly(target)){
            System.out.println("non puoi attaccare un alleato");
            return;
        }
        if (source.getAp() < cost) return;
        source.consumeAp(cost);

        applyAttack(source, target,1.0);
    }
    public static void applyAttack(Entity source, Entity target , double multiplier){
        //EVA
        if(Math.random() < target.getApplier().modifyEva(target)){
            System.out.println(target.getNome() + " ha evitato l'attacco!");
            //COUNTER
            if(target.getManager().hasEffect(counterEffect.class)){
                System.out.println(target.getNome() + " effettua un contrattacco!");
                int danno = target.getApplier().modifyAtk(target);
                danno = (int)(danno * 1.5);
                danno -= source.getApplier().modifyDif(source);
                if (danno < 0) danno = 0;
                source.takeDamage(dmg);
            }
        return;
        }
        int dmg = source.getApplier().modifyAtk(source);
        dmg = (int)(dmg * multiplier);

        if (Math.random() < source.getApplier().modifyCC(source)) {
            System.out.println(source.getNome() + " effettua un attacco critico!");
            dmg = (int)(dmg * source.getApplier().modifyCM(source));
        }
        dmg -= target.getApplier().modifyDif(target);
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

