package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class Taunt implements Action{
    private final int cost = 6;
    private final String nome = "affronto";

    @Override
    public void execute(Entity source, Entity target) {
        //alla creazione della classe combat, modificare questa classe per far si che il target di un nemico diventi questa classe
    }
    @Override
    public String getNome(){
        return this.nome;
    }
    @Override
    public int getCosto(){
        return this.cost;
    }
}
