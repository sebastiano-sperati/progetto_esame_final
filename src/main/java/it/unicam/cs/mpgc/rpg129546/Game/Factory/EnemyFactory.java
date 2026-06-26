package it.unicam.cs.mpgc.rpg129546.Game.Factory;

import it.unicam.cs.mpgc.rpg129546.Model.Enemies.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * gestisce la logica per generare randomicamente una lista di nemici ad ogni round
 */
public class EnemyFactory {
    /**
     * genera una lista di nemici casuale, la cui dimensione incrementa più si progredisce con il gioco.
     * Nel caso si sia arrivati all'ultimo livello, il boss viene generato al centro della lista
     * @param floor numero del round a cui si è arrivati
     * @return una lista di nemici casuali
     */
    public static List<Enemy> generate(int floor) {
        Random random = new Random();

        int ammount = random.nextInt(floor) + 2;;

        List<Enemy> enemies = new ArrayList<>();

        int i = 0;

        while (i < ammount) {
            if(floor == 10){
                if(i == ammount/2){
                    enemies.add(new Boss("Re dei Dannati", 250, 50, 12, 18, 18, 0.15, 2.5, 0.25, 1, 20, 100));
                    i++;
                }
            }
            enemies.add(randomEnemy(floor));
            i++;
        }
        return enemies;
    }

    /**
     * seleziona casualmente, 1 dei 4 nemici presenti nel gioco escludendo il boss, modificandone il livello in base al round
     * @param floor round attuale (modifica il livello)
     * @return un nemico casuale
     */
    private static Enemy randomEnemy(int floor){
        Random random = new Random();
        return switch (random.nextInt(4)){
            case 0 -> new Wraith("Wraith", 15, 20, 2, 3, 12, 0.20, 2.0, 0.20, floor, 1, 2);

            case 1 -> new Orco("Orco", 40, 10, 8, 4, 3, 0.05, 1.5, 0.05, floor, 5,10);

            case 2 -> new Imp("Imp", 20, 15, 3, 9, 4, 0.15, 1.8, 0.15, floor, 1, 5);

            default -> new Goblin("Goblin", 25, 10, 4, 5, 5, 0.10, 1.5, 0.10, floor, 2, 10);
        };
    }
}
