package it.unicam.cs.mpgc.rpg129546;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Rarity;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Weapon;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.WeaponScaling;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.combat.Battle;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.*;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dps dps = new Dps("dps",10,10,3,5,2,0.2,0.2,0.2,1,10);
        Tank tank = new Tank("tank",10,10,3,5,4,0.2,0.2,0.2,1,10);
        Healer healer = new Healer("healer",10,10,3,2,5,0.2,0.2,0.2,1,10);
        Mage mage= new Mage("mage",10,10,3,3,5,0.2,0.2,0.2,1,10);

        List<Hero> heroes = new ArrayList<>();

        heroes.add(dps);
        heroes.add(tank);
        heroes.add(healer);
        heroes.add(mage);

        Goblin goblin1 = new Goblin("goblin1",10,10,3, 5,2,0.2,0.2,0.2,1,45,4);
        Goblin goblin2 = new Goblin("goblin2",10,10,3, 5,2,0.2,0.2,0.2,1,45,4);
        Goblin goblin3 = new Goblin("goblin3",10,10,3, 5,2,0.2,0.2,0.2,1,45,4);
        Goblin goblin4 = new Goblin("goblin4",10,10,3, 5,2,0.2,0.2,0.2,1,45,4);

        List<Enemy> enemies = new ArrayList<>();

        enemies.add(goblin1);
        enemies.add(goblin2);
        enemies.add(goblin3);
        enemies.add(goblin4);

        Battle battle = new Battle(heroes,enemies);

        battle.Start();
    }
}
