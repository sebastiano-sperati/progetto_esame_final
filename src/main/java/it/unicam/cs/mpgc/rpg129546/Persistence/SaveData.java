package it.unicam.cs.mpgc.rpg129546.Persistence;

import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;

import java.util.List;

public class SaveData {

    private List<HeroSave> heroes;
    private int floor;

    public SaveData() {}

    public SaveData(List<HeroSave> heroes, int floor) {
        this.heroes = heroes;
        this.floor = floor;
    }

    public List<HeroSave> getHeroes() {
        return heroes;
    }

    public int getFloor() {
        return floor;
    }
}
