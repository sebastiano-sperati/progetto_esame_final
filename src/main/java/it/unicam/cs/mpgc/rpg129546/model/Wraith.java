package it.unicam.cs.mpgc.rpg129546.model;

public class Wraith extends Enemy{
    public Wraith(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl);
        this.hp=this.maxHp=35;
        this.ap=this.maxAp=30;
        this.dif=2;
        this.atk=20;
        this.eva=0.15;
        this.critChance=0.25;
        this.critMult=2.0;
    }
}
