package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.abilities.*;

public class Mage extends Hero{
    public Mage(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new Frost());
        azioni.add(new FireBall());
        azioni.add(new Lightning());
    }
}
