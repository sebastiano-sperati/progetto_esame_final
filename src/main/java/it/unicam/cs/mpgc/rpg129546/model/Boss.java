package it.unicam.cs.mpgc.rpg129546.model;

public class Boss extends Enemy{
    public Boss(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl);
        this.hp=this.maxHp=180;
        this.ap=this.maxAp=40;
        this.dif=12;
        this.atk=20;
        this.eva=0.10;
        this.critChance=0.15;
        this.critMult=1.8;
    }
}
