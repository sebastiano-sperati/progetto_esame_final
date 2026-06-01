package it.unicam.cs.mpgc.rpg129546.model.Eroi;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;

public class Hero extends Entity {
    protected int xp;
    protected int sogliaLvlUp;
    protected int numeroAzioni;
    protected int gold;
    public Hero(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl);
        this.gold=0;
        this.xp = 0;
        this.numeroAzioni=4;
        this.azioni=new ArrayList<>(numeroAzioni);
        this.sogliaLvlUp = sogliaLvlUp;
    }

    public int getGold(){return this.gold;}

    public void addGold(int ammount){this.gold += ammount;}

    public void subGold(int ammount){
        this.gold -= ammount;
        if(this.gold < 0) this.gold = 0;
    }

    protected int getXp(){ return this.xp; }

    public void addXp(int rewardedXp){
        this.xp += rewardedXp;
        while(this.xp >= this.sogliaLvlUp){
            this.xp = this.xp - this.sogliaLvlUp;
            this.sogliaLvlUp = (int) (this.sogliaLvlUp * 1.2);
            this.lvlUp();
        }
    }

    public void lvlUp(){
        this.lvl++;
    }

}
