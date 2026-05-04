package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.abilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.abilities.Defend;

public class goblin extends Enemy{
    public goblin(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl ,double chanceFrost) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl, chanceFrost);
        this.hp=this.maxHp=50;
        this.ap=this.maxAp=20;
        this.dif=5;
        this.atk=8;
        this.eva=0.10;
        this.critChance=0.10;
        this.critMult=1.5;
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }
}
