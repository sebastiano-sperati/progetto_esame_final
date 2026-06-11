package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;

public class AbilityContext {
    private List<Hero> eroi;
    private List<Enemy> nemici;
    public AbilityContext(List<Hero> eroi, List<Enemy> nemici){
        this.eroi=eroi;
        this.nemici=nemici;
    }

    public List<? extends Entity> getTargets(Action action, Entity source){
        switch (action.getTargetType()){
            case ALLY -> {
                if (source instanceof Hero){
                    return eroi;
                }
                return nemici;
            }
            case ENEMY -> {
                if(source instanceof Hero){
                    return nemici;
                }
                return eroi;
            }
            default -> {
                return List.of(source);
            }
        }
    }
}
