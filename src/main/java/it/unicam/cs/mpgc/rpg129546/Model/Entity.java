package it.unicam.cs.mpgc.rpg129546.Model;

import it.unicam.cs.mpgc.rpg129546.Equipment.Armor;
import it.unicam.cs.mpgc.rpg129546.Equipment.Weapon;
import it.unicam.cs.mpgc.rpg129546.Items.InventoryManager;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Effects.EffectApplier;
import it.unicam.cs.mpgc.rpg129546.Effects.EffectManager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.mpgc.rpg129546.Model.Managers.StatsManager;
import it.unicam.cs.mpgc.rpg129546.Model.Managers.StatusManager;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;


import java.util.List;

import static it.unicam.cs.mpgc.rpg129546.Equipment.Rarity.STARTER;
import static it.unicam.cs.mpgc.rpg129546.Equipment.WeaponScaling.STR;

/**
 * contiene tutte le informazioni e i metodi necessari per definire un untita, nemico o eroe che sia, presente nel gioco
 */
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
    protected InventoryManager inventoryManager;
    protected EffectManager EffectManager;
    protected EffectApplier EffectaApplier;
    protected StatsManager statsManager;
    protected StatusManager statusManager;
    protected List<Action> azioni;

    public Entity(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl){
        this.maxHp=maxHp;
        this.hp = maxHp;
        this.maxAp=maxAp;
        this.ap=maxAp;
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
        this.inventoryManager = new InventoryManager();
        this.statsManager = new StatsManager(this);
        this.statusManager = new StatusManager(this,this.hp,this.maxHp,this.ap,this.maxAp, this.lvl,this.isAlive);
        this.arma = new Weapon("arma iniziale",STARTER,STR);
        this.armatura = new Armor("armatura iniziale" ,STARTER);
    }
    /**
     * crea un nuovo personaggio ENTITY inizianizzaondone statistiche e progressione
     */
    public Entity() {

    }
    /**
     * definisce tutti gli sprite utilizzati in base all' azione che effettua o subisce l'entità
     * @param type tipo di azione effettuata o subita
     * @return sprite da utilizzare
     */
    public abstract SpriteData getSpriteData(AnimationType type);

    public Weapon getArma(){
        return this.arma;
    }

    public Armor getArmatura(){
        return this.armatura;
    }

    /**
     * scambia l'arma passata in parametro, con quella attualmente equipaggiata
     * @param armaNuova arma da equipaggiare
     */
    public void equipaggiaArma(Weapon armaNuova){
        this.arma=armaNuova;
    }

    /**
     * scambia l'armatura passata in parametro con quella attualmente equipaggiata
     * @param armaturaNuova armatura da equipaggiare
     */
    public void equipaggiaArmatura(Armor armaturaNuova){
        this.armatura=armaturaNuova;
    }

    public EffectManager getEffectManager(){
        return this.EffectManager;
    }

    public InventoryManager getInventoryManager(){
        return this.inventoryManager;
    }

    @JsonIgnore
    public EffectApplier getEffectaApplier(){
        return this.EffectaApplier;
    }

    @JsonIgnore
    public StatsManager getStatsManager(){return this.statsManager;}

    public StatusManager getStatusManager(){return this.statusManager;}

    public int getAtk(){return this.atk;}

    public int getWis(){return this.wis;}

    public int getDif(){return this.dif;}

    public double getEva(){return this.eva;}

    public double getCritMult(){return this.critMult;}

    public double getCritChance(){return this.critChance;}

    public String getNome() {return this.nome;}

    @JsonIgnore
    public List<Action> getAzioni(){ return this.azioni;}

    /**
     * controlla se tra le azioni gia presenti nella lista dell'entità, è presente l'azione passata in parametro
     * @param a azione da ricercare
     * @return true se l'azione è presente, false altrimenti
     */
    public boolean hasAbility(Action a){
        for(Action action : azioni){
            if(action.getClass() == a.getClass()) return true;
        }
        return false;
    }
}
