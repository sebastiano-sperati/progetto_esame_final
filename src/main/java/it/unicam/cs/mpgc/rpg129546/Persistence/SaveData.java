package it.unicam.cs.mpgc.rpg129546.Persistence;

import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;

import java.util.List;

/**
 * gestisce tutte le informazioni necessarie a salvare i dati di una singola partita, sia la lista di eroi, sia il piano corrente
 */
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
