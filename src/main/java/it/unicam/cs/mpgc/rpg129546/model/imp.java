package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.abilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.abilities.Defend;
import it.unicam.cs.mpgc.rpg129546.abilities.Fear;

public class imp extends Enemy{
    public imp(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl);
        this.hp=this.maxHp=maxHp;
        this.ap=this.maxAp=maxAp;
        this.dif=dif;
        this.atk=atk;
        this.eva=eva;
        this.critChance=critChance;
        this.critMult=critMult;
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new Fear());
    }
}
