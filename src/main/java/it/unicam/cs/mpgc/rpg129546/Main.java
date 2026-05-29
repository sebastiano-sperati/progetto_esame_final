package it.unicam.cs.mpgc.rpg129546;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Armor;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Rarity;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Weapon;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.WeaponScaling;
import it.unicam.cs.mpgc.rpg129546.Items.Oggetti.Consumabili.AntiFire;
import it.unicam.cs.mpgc.rpg129546.Items.Oggetti.Consumabili.AntiFrost;
import it.unicam.cs.mpgc.rpg129546.Items.Oggetti.Consumabili.PoisonKnives;
import it.unicam.cs.mpgc.rpg129546.Items.Oggetti.Consumabili.StrenghtPotion;
import it.unicam.cs.mpgc.rpg129546.combat.Battle;
import it.unicam.cs.mpgc.rpg129546.effect.Effetti.FireEffect;
import it.unicam.cs.mpgc.rpg129546.effect.Effetti.FrostEffect;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.*;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Hero healer1 = new Healer("healer1",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero healer2 = new Healer("healer2",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero healer3 = new Healer("healer3",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero healer4 = new Healer("healer4",80,30,6,14,10,0.10,1.5,0.15,1);


        List<Hero> heroes = new ArrayList<>();

        heroes.add(healer1);
        heroes.add(healer2);
        heroes.add(healer3);
        heroes.add(healer4);



        Enemy goblin = new goblin("goblin",60,20,4,1000000,10,0.10,1.3,0.10,1);

        List<Enemy> enemies = new ArrayList<>();
        enemies.add(goblin);


        Battle battle = new Battle(heroes,enemies);
        battle.Start();
    }
}
