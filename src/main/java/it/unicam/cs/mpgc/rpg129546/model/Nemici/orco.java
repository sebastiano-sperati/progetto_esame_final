package it.unicam.cs.mpgc.rpg129546.model.Nemici;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.*;

public class orco extends Enemy{
    public orco(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl, int taglia, int xpDrop) {
        super(nome, maxHp, maxAp, dif, atk, wis,  eva, critMult, critChance, lvl, taglia, xpDrop);
        this.hp=this.maxHp=maxHp;
        this.ap=this.maxAp=maxAp;
        this.dif=dif;
        this.atk=atk;
        this.eva=eva;
        this.critChance=critChance;
        this.critMult=critMult;
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new DebufAtk());
    }
}
