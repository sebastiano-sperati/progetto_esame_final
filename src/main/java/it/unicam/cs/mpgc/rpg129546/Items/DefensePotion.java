package it.unicam.cs.mpgc.rpg129546.Items;

import it.unicam.cs.mpgc.rpg129546.effect.PotionDefenseEffect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class DefensePotion implements Item{
    public String nome = "pozione di difesa";
    private final int maxQta = 5;
    public int qta = 0;
    public ItemType tipo = ItemType.POTION;
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void use(Entity source, Entity target) {
        source.getManager().addEffect(new PotionDefenseEffect());
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
}
