package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Armor;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Weapon;
import it.unicam.cs.mpgc.rpg129546.Items.InventoryManager;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Action;
import it.unicam.cs.mpgc.rpg129546.effect.EffectApplier;
import it.unicam.cs.mpgc.rpg129546.effect.EffectManager;

import java.util.List;

import static it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Rarity.STARTER;
import static it.unicam.cs.mpgc.rpg129546.Equipaggiamento.WeaponScaling.STR;
import static it.unicam.cs.mpgc.rpg129546.Equipaggiamento.WeaponScaling.WIS;

public abstract class Entity {
    protected String nome;
    protected int hp, maxHp;
    protected int ap, maxAp;
    protected int dif;
    protected int atk;
    protected int wis;
    protected double eva;
    protected  double critMult, critChance;
    protected boolean isAlive;
    protected int lvl;
    protected Weapon arma;
    private Armor armatura;
    protected InventoryManager inventoryManager = new InventoryManager();
    protected EffectManager EffectManager = new EffectManager();
    protected EffectApplier EffectaApplier = new EffectApplier();
    protected List<Action> azioni;

    public Entity(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl){
        this.maxHp=maxHp;
        this.hp=this.getMaxHp();
        this.maxAp=maxAp;
        this.ap=this.getMaxAp();
        this.dif=dif;
        this.atk=atk;
        this.wis=wis;
        this.eva=eva;
        this.critChance=critChance;
        this.critMult=critMult;
        this.nome=nome;
        this.isAlive=true;
        this.lvl=lvl;
        this.EffectManager = new EffectManager();
        this.EffectaApplier = new EffectApplier();
        this.arma = new Weapon("arma comune",STARTER,STR);
        this.armatura = new Armor("armatura comune",STARTER);
    }

    public Weapon getArma(){
        return this.arma;
    }

    public Armor getArmatura(){
        return this.armatura;
    }

    public void equipaggiaArma(Weapon armaNuova){
        this.arma=armaNuova;
    }

    public void equipaggiaArmatura(Armor armaturaNuova){
        this.armatura=armaturaNuova;
    }

    public EffectManager getEffectManager(){
        return this.EffectManager;
    }

    public InventoryManager getInventoryManager(){
        return this.inventoryManager;
    }

    public EffectApplier getEffectaApplier(){
        return this.EffectaApplier;
    }

    public int getAtk(){return this.atk;}

    public int getScaledAtk(){return (this.atk + this.lvl * 3);}

    public int getWis(){return this.wis;}

    public int getScaledWis(){return (int) (this.wis + this.lvl * 3);}

    public int getScaledDmg(){
        if(this.arma.getScaling()==WIS){
            return (int) (this.getScaledWis() * this.arma.getModifier());
        }
        return (int) (this.getScaledAtk() * this.arma.getModifier());
    }

    public int getDif(){return this.dif;}

    public int getScaledDif(){return (int) ((this.dif + this.lvl * 2) * this.armatura.getModifier());}

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

    public void showAbility(){
        for (int i = 0; i < azioni.size(); i++) {
            Action action = azioni.get(i);

            System.out.println((i+1) + "-" + action.getNome() + "(Costo : " + action.getCosto() + " AP)");
        }
    }

    public void showSquadStats(List<? extends Entity> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNome());
            System.out.print(": HP " + list.get(i).getHp() + "/" + list.get(i).getMaxHp() + " | ");
            System.out.println("AP " + list.get(i).getAp() + "/" + list.get(i).getMaxAp() );
            System.out.println("Atk: " + list.get(i).getEffectaApplier().modifyAtk(list.get(i)) + " | Dif: " + list.get(i).getEffectaApplier().modifyDif(list.get(i)));
            System.out.print("Prob crit: ");
            System.out.printf("%.2f",list.get(i).getEffectaApplier().modifyCC(list.get(i)));
            System.out.print(" Danno critico: " + list.get(i).getEffectaApplier().modifyCM(list.get(i)) + " Schivata: ");
            System.out.printf("%.2f",list.get(i).getEffectaApplier().modifyEva(list.get(i)));
            System.out.println();
            list.get(i).EffectManager.showEffects();
            System.out.println();
        }
    }

}
