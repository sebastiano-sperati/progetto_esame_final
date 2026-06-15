package it.unicam.cs.mpgc.rpg129546.Model.Managers;

import it.unicam.cs.mpgc.rpg129546.Abilities.AbilityRegistry;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

public class StatusManager {

    protected final Entity owner;
    private int hp;
    private final int maxHp;
    private  int ap;
    private final int maxAp;
    protected int lvl;
    private  boolean isAlive;

    public StatusManager(Entity owner,int hp, int maxHp, int ap, int maxAp, int lvl,boolean isAlive) {
        this.owner = owner;
        this.hp = hp;
        this.maxHp = maxHp;
        this.ap = ap;
        this.maxAp = maxAp;
        this.lvl = lvl;
        this.isAlive=isAlive;
    }

    public int getHp(){return this.hp;}

    public int getMaxHp(){return this.maxHp;}

    public int getAp(){return this.ap;}

    public int getMaxAp(){return this.maxAp;}

    public int getLvl(){return this.lvl;}

    public void lvlUp(){
        this.lvl++;
        if (owner instanceof Hero) {
            AbilityRegistry.getAbilityFor((Hero) owner);
        }
    }

    public boolean isAlive(){return this.isAlive;}

    public void setAlive(boolean stato){this.isAlive = stato;}

    public void takeDamage(int amount){
        this.hp -= amount;
        System.out.println(owner.getNome() + " subisce " + amount + " danni");
        if(this.hp<=0){
            this.hp=0;
            this.isAlive=false;
        }
    }

    public void consumeAp(int amount){
        this.ap-=amount;
        if(this.ap<0) this.ap=0;
    }

    public void Heal(int amount){
        this.hp += amount;
        if(this.hp > owner.getStatsManager().getScaledMaxHP()) this.hp = owner.getStatsManager().getScaledMaxHP();
    }

    public void restore(int amount){
        this.ap+=amount;
        if(this.ap>owner.getStatsManager().getScaledMaxAp()) this.ap=owner.getStatsManager().getScaledMaxAp();
    }

    public void setHp(int ammount){
        this.hp = ammount;
    }

    public void setAp(int ammount ){
        this.ap = ammount;
    }
}
