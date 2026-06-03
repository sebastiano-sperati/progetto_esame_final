package it.unicam.cs.mpgc.rpg129546.model.Eroi;

import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.StatusManager;

public class HeroStatusManager extends StatusManager {
    protected int xp;
    protected int sogliaLvlUp;
    protected int gold;
    public HeroStatusManager(Entity owner, int hp, int maxHp, int ap, int maxAp, int lvl, boolean isAlive, int xp, int sogliaLvlUp, int gold) {
        super(owner, hp, maxHp, ap, maxAp, lvl, isAlive);
        this.xp = xp;
        this.sogliaLvlUp = sogliaLvlUp;
        this.gold = gold;
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
}
