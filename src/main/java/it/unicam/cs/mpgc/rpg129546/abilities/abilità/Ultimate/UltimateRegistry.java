package it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;

public class UltimateRegistry {
    public static final List<Ultimate> ultimates = List.of(
            new MeteorRain(),
            new WorldSlash(),
            new GodsBlessing(),
            new IronWall()
    );
    public static Action getUltimateFor(Hero hero) {
        for(Ultimate u : ultimates){
            if(u.getCharacterAllocation() == hero.getCharacterAllocation()) return (Action) u;
        }
        return null;
    }
}
