package it.unicam.cs.mpgc.rpg129546.model;

import java.util.ArrayList;

public class Hero extends Entity{
    protected int xp;
    protected int numeroAzioni;
    public Hero(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl, double chanceFrost) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl, chanceFrost);
        this.xp = 0;
        this.numeroAzioni=4;
        this.azioni=new ArrayList<>(numeroAzioni);
    }
    protected int getXp(){ return this.xp; }
}
