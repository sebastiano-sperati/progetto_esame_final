package it.unicam.cs.mpgc.rpg129546;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Rarity;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Weapon;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.WeaponScaling;
import it.unicam.cs.mpgc.rpg129546.combat.Battle;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.*;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Hero healer1 = new Healer("healer1",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero healer2 = new Healer("healer2",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero healer3 = new Healer("healer3",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero healer4 = new Healer("healer4",80,30,6,14,10,0.10,1.5,0.15,1);

        healer1.addGold(100);
        healer2.addGold(50);

        List<Hero> heroes = new ArrayList<>();

        heroes.add(healer1);
        heroes.add(healer2);
        heroes.add(healer3);
        heroes.add(healer4);

        List<Enemy> enemies = new ArrayList<>();


        Battle battle = new Battle(heroes,enemies);
        battle.Start();
    }
}
