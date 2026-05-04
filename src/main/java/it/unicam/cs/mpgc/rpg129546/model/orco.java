package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.abilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.abilities.Defend;

public class orco extends Enemy{
    public orco(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl, double chanceFrost) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl, chanceFrost);
        this.hp=this.maxHp=90;
        this.ap=this.maxAp=15;
        this.dif=15;
        this.atk=5;
        this.eva=0.05;
        this.critChance=0.05;
        this.critMult=1.3;
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }
}
