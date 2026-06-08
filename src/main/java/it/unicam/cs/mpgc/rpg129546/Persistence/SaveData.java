package it.unicam.cs.mpgc.rpg129546.Persistence;

import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;

public class SaveData {

    private List<Hero> heroes;
    private int floor;

    public SaveData() {}

    public SaveData(List<Hero> heroes, int floor) {
        this.heroes = heroes;
        this.floor = floor;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
