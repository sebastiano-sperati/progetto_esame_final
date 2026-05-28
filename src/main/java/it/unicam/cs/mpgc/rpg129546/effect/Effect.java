package it.unicam.cs.mpgc.rpg129546.effect;

import it.unicam.cs.mpgc.rpg129546.model.Entity;public interface Effect {
    void tick();
    boolean isExpired();
    int getDuration();
    String getNome();
    int getTick();
    tickType getType();
    default void damageOverTime(Entity e){}

    default int modifyAtk(int atk) {
        return atk;
    }

    default int modifyDif(int dif) {
        return dif;
    }

    default double modifyEva(double eva) {
        return eva;
    }

    default int mdifyHP(int hp) {
        return hp;
    }

    default int modifyAp(int ap) {
        return ap;
    }

    default double modifyCritMult(double cm) {
        return cm;
    }

    default double modifyCritChance(double cc) {
        return cc;
    }
}
