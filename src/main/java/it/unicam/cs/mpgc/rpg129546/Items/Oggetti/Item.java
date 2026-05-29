package it.unicam.cs.mpgc.rpg129546.Items.Oggetti;

import it.unicam.cs.mpgc.rpg129546.Items.ItemType;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

public interface Item {
    String getNome();
    void use (Entity source, Entity target);
    boolean isFull();
    boolean isEmpty();
    void increaseCount();
    void decreaseCount();
    int getQta();
    int getMaxQta();
    ItemType getTipo();
    int getPrezzo();
}
