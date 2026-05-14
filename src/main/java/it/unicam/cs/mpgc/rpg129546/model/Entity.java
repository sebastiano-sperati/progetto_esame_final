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
    protected List<Action> azioni;

    public Entity(String nome, int maxHp, int maxAp, int dif, int atk, double eva, double critMult, double critChance, int lvl){
        this.maxHp=maxHp;
        this.hp=this.getMaxHp();
        this.maxAp=maxAp;
        this.ap=this.getMaxAp();
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

    public boolean isAlive(){return this.isAlive;}

    public void setAlive(boolean stato){ this.isAlive = stato;}

    public int getLvl(){ return this.lvl;}

    public int getHp(){return this.hp;}

    public int getMaxAp() {
        return maxAp + lvl * 2;
    }

    public int getAp(){return this.ap;}

    public int getMaxHp() {
        return maxHp + lvl * 2;
    }

    public String getNome() {return this.nome;}

    public List<Action> getAzioni(){ return this.azioni;}

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
        if(this.hp>this.getMaxHp()) this.hp=this.getMaxHp();
    }

    public void restore(int amount){
        this.ap+=amount;
        if(this.ap>this.getMaxAp()) this.ap=this.getMaxAp();
    }

    public void showAbility(){
        for (int i = 0; i < azioni.size(); i++) {
            Action action = azioni.get(i);

            System.out.println((i+1) + "-" + action.getNome() + "(Costo : " + action.getCosto() + " AP");
        }
    }

    public void showSquadStats(List<? extends Entity> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNome());
            System.out.print(": HP " + list.get(i).getHp() + "/" + list.get(i).getMaxHp() + " | ");
            System.out.println("AP " + list.get(i).getAp() + "/" + list.get(i).getMaxAp() );
            System.out.println("Atk: " + list.get(i).getApplier().modifyAtk(list.get(i)) + " | Dif: " + list.get(i).getApplier().modifyDif(list.get(i)));
            System.out.println("Prob crit: " + list.get(i).getApplier().modifyCC(list.get(i)) + " Danno critico: " + list.get(i).getApplier().modifyCM(list.get(i))+ " Schivata: " + list.get(i).getApplier().modifyEva(list.get(i)));
            list.get(i).manager.showEffects();
            System.out.println();
        }
    }
}
