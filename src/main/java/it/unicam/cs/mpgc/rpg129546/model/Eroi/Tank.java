package it.unicam.cs.mpgc.rpg129546.model.Eroi;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.*;

public class Tank extends Hero{
    public Tank(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new bless());
        azioni.add(new Ispirazione());
        azioni.add(new Fear());
    }
}
