package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.abilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.abilities.DebufAtk;
import it.unicam.cs.mpgc.rpg129546.abilities.Defend;

public class orco extends Enemy{
    public orco(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl);
        this.hp=this.maxHp=90;
        this.ap=this.maxAp=15;
        this.dif=15;
        this.atk=5;
        this.eva=0.05;
        this.critChance=0.05;
        this.critMult=1.3;
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new DebufAtk());
    }
}
