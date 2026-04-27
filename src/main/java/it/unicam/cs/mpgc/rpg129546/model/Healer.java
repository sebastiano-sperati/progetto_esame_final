package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.abilities.*;

public class Healer extends Hero{
    public Healer(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl, double chanceFrost) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl, chanceFrost);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new Heal());
        azioni.add(new Restore());
        azioni.add(new Revivify());
    }
}
