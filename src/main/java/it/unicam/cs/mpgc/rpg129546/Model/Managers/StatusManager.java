package it.unicam.cs.mpgc.rpg129546.Model.Managers;

import it.unicam.cs.mpgc.rpg129546.Abilities.AbilityRegistry;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

/**
 * implementa la logica per gestire lo status di un entità generica, utilizzando tutti gli attributi comuni tra eroi e nemici
 */
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

    /**
     * aumenta di 1 il livello di un eroe, e controlla se esiste la possibilità di ottenere una nuova abilità
     */
    public void lvlUp(){
        this.lvl++;
        if (owner instanceof Hero) {
            AbilityRegistry.getAbilityFor((Hero) owner);
        }
    }

    public boolean isAlive(){return this.isAlive;}

    public void setAlive(boolean stato){this.isAlive = stato;}

    /**
     * toglie hp ad un entità, rendendolo morto nel caso gli hp siano <= 0
     * @param amount hp da togliere
     */
    public void takeDamage(int amount){
        this.hp -= amount;
        System.out.println(owner.getNome() + " subisce " + amount + " danni");
        if(this.hp<=0){
            this.hp=0;
            this.isAlive=false;
        }
    }

    /**
     * consuma parte della stamina di un entità
     * @param amount stamina da eliminare
     */
    public void consumeAp(int amount){
        this.ap-=amount;
        if(this.ap<0) this.ap=0;
    }

    /**
     * cura un entità , impedendole di venir curata più dei suoi hp massimi
     * @param amount hp da aggiungere
     */
    public void Heal(int amount){
        this.hp += amount;
        if(this.hp > owner.getStatsManager().getScaledMaxHP()) this.hp = owner.getStatsManager().getScaledMaxHP();
    }

    /**
     * rigenera parte della stamina di un entità, impedendone di recuperare più stamina rispetto alla sua quantità massima
     * @param amount stamina da recuperare
     */
    public void restore(int amount){
        this.ap+=amount;
        if(this.ap>owner.getStatsManager().getScaledMaxAp()) this.ap=owner.getStatsManager().getScaledMaxAp();
    }

    /**
     * imposta gli hp pari aquelli trovati nell'ultimo salvataggio disponibile
     * @param ammount hp presenti nell'umtimo salvataggio
     */
    public void setHp(int ammount){
        this.hp = ammount;
    }

    /**
     * setta la stamina pari a quella trovata nell'ultimo salvataggio disponibile
     * @param ammount stamina presenta nell'ultimo salvataggio
     */
    public void setAp(int ammount ){
        this.ap = ammount;
    }
}
