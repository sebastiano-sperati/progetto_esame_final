package it.unicam.cs.mpgc.rpg129546.Combat.Selectors;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.List;
import java.util.Random;

public class TargetSelector {
    public static Entity SelectListAction(Action action, Entity source, List<Hero> heroes, List<Enemy> enemies){
        switch (action.getTargetType()){
            case ALLY ->{
                return SelectorEnemy(enemies);
            }
            case ENEMY -> {
                return SelectorEnemy(heroes);
            }
            case SELF -> {
                return source;
            }
            default -> throw new IllegalStateException("bersagio non valido");
        }

    }

    public static Entity SelectorEnemy(List<? extends Entity> list){
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}