package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.TargetType;

public interface Action {
    default void execute(Entity source, Entity target) {

    }

    String getNome();
    int getCosto();
    TargetType getTargetType();
}
