package it.unicam.cs.mpgc.rpg129546.Model.Managers;

import it.unicam.cs.mpgc.rpg129546.Equipment.WeaponScaling;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

/**
 * gestisce la logica di tutte le statiscìtiche, comuni a tutte le entità.
 * Permette uno scaling dinamico in base a livello, armi e armature equipaggiate, senza mai andare a modificare le statistiche di base
 */
public class StatsManager {
    private final Entity owner;

    public StatsManager (Entity owner){
        this.owner = owner;
    }

    /**
     * calcola l'effettivo danno effettuato da un entità,
     * dividendolo tra danno fisico e danno magico, in  base allo scaling dell'arma equipaggiata
     * e moltiplicando il danno effettuato per il modificatore dell'arma
     * @return danno effettuato corretto
     */
    public int getScaledDmg(){
        if(owner.getArma().getScaling() == WeaponScaling.STR) {
            return (int) (getScaledAtk() * owner.getArma().getModifier());
        }
        return (int) (getScaledWis() * owner.getArma().getModifier());

    }

    /**
     * @return il danno effettuato utilizzando la statistica atk
     */
    public int getScaledAtk(){
        return owner.getAtk()  + owner.getStatusManager().getLvl() * 3;
    }

    /**
     * @return il danno effettuato utilizzando la statistica wif
     */
    public int getScaledWis(){
        return owner.getWis() + owner.getStatusManager().getLvl() * 3;
    }

    /**
     *
     * @return la difesa scalata, moltiplicata per il modificatore dell'armatura equipaggiata
     */
    public int getScaledDif(){ return (int) ((owner.getDif() + owner.getStatusManager().getLvl() * 2) + owner.getArmatura().getModifier());}

    /**
     *
     * @return l'evasione scalata, dandole un valore massimo raggiungibile di 0.5
     */
    public double getScaledEva(){
        return Math.min(owner.getEva() + owner.getStatusManager().getLvl() * 0.005,0.5);
    }

    /**
     *
     * @return il moltiplicatore di critico scalato
     */
    public double getScaledCM(){
        return owner.getCritMult() + owner.getStatusManager().getLvl() * 0.02;
    }

    /**
     * @return la probabilità di critico scalata
     */
    public double getScaledCC(){
        return owner.getCritChance() + owner.getStatusManager().getLvl() * 0.01;
    }

    /**
     *
     * @return gli hp massimi scalati
     */
    public int getScaledMaxHP(){
        return owner.getStatusManager().getMaxHp() + owner.getStatusManager().getLvl() * 2;
    }

    /**
     *
     * @return la stamina massima scalata
     */
    public int getScaledMaxAp(){return owner.getStatusManager().getMaxAp() + owner.getStatusManager().getLvl() * 2;}
}
