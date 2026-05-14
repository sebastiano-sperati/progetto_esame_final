package it.unicam.cs.mpgc.rpg129546;
import it.unicam.cs.mpgc.rpg129546.combat.Battle;
import it.unicam.cs.mpgc.rpg129546.model.*;
import it.unicam.cs.mpgc.rpg129546.abilities.*;
import it.unicam.cs.mpgc.rpg129546.effect.*;
import java.util.*;

public class Main {
    static void main() {
        Hero dps = new Dps("dps",10,10,4,3,0.3,0.2,0.1,1);
        Hero tank = new Tank("tank",10,10,4,3,0.3,0.2,0.1,1);
        Hero mage = new Mage("mage",10,10,4,3,0.3,0.2,0.1,1);
        Hero healer = new Healer("healer",10,10,4,3,0.3,0.2,0.1,1);
        List<Hero> heroes = new ArrayList<>();
        heroes.add(dps);
        heroes.add(tank);
        heroes.add(mage);
        heroes.add(healer);

        Enemy goblin = new goblin("goblin",10,10,4,3,0.3,0.2,0.1,1);
        Enemy orc = new orco("orco",10,10,4,3,0.3,0.2,0.1,1);
        Enemy wraith = new Wraith("wratih",10,10,4,3,0.3,0.2,0.1,1);
        Enemy imp = new imp("imp",10,10,4,3,0.3,0.2,0.1,1);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(goblin);
        enemies.add(orc);
        enemies.add(wraith);
        enemies.add(imp);


        Battle battle = new Battle(heroes, enemies);

        battle.Start();
    }
}
