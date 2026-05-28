package it.unicam.cs.mpgc.rpg129546;
import it.unicam.cs.mpgc.rpg129546.combat.Battle;
import it.unicam.cs.mpgc.rpg129546.model.*;
import it.unicam.cs.mpgc.rpg129546.abilities.*;
import it.unicam.cs.mpgc.rpg129546.effect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hero dps = new Dps("dps",80,30,6,14,0.10,1.5,0.15,1);
        Hero tank = new Tank("tank",120,25,12,8,0.05,1.2,0.05,1);
        Hero mage = new Mage("mage",70,35,4,16,0.10,1.6,0.20,1);
        Hero healer = new Healer("healer",75,40,5,10,0.15,1.3,0.10,1);

        List<Hero> heroes = new ArrayList<>();
        heroes.add(dps);
        heroes.add(tank);
        heroes.add(mage);
        heroes.add(healer);

        Enemy goblin = new goblin("goblin",60,20,4,10,0.10,1.3,0.10,1);
        Enemy orc = new orco("orco",100,25,10,14,0.05,1.4,0.08,1);
        Enemy wraith = new Wraith("wratih",85,30,6,13,0.20,1.5,0.15,1);
        Enemy imp = new imp("imp",55,25,3,11,0.25,1.6,0.18,1);

        List<Enemy> enemies = new ArrayList<>();
        enemies.add(goblin);
        enemies.add(orc);
        enemies.add(wraith);
        enemies.add(imp);

        Battle battle = new Battle(heroes,enemies);
        battle.Start();
    }
}
