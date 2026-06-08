package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.model.Eroi.*;

import java.util.ArrayList;
import java.util.List;

public class HeroFactory {
    public static List<Hero> generate() {
        Dps dps = new Dps("Furia della Battaglia", 22, 25, 4, 12, 6, 0.25, 2.2, 0.25, 1, 10);
        Tank tank = new Tank("Guardia di Ferro", 55, 12, 12, 5, 3, 0.05, 1.4, 0.05, 1, 10);
        Mage mage = new Mage("Recluso", 24, 35, 5, 14, 12, 0.10, 1.8, 0.10, 1, 10);
        Healer healer = new Healer("Alto Chierico", 30, 30, 7, 6, 15, 0.10, 1.6, 0.10, 1, 10);

        List<Hero> eroi = new ArrayList<>();
        eroi.add(dps);
        eroi.add(tank);
        eroi.add(mage);
        eroi.add(healer);

        return eroi;
    }
}

