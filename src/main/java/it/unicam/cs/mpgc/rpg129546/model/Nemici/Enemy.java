package it.unicam.cs.mpgc.rpg129546.model.Nemici;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;

public class Enemy extends Entity {
    protected int numeroAzioni = 4;
    private final int taglia;
    private final int xpDrop;
    public Enemy(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl, int taglia, int xpDrop) {
        super(nome, maxHp, maxAp, dif, atk, wis, eva, critMult, critChance, lvl);
        this.azioni = new ArrayList<>(numeroAzioni);
        this.taglia = taglia;
        this.xpDrop= xpDrop;
    }

    public int getTaglia() {
        return this.taglia;
    }

    public int getScaledTaglia() {
        return this.taglia + (2 + this.getLvl());
    }

    public int getXpDrop() {
        return this.xpDrop;
    }

    public int getScaledXpDrop(){
        return this.xpDrop + (2 * this.getLvl());
    }
}
