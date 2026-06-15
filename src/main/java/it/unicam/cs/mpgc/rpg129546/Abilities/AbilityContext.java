package it.unicam.cs.mpgc.rpg129546.Abilities;

import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.List;

public class AbilityContext {
    private List<Hero> heroes;
    private List<Enemy> enemies;
    public AbilityContext(List<Hero> heroes, List<Enemy> enemies){
        this.heroes = heroes;
        this.enemies = enemies;
    }

    public List<? extends Entity> getTargets(Action action, Entity source){
        switch (action.getTargetType()){
            case ALLY -> {
                if (source instanceof Hero){
                    return heroes;
                }
                return enemies;
            }
            case ENEMY -> {
                if(source instanceof Hero){
                    return enemies;
                }
                return heroes;
            }
            default -> {
                return List.of(source);
            }
        }
    }
}
