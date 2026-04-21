package it.unicam.cs.mpgc.rpg129546.model;

public class Hero extends Entity{
    protected int xp;
    public Hero(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl, double chanceFrost) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl, chanceFrost);
        this.xp = 0;
    }
    protected int getXp(){ return this.xp; }
}
