package it.unicam.cs.mpgc.rpg129546.Abilities.Interface;

import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.attackType;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.TargetType;

/**
 * contiene i metodi inerenti ad un abilità generica
 *
 * Ogni implementazione specifica il costo in AP, il bersaglio,
 * il livello di sblocco, il personaggio che può utilizzarla
 * e la logica di esecuzione
 */
public interface Action {
    /**
     * Esegue l'abilità sul bersaglio indicato.
     *
     * @param source entità che utilizza l'abilità
     * @param target bersaglio dell'abilità
     */
    default void execute(Entity source, Entity target) {}

    String getName();
    int getCost();

    /**
     * @return il tipo di bersaglio previsto dall'abilità
     */
    TargetType getTargetType();

    /**
     * @return il livello minimo richieso per sbloccare l'abilità
     */
    int getUnlockLvl();

    /**
     * @return il personaggio che può usare l'abilità
     */
    CharacterAllocation getCaracterAllocation();
    attackType getAttackType();
}
