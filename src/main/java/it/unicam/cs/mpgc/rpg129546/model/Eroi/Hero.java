package it.unicam.cs.mpgc.rpg129546.model.Eroi;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;

public class Hero extends Entity {
    protected int xp;
    protected int numeroAzioni;
    public Hero(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl);
        this.xp = 0;
        this.numeroAzioni=4;
        this.azioni=new ArrayList<>(numeroAzioni);
    }

    protected int getXp(){ return this.xp; }

}
