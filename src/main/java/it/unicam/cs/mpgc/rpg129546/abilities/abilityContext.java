package it.unicam.cs.mpgc.rpg129546.abilities;

import it.unicam.cs.mpgc.rpg129546.model.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Hero;

import java.util.List;

public class abilityContext {
    private List<Hero> alleati;
    private List<Enemy> nemici;
    public abilityContext(List<Hero> alleati, List<Enemy> nemici){
        this.alleati=alleati;
        this.nemici=nemici;
    }
    public List<Enemy> getEnemys(){
        return nemici;
    }

    public List<Hero> getAlleati(){
        return alleati;
    }
}
