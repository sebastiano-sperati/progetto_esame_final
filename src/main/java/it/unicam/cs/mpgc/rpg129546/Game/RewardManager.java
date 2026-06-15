package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;

import java.util.List;

public class RewardManager {

    public static void reward(List<Hero>eroi, List<Enemy>nemici,int floor){
        int xp = caclulatexp(nemici);
        int gold = calculateGold(nemici);

        System.out.println("===RICOMPENSE===");
        System.out.println("XP ottenuti: " + xp);
        System.out.println("oro ottenuto: "+ gold);

        for(Hero h:eroi){
            h.getHeroStatusManager().addGold(gold);
            h.getHeroStatusManager().addXp(xp);
        }
    }

    private static int caclulatexp(List<Enemy> list){
        int xp = 0;
        for(Enemy e : list){
            xp += e.getScaledXpDrop();
        }
        return xp;
    }

    private static int calculateGold(List<Enemy>list){
        int gold = 0;
        for(Enemy e : list){
            gold += e.getScaledTaglia();
        }
        return gold;
    }
}
