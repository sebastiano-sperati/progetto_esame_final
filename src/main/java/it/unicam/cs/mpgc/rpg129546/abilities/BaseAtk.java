package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class BaseAtk implements Action {
    private final int cost = 2;

    @Override
    public void execute(Entity source, Entity target) {
        if (source.getAp() < cost) return;
        source.consumeAp(cost);

        applyAttack(source, target, 1.0);
    }
    public static void applyAttack(Entity source, Entity target , double multiplier){
        int deviation = 2;
        //EVA
        if(Math.random() < target.getScaledEva()){
            System.out.println(target.getNome() + " ha evitato l'attacco!");
            //COUNTER
            if(target.isCountering()){
                System.out.println(target.getNome() + " effettua un contrattacco!");
                int baseAtk = target.getScaledAtk();
                int dmg = baseAtk + (int)(Math.random() * (2 * deviation + 1)) - deviation;
                dmg = (int)(dmg * 1.5); // 150%
                dmg -= source.getScaledDif();
                if (dmg < 0) dmg = 0;
                source.takeDamage(dmg);
            }
        return;
        }
        int baseAtk = source.getScaledAtk();
        int dmg = baseAtk + (int)(Math.random() * (2 * deviation + 1)) - deviation;
        dmg = (int)(dmg * multiplier);
        if (Math.random() < source.getScaledCritChance()) {
            System.out.println(source.getNome() + " effettua un attacco critico!");
            dmg = (int)(dmg * source.getScaledCritMult());
        }
        dmg -= target.getScaledDif();
        if (dmg < 0) dmg = 0;
        target.takeDamage(dmg);
    }
}

