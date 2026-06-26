package it.unicam.cs.mpgc.rpg129546.Combat.Selectors;

import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;

/**
 * gestisce la logica per far si che un nemico selezioni l'abilità più costosa possibile
 */
public class AbilitySelector {

    public static Action selectorEnemy(Enemy e){
        Action selected = e.getAzioni().getFirst();
        for (int i = 0; i < e.getAzioni().size(); i++) {
            if (e.getStatusManager().getAp() >= e.getAzioni().get(i).getCost() && selected.getCost() < e.getAzioni().get(i).getCost()){
                selected = e.getAzioni().get(i);
            }
        }
        return selected;
    }
}