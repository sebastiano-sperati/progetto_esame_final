package it.unicam.cs.mpgc.rpg129546.Items.Consumabili;

import it.unicam.cs.mpgc.rpg129546.Items.ItemType;
import it.unicam.cs.mpgc.rpg129546.effect.Effetti.Poison;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class PoisonKnives implements Item {
    public String nome = "coltelli veleno";
    private final int maxQta = 5;
    public int qta = 0;
    public ItemType tipo = ItemType.THROWABLE;
    private final int prezzo = 15;
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void use(Entity source, Entity target) {
        target.getEffectManager().addEffect(new Poison());
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
