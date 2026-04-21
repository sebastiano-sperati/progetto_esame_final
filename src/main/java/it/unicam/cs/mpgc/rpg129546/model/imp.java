package it.unicam.cs.mpgc.rpg129546.model;

public class imp extends Enemy{
    public imp(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl, double chanceFrost) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl, chanceFrost);
        this.hp=this.maxHp=60;
        this.ap=this.maxAp=25;
        this.dif=6;
        this.atk=14;
        this.eva=0.12;
        this.critChance=0.18;
        this.critMult=1.7;
    }
}
