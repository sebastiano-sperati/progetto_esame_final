package it.unicam.cs.mpgc.rpg129546.model;

import java.util.ArrayList;

public class Enemy extends Entity{
    protected int numeroAzioni = 4;
    public Enemy(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl, double chanceFrost) {
        super(nome, maxHp, maxAp, dif, atk, eva, critMult, critChance, lvl, chanceFrost);
        this.azioni=new ArrayList<>(numeroAzioni);
    }
}
