package it.unicam.cs.mpgc.rpg129546;
import it.unicam.cs.mpgc.rpg129546.Game.Game;
import it.unicam.cs.mpgc.rpg129546.Game.HeroFactory;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveData;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveManager;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.*;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== RPG GAME ===");
        System.out.println("1) Nuova partita");
        System.out.println("2) Carica partita");
        System.out.println("3) Esci");

        Game game = null;
        while (true) {

            int choice = 0;
            choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    List<Hero> heroes = HeroFactory.generate();
                    game = new Game(heroes);
                }

                case 2 -> {
                    try {
                        SaveData data = SaveManager.load();
                        game = new Game(data.getHeroes());
                        game.saveData.setFloor(data.getFloor());
                    } catch (Exception e) {
                        System.out.println("Nessun salvataggio trovato!");
                    }
                }

                case 3 -> {
                    return;
                }
            }

            if (game != null) {
                game.Start();
            }
        }
    }
}