package it.unicam.cs.mpgc.rpg129546.Items.Consumables;

import it.unicam.cs.mpgc.rpg129546.Items.ItemType;
import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

import java.util.Random;

/**
 * definisce tutti i metodi che servono a definire un oggetto
 */
public interface Item extends GenericItem {
    void use (Entity source, Entity target);

    /**
     * controlla se è possibile continuare a portare altri oggetti dello stesso tipo
     * @return true e l'attuale quantità di oggetti non supera la quantità massima portabile per oggetto, false altrimenti
     */
    boolean isFull();

    /**
     * controlla che ci siano ancora oggetti dello stesso tipo nell'inventario
     * @return true se l'attuale quantita di oggetti è > 0, false altrimenti
     */
    boolean isEmpty();

    /**
     * aumenta di 1 la quantità di oggetti dello stesso tipo
     */
    void increaseCount();

    /**
     * all'utilizzo, decrementa di 1 il numero di oggetti dello stesso tipo di quello appena usato
     */
    void decreaseCount();

    /**
     *
     * @return l'attuale quantità di oggetti di uno stesso tipo presenti nell'inventario
     */
    int getQta();

    /**
     *
     * @return il tipo di utilizzo che ha un oggetto
     */
    ItemType getTipo();

    /**
     * la possibile quantità di oggetti presenti nello shop in base al tipo di oggetto
     * @return
     */
    @Override
    default int getShopQta(){
        Random random = new Random();
        return random.nextInt(6) + 2;
    }

    /**
     * fissa la quantità di oggetti ad ammount
     * @param ammount quantità di oggetti da fissare
     */
    void setQta(int ammount);
}
