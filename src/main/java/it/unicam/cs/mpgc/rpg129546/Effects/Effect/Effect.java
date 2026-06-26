package it.unicam.cs.mpgc.rpg129546.Effects.Effect;

import it.unicam.cs.mpgc.rpg129546.Effects.TickType;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

/**
 * contiene i metodi necessari a definire un effetto
 */
public interface Effect {
    /**
     * decrementa di 1 la statistica tick ad ogni richiamo, facendo da contatore per la sua durata
     */
    void tick();

    /**
     * controlla quando tick arriva a zero
     * @return true se tick == 0 false altrimenti
     */
    boolean isExpired();

    /**
     *
     * @return la durata totale dell'effetto
     */
    int getDuration();
    String getNome();

    /**
     *
     * @return il numero attuale di tick
     */
    int getTick();

    /**
     *
     * @return il tipo di tick associato all'abilità, se modifica le statistiche o fa danno nel tempop
     */
    TickType getType();

    /**
     *applica danno ad un entità ad ogni richiamo
     * @param e entità da danneggiare
     */
    default void damageOverTime(Entity e){}

    /**
     * modifica l'attacco senza cambiare la statistica iniziale
     * @param atk valore iniziale da modificare
     * @return valore modificato
     */
    default int modifyAtk(int atk) {
        return atk;
    }

    /**
     * modifica la difesa senza cambiare la statistica iniziale
     * @param dif valore iniziale da modificare
     * @return valore modificato
     */
    default int modifyDif(int dif) {
        return dif;
    }

    /**
     * modifica l'evasione senza cambiare la statistica iniziale
     * @param eva valore iniziale da modificare
     * @return valore modificato
     */
    default double modifyEva(double eva) {
        return eva;
    }

    /**
     * modifica gli hp senza cambiare la statistica iniziale (non usato ma inserito per correttezza in caso di futuri sviluppi
     * @param hp statistica da modificar statistica modificatee
     * @return
     */
    default int mdifyHP(int hp) {
        return hp;
    }

    /**
     * modifica gli app senza cambiare la statistica iniziale (non usato ma inserito per correttezza in caso di futuri sviluppi)
     * @param ap statistica da modificare
     * @return valore modificato
     */
    default int modifyAp(int ap) {
        return ap;
    }

    /**
     * modifica il moltiplicatore di critico senza modificare la statistica iniziale
     * @param cm statistica da modificare
     * @return valore modificato
     */
    default double modifyCritMult(double cm) {
        return cm;
    }

    /**
     * modifica la probabilità di critico senza modificare la statistica iniziale
     * @param cc statistica da modificare
     * @return valore modificato
     */
    default double modifyCritChance(double cc) {
        return cc;
    }
}
