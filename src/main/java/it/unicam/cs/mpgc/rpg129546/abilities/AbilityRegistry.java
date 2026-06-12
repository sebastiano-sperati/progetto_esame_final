package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities.*;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate.GodsBlessing;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate.IronWall;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate.MeteorRain;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Ultimate.WorldSlash;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;

public class AbilityRegistry {
    public static final List<Action> abilities = List.of(
            new Bless(),
            new Counter(),
            new DebufAtk(),
            new Fear(),
            new FireBall(),
            new Frost(),
            new Heal(),
            new Ispirazione(),
            new Lightning(),
            new MultiAtk(),
            new Restore(),
            new Revivify(),
            new GodsBlessing(),
            new IronWall(),
            new MeteorRain(),
            new WorldSlash()
    );
    public static void getAbilityFor(Hero hero) {
        for (Action a : abilities){
            if(a.getUnlockLvl() <= hero.getStatusManager().getLvl() && a.getCaracterAllocation() == hero.getCharacterAllocation() && !hero.hasAbility(a)){
                hero.getAzioni().add(a);
            }
        }
    }
}
