package it.unicam.cs.mpgc.rpg129546.Abilities.Interface;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.TargetType;

public interface Action {

    default void execute(Entity source, Entity target) {}

    String getName();
    int getCost();
    TargetType getTargetType();
    int getUnlockLvl();
    CharacterAllocation getCaracterAllocation();
}
