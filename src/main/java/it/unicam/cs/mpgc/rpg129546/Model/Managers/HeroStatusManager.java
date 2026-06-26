package it.unicam.cs.mpgc.rpg129546.Model.Managers;

import it.unicam.cs.mpgc.rpg129546.Model.Entity;

/**
 * manager dello status di un singolo eroe.
 * Modifica ed implementa i getter delle statistiche comuni solo agli eroi
 */
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

    /**
     * aggiunge alla quantità di oro di un singolo eroe, quella del reward
     * @param ammount quantità da aggiungere
     */
    public void addGold(int ammount){this.gold += ammount;}

    /**
     * rimuove ad un eroe il prezzo di un item comprato
     * @param ammount quantità da rimuovere
     */
    public void subGold(int ammount){
        this.gold -= ammount;
        if(this.gold < 0) this.gold = 0;
    }

    public int getXp(){ return this.xp; }

    /**
     * aggiunge agli xp di un eroe, la quantità presente nel reward
     * nel caso gli xp, superino la soglia di level up, agli xp, viene sottratta la soglia, viene effettuato un level up,
     * e viene aggiornata la soglia, ciò avviene fino a che la quantità di xp non è minore della soglia di level up, per evitare la perdita di xp in eccesso
     * @param rewardedXp xp da avviungere
     */
    public void addXp(int rewardedXp){
        this.xp += rewardedXp;
        while(this.xp >= this.sogliaLvlUp){
            this.xp = this.xp - this.sogliaLvlUp;
            System.out.println("LEVEL UP!");
            this.sogliaLvlUp = (int) (this.sogliaLvlUp * 1.2);
            this.lvlUp();
            System.out.println("Nuovo livello: " + this.getLvl());
        }
    }

    /**
     * aumenta di 1 il livello di un eroe, e ne riempe vita e stamina,
     * nel caso si vogliano implementare level up in tempo reale durante un combattimento
     */
    public void lvlUp() {
        owner.getStatusManager().lvlUp();
        owner.getStatusManager().Heal(owner.getStatsManager().getScaledMaxHP());
        owner.getStatusManager().restore(owner.getStatsManager().getScaledMaxAp());
    }

    public int getSogliaLvlUp() {
        return sogliaLvlUp;
    }

    /**
     * setta la soglia di level up a quella dell'ultimo salvataggio disponibile
     * @param sogliaLvlUp ultima soglia di level up salvata
     */
    public void setSogliaLvlUp(int sogliaLvlUp) {
        this.sogliaLvlUp = sogliaLvlUp;
    }

    /**
     * setta gli xp a quelli dell ultimo salvataggio disponibile
     * @param xp ultimi xp salvati
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * setta l'oro a quello dell'ultimo salvataggio disponibile
     * @param gold ultimo oro del salvataggio
     */
    public void setGold(int gold){
        this.gold=gold;
    }

    }