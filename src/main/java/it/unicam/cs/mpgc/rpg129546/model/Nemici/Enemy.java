package it.unicam.cs.mpgc.rpg129546.model.Nemici;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;

public class Enemy extends Entity {
    protected int numeroAzioni = 4;
    public Enemy(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk, wis, eva, critMult, critChance, lvl);
        this.azioni=new ArrayList<>(numeroAzioni);
    }
}
