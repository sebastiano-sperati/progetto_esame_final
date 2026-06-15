package it.unicam.cs.mpgc.rpg129546.Model.Enemies;

import it.unicam.cs.mpgc.rpg129546.Model.Entity;

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

    public int getScaledTaglia() {
        return this.taglia + (2 + this.getStatusManager().getLvl());
    }

    public int getScaledXpDrop(){
        return this.xpDrop + (2 * this.getStatusManager().getLvl());
    }
}
