package it.unicam.cs.mpgc.rpg129546.Abilities.Interface;

/**
 * contiene i metodi necessari a definire una Ultimate Ability
 */
public interface Ultimate {
    /**
     * @return L'attuale livello di carica
     */
    int getCharge();

    /**
     * aumenta il livello di carica
     */
    void increaseCharge();

    /**
     * azzera la carica dopo averla utilizzata
     */
    void resetCharge();

    /**
     * @return il livello di carica necessario
     */
    int getRequiredCharge();

    /**
     * @return se l'abilità è utilizzabile o meno
     */
    default boolean isReady() {
        return getCharge() >= getRequiredCharge();
    }
}
