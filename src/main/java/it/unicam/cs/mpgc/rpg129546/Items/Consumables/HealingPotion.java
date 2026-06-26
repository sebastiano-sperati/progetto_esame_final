package it.unicam.cs.mpgc.rpg129546.Items.Consumables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.mpgc.rpg129546.Items.ItemType;
import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

/**
 * cura un entità di una quantità predefinità
 */
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
    public ItemType getTipo() {
        return tipo;
    }

    @Override
    public void setQta(int ammount) {
        this.qta = ammount;
    }

    @Override
    public int getPrezzo() {
        return prezzo;
    }
}
