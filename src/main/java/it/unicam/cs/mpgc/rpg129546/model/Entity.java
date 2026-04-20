package it.unicam.cs.mpgc.rpg129546.model;

public abstract class Entity {
    protected String nome;
    protected int hp, maxHp;
    protected int ap, maxAp;
    protected int dif;
    protected int atk;
    protected double eva;
    protected  double critMult, critChance;
    protected boolean isAlive;
    protected int lvl;
    public Entity(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl){
        this.hp=this.maxHp=maxHp;
        this.ap=this.maxAp=maxAp;
        this.dif=dif;
        this.atk=atk;
        this.eva=eva;
        this.critChance=critChance;
        this.critMult=critMult;
        this.nome=nome;
        this.isAlive=true;
        this.lvl=lvl;
    }

    public String getNome(){ return nome; }

    public int getLvl(){ return lvl; }

    public int getHp(){
        return this.hp;
    }

    public int getMaxHp(){
        return this.maxHp;
    }

    public int getAp(){
        return this.ap;
    }

    public int getMaxAp(){
        return this.maxAp;
    }

    public int getDif(){
        return this.dif;
    }

    public int getAtk(){
        return this.atk;
    }

    public double getEva(){
        return this.eva;
    }

    public double getCritMult(){
        return this.critMult;
    }

    public double getCritChance(){
        return this.critChance;
    }

    public int getScaledHp(){ return this.maxHp + lvl * 7; }

    public int getScaledAp(){ return this.maxAp + lvl * 3;}

    public double getScaledEva(){
        return Math.min(this.eva + lvl*0.005,0.5);
    }

    public double getScaledCritMult(){
        return this.critMult + lvl*0.02;
    }

    public double getScaledCritChance(){
        return Math.min(this.critChance + lvl*0.01,0.6);
    }

    public void takeDamage(int amount){
        this.hp -= amount;
        if(this.hp<0){
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
        if(this.hp>this.maxHp) this.hp=this.maxHp;
    }

    public void restore(int amount){
        this.ap+=amount;
        if(this.ap>this.maxAp) this.ap=this.maxAp;
    }

}
