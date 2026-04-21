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
    protected boolean isDefendig;
    protected boolean isCountering;
    protected boolean isScared;
    protected boolean isInspired;
    protected double chanceFrost;
    protected boolean isFrozen;
    public Entity(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl, double chanceFrost){
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
        this.isDefendig = false;
        this.isCountering = false;
        this.isScared = false;
        this.isInspired=false;
        this.chanceFrost = chanceFrost;
        this.isFrozen = false;
    }

    public void setFrozen(boolean stato){ this.isFrozen = stato; }

    public double getChanceFrost(){ return this.chanceFrost; }

    public boolean isInspired(){ return this.isInspired; }

    public void setInspired(boolean stato) { this.isInspired = stato; }

    public boolean isScared(){ return this.isScared; }

    public void setScared(boolean stato) { this.isScared = stato; }

    public boolean isCountering() { return this.isCountering;}

    public void setCounter(boolean stato){ this.isCountering = stato; }

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
        if(this.isCountering) return Math.min((this.eva + lvl*0.005) * 1.5,0.5); //*se il beraglio è nello stato counter aumenta l' eva del 50%
        return Math.min(this.eva + lvl*0.005,0.5);
    }

    public double getScaledCritMult(){
        return this.critMult + lvl*0.02;
    }

    public double getScaledCritChance(){
        return Math.min(this.critChance + lvl*0.01,0.6);
    }

    public int getScaledAtk(){
        if(this.isScared) return (int) ((this.atk + lvl * 3) * 0.75);
        return this.atk + lvl * 3;
    }

    public int getScaledDif() {
        if(this.isCountering || this.isInspired || this.isFrozen) return (int)((this.dif + lvl *2)*1.5);//*se il beraglio è nello stato counter o è inspirato aumenta la difesa del 50%
        return this.dif + lvl *2;
    }

    public boolean isAlive() { return isAlive; }

    public void setAlive(boolean stato) { this.isAlive = stato; }

    public boolean isDefendig(){ return isDefendig; }

    public void setDefendig(boolean stato){ this.isDefendig = stato; }

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
