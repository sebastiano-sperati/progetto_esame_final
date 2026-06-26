package it.unicam.cs.mpgc.rpg129546.Combat.Selectors;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.List;
import java.util.Random;

/**
 * contiene la logica per far si che un nemico selezioni randomicamente un target in base alla lista fornità
 */
public class TargetSelector {
    /**
     * permette di selezionare automaticamente la lista corretta in base all'azione scelta
     * @param action l'azione scelta
     * @param source chi effettua l'azione
     * @param heroes lista degli eroi
     * @param enemies lista dei nemici
     * @return ritorna una lista di target
     */
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

    /**
     * sceglie randomicamente un target che deve essere vivo
     * @param list la lista da cui scegliere
     * @return il singolo target nella lista
     */
    public static Entity SelectorEnemy(List<? extends Entity> list) {
        Random random = new Random();
        while (true) {
            int index = random.nextInt(list.size());
            if(list.get(index).getStatusManager().isAlive()) return list.get(index);
        }
    }
}