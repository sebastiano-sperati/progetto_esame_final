package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.abilities.Action;
import it.unicam.cs.mpgc.rpg129546.effect.EffectApplier;
import it.unicam.cs.mpgc.rpg129546.effect.effectManager;
import java.util.List;

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
    protected effectManager manager = new effectManager();
    protected EffectApplier applier = new EffectApplier();
    protected boolean isDefendig;
    protected boolean isCountering;
    protected boolean isScared;
    protected boolean isInspired;
    protected double chanceFrost;
    protected boolean isFrozen;
    protected boolean isAtkDebuffed;
    protected List<Action> azioni;
    protected boolean isOnFire;
    protected double fireChance;


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
        this.manager = new effectManager();
        this.applier = new EffectApplier();
        this.isDefendig = false;
        this.isCountering = false;
        this.isScared = false;
        this.isInspired=false;
        this.chanceFrost = chanceFrost;
        this.isFrozen = false;
        this.isAtkDebuffed = false;
        this.fireChance = fireChance;
        this.isOnFire = false;
    }

    public effectManager getManager(){
        return this.manager;
    }

    public EffectApplier getApplier(){
        return this.applier;
    }

    public int getAtk(){return this.atk;}

    public int getScaledAtk(){return (this.atk + this.lvl * 3);}

    public int getDif(){return this.dif;}

    public int getScaledDif(){return this.dif + this.lvl * 2;}

    public double getEva(){return this.eva;}

    public double getScaledEva(){return Math.min(this.eva + this.lvl *0.005, 0.5); }

    public double getCritMult(){return this.critMult;}

    public double getScaledCM(){return this.critMult + this.lvl *0.02;}

    public double getCritChance(){return this.critChance;}

    public double getScaledCC(){return this.critChance + this.lvl * 0.01;}

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

    public void showAbility(){
        for (int i = 0; i < azioni.size(); i++) {
            Action action = azioni.get(i);

            System.out.println((i+1) + "-" + action.getNome() + "(Costo : " + action.getCosto() + " AP");
        }
    }
}
