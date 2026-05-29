package it.unicam.cs.mpgc.rpg129546.model.Eroi;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.*;

public class Healer extends Hero{
    public Healer(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new Heal());
        azioni.add(new Restore());
        azioni.add(new Revivify());
    }
}
