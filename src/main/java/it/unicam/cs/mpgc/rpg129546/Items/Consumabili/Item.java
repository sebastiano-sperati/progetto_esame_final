package it.unicam.cs.mpgc.rpg129546.Items.Consumabili;

import it.unicam.cs.mpgc.rpg129546.Items.ItemType;
import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.Random;

public interface Item extends GenericItem {
    void use (Entity source, Entity target);
    boolean isFull();
    boolean isEmpty();
    void increaseCount();
    void decreaseCount();
    int getQta();
    int getMaxQta();
    ItemType getTipo();
    @Override
    public default int getShopQta(){
        Random random = new Random();
        return random.nextInt(6) + 2;
    }
}
