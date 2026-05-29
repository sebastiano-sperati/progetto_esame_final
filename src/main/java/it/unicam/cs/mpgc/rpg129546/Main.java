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
        Hero dps1 = new Dps("dps1",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero dps2 = new Dps("dps2",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero dps3 = new Dps("dps3",80,30,6,14,10,0.10,1.5,0.15,1);
        Hero dps4 = new Dps("dps4",80,30,6,14,10,0.10,1.5,0.15,1);

        List<Hero> heroes = new ArrayList<>();
        heroes.add(dps1);
        heroes.add(dps2);
        heroes.add(dps3);
        heroes.add(dps4);

        dps2.equipaggiaArma(new Weapon("bastone magioc",Rarity.STARTER,WeaponScaling.WIS));

        dps3.equipaggiaArma(new Weapon("arma leggendaria", Rarity.LEGGENDARIO,WeaponScaling.STR));
        dps3.equipaggiaArmatura(new Armor("armatura leggendaria", Rarity.LEGGENDARIO));



        Enemy goblin = new goblin("goblin",60,20,4,10,10,0.10,1.3,0.10,1);
        Enemy orc = new orco("orco",100,25,10,14,10,0.05,1.4,0.08,1);
        Enemy wraith = new Wraith("wratih",85,30,6,13,10,0.20,1.5,0.15,1);
        Enemy imp = new imp("imp",55,25,3,11,10,0.25,1.6,0.18,1);

        List<Enemy> enemies = new ArrayList<>();
        enemies.add(goblin);
        enemies.add(orc);
        enemies.add(wraith);
        enemies.add(imp);

        Battle battle = new Battle(heroes,enemies);
        battle.Start();
    }
}
