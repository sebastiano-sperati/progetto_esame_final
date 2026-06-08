package it.unicam.cs.mpgc.rpg129546.Equipaggiamento;

import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Armor implements Equipaggiamento{
    private final String nome;
    private final Rarity rarity;

    public Armor(String nome, Rarity rarity){
        this.nome=nome;
        this.rarity=rarity;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @JsonIgnore
    @Override
    public GenericItem getCopy() {
        return new Armor(nome, rarity);
    }

    @Override
    public int getPrezzo() {
        return rarity.getPrezzo();
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public double getModifier(){ return rarity.getModifier(); }
}
