package it.unicam.cs.mpgc.rpg129546.abilities.abilità;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.List;

public interface SplashAbility extends Action{
    void executeSplash(Entity source, Entity target, List<? extends Entity> ctx);
}
