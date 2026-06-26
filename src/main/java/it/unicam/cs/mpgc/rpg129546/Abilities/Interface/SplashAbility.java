package it.unicam.cs.mpgc.rpg129546.Abilities.Interface;

import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

import java.util.List;

/**
 * estende l'interfaccioa action permettendo a un abilià da avere target multipli
 */
public interface SplashAbility extends Action{
    void executeSplash(Entity source, Entity target, List<? extends Entity> ctx);
    @Override
    CharacterAllocation getCaracterAllocation();
}
