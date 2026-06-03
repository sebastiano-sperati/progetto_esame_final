package it.unicam.cs.mpgc.rpg129546.model.Eroi;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;

public class Hero extends Entity {
    protected int xp;
    protected int sogliaLvlUp;
    protected int numeroAzioni;
    protected int gold;
    protected HeroStatusManager heroStatusManager;
    public Hero(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl);
        this.gold=0;
        this.xp = 0;
        this.numeroAzioni=4;
        this.azioni=new ArrayList<>(numeroAzioni);
        this.sogliaLvlUp = sogliaLvlUp;
        this.heroStatusManager = new HeroStatusManager(this,hp,maxHp,atk,maxAp,lvl,isAlive,xp,sogliaLvlUp,gold);
    }

    public HeroStatusManager getHeroStatusManager(){return this.heroStatusManager;}
}
