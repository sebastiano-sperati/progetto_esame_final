package it.unicam.cs.mpgc.rpg129546.model;

public class StatusManager {

    private final Entity owner;
    private int hp;
    private final int maxHp;
    private  int ap;
    private final int maxAp;
    private  int lvl;
    private  boolean isAlive;

    public StatusManager(Entity owner,int hp, int maxHp, int ap, int maxAp, int lvl,boolean isAlive) {
        this.owner = owner;
        this.hp = hp;
        this.maxHp = maxHp;
        this.ap = ap;
        this.maxAp = maxAp;
        this.lvl = lvl;
        this.isAlive=true;
    }

    public int getHp(){return this.hp;}

    public int getMaxHp(){return this.maxHp;}

    public int getAp(){return this.ap;}

    public int getMaxAp(){return this.maxAp;}

    public int getLvl(){return this.lvl;}

    public boolean isAlive(){return this.isAlive;}

    public void setAlive(boolean stato){this.isAlive = stato;}

    public void takeDamage(int amount){
        this.hp -= amount;
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
        this.hp+=amount;
        if(this.hp>this.getMaxHp()) this.hp=this.getMaxHp();
    }

    public void restore(int amount){
        this.ap+=amount;
        if(this.ap>this.getMaxAp()) this.ap=this.getMaxAp();
    }

    public void lvlUp(){
        this.lvl++;
        owner.getStatusManager().Heal(owner.getStatsManager().getScaledMaxHP());
        owner.getStatusManager().Heal(owner.getStatsManager().getScaledMaxAp());
    }

    public void setHp(int ammount){
        this.hp = ammount;
    }

    public void setAp(int ammount ){
        this.ap = ammount;
    }
}
