package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.model.Nemici.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyFactory {

    public static List<Enemy> generate(int floor) {
        Random random = new Random();

        int ammount = 1;
                //random.nextInt(6) + 2;

        List<Enemy> nemici = new ArrayList<>();

        int i = 0;

        if(floor == 10){
            nemici.add(new Boss("Re dei Dannati", 250, 50, 12, 18, 18, 0.15, 2.5, 0.25, floor, 20, 100));
            i++;
        }
        while (i < ammount) {
            nemici.add(randomEnemy(floor));
            i++;
        }
        return nemici;
    }

    private static Enemy randomEnemy(int floor){
        Random random = new Random();
        return switch (random.nextInt(4)){

            case 0 -> new Wraith("Wraith", 1, 20, 0, 3, 12, 0.20, 2.0, 0.20, floor, 100, 20);

            case 1 -> new Orco("Orco", 1, 10, 0, 4, 3, 0.05, 1.5, 0.05, floor, 500,15);

            case 2 -> new Imp("Imp", 1, 15, 0, 9, 4, 0.15, 1.8, 0.15, floor, 100, 15);

            default -> new Goblin("Goblin", 1, 10, 0, 5, 5, 0.10, 1.5, 0.10, floor, 200, 10);

        };
    }

    //*  case 0 -> new Wraith("Wraith", 15, 20, 2, 3, 12, 0.20, 2.0, 0.20, floor, 1, 20);
    //
    //            case 1 -> new Orco("Orco", 40, 10, 8, 4, 3, 0.05, 1.5, 0.05, floor, 5,15);
    //
    //            case 2 -> new Imp("Imp", 20, 15, 3, 9, 4, 0.15, 1.8, 0.15, floor, 1, 15);
    //
    //            default -> new Goblin("Goblin", 25, 10, 4, 5, 5, 0.10, 1.5, 0.10, floor, 2, 10);
}
