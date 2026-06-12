package it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface;


public interface Ultimate {
    int getCharge();

    void increaseCharge();

    void resetCharge();

    int getRequiredCharge();

    default boolean isReady() {
        return getCharge() >= getRequiredCharge();
    }
}
