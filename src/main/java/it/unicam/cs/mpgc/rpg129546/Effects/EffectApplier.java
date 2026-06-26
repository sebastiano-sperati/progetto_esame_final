package it.unicam.cs.mpgc.rpg129546.Effects;

import it.unicam.cs.mpgc.rpg129546.Effects.Effect.Effect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
/**
 * Calcola le statistiche effettive di un'entità applicando tutti gli effetti attivi.
 *
 * La classe non modifica permanentemente le statistiche base dell'entità:
 * ogni valore viene calcolato partendo dalle statistiche originali e applicando
 * temporaneamente i modificatori forniti dagli effetti attivi.
 *
 * Questo permette di rimuovere un effetto senza perdere i valori originali
 * delle statistiche.
 */
public class EffectApplier {
    /**
     * modifica il danno effettuato da un entità in base agli effetti presenti
     * @param e entità a cui modificare il valore
     * @return valore modificato
     */
    public int modifyDmg(Entity e){
        int dmg = e.getStatsManager().getScaledDmg();
        for (Effect effect : e.getEffectManager().getEffects()){
            dmg =effect.modifyAtk(dmg);
        }
        return dmg;
    }

    /**
     * modifica la difesa di un entità in base agli effetti presenti
     * @param e entità a cui modificare il valore
     * @return valore modificato
     */
    public int modifyDif(Entity e){
        int dif = e.getStatsManager().getScaledDif();
        for (Effect effect:e.getEffectManager().getEffects()){
            dif=effect.modifyDif(dif);
        }
        return dif;
    }

    /**
     * modifica l'evasione di un entità in base agli effetti presenti
     * @param e entità a cui modificare il valore
     * @return valore modificato
     */
    public double modifyEva(Entity e){
        double eva = e.getStatsManager().getScaledEva();
        for (Effect effect : e.getEffectManager().getEffects()){
            eva=effect.modifyEva(eva);
        }
        return eva;
    }

    /**
     * modifica il moltiplicatore di critico di un entita in base agli effetti presenti
     * @param e entita a cui modificare il valore
     * @return valore modificato
     */
    public double modifyCM(Entity e){
        double cm = e.getStatsManager().getScaledCM();
        for (Effect effect : e.getEffectManager().getEffects()){
            cm=effect.modifyCritMult(cm);
        }
        return cm;
    }

    /**
     * modifica la probabilità di critico a un entità in base agli effetti presenti
     * @param e entità a cui modificare i valori
     * @return valore modificato
     */
    public double modifyCC(Entity e){
        double cc = e.getStatsManager().getScaledCC();
        for (Effect effect : e.getEffectManager().getEffects()){
            cc = effect.modifyCritChance(cc);
        }
        return cc;
    }
}
