package it.unicam.cs.mpgc.rpg129546.Items.Consumabili;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.mpgc.rpg129546.Items.ItemType;
import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class HealingPotion implements Item {
    public String nome = "pozione di cura";
    private final int maxQta = 5;
    public int qta = 0;
    public ItemType tipo = ItemType.POTION;
    private final int prezzo = 5;
    @Override
    public String getNome() {
        return nome;
    }

    @JsonIgnore
    @Override
    public GenericItem getCopy() {
        return new HealingPotion();
    }

    @Override
    public void use(Entity source, Entity target) {
        source.getStatusManager().Heal(10);
    }

    @Override
    public boolean isFull() {
        return qta == maxQta;
    }

    @Override
    public boolean isEmpty() {
        return qta == 0;
    }

    @Override
    public void increaseCount() {
        qta++;
    }

    @Override
    public void decreaseCount() {
        qta--;
    }

    @Override
    public int getQta() {
        return qta;
    }

    @Override
    public int getMaxQta() {
        return maxQta;
    }

    @Override
    public ItemType getTipo() {
        return tipo;
    }

    @Override
    public int getPrezzo() {
        return prezzo;
    }
}
