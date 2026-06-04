package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Imp;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Orco;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Wraith;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyFactory {

    public static List<Enemy> generate(int floor) {
        Random random = new Random();

        int ammount = random.nextInt(6) + 2;

        List<Enemy> nemici = new ArrayList<>();

        for (int i = 0; i < ammount; i++) {
            nemici.add(randomEnemy(floor));
        }
        return nemici;
    }

    private static Enemy randomEnemy(int floor){
        Random random = new Random();
        return switch (random.nextInt(4)){

            case 0 -> new Wraith("Wraith", 15, 20, 2, 3, 12, 0.20, 2.0, 0.20, floor, 1, 20);

            case 1 -> new Orco("Orco", 40, 10, 8, 4, 3, 0.05, 1.5, 0.05, floor, 5,15);

            case 2 -> new Imp("Imp", 20, 15, 3, 9, 4, 0.15, 1.8, 0.15, floor, 1, 15);

            default -> new Wraith("Wraith", 15, 20, 2, 3, 12, 0.20, 2.0, 0.20, floor, 1, 20);

        };
    }
}
