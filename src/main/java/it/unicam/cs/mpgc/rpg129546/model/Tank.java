package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.abilities.*;

public class Tank extends Hero{
    public Tank(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new bless());
        azioni.add(new Ispirazione());
        azioni.add(new Fear());
    }
}
