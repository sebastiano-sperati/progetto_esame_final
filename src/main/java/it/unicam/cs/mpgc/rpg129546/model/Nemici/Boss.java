package it.unicam.cs.mpgc.rpg129546.model.Nemici;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities.*;

public class Boss extends Enemy{
    public Boss(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl, int taglia, int xpDrop) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl, taglia, xpDrop);
        this.hp=this.maxHp=180;
        this.ap=this.maxAp=40;
        this.dif=12;
        this.atk=20;
        this.eva=eva;
        this.critChance=critChance;
        this.critMult=critMult;
        azioni.add(new MultiAtk());
        azioni.add(new FireBall());
        azioni.add(new DebufAtk());
        azioni.add(new Defend());
        azioni.add(new BaseAtk());
    }
}
