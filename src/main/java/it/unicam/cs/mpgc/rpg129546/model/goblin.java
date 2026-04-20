package it.unicam.cs.mpgc.rpg129546.model;

public class goblin extends Enemy{
    public goblin(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl);
        this.hp=this.maxHp=50;
        this.ap=this.maxAp=20;
        this.dif=5;
        this.atk=8;
        this.eva=0.10;
        this.critChance=0.10;
        this.critMult=1.5;
    }
}
