package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Combat.Battle;
import it.unicam.cs.mpgc.rpg129546.Game.Factory.EnemyFactory;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;

import java.util.List;

public class Game {

    private final List<Hero> heroes;
    private List<Enemy> enemies;
    private Battle currentBattle;
    private final Shop shop;

    private int floor;

    public Game(List<Hero> heroes) {
        this.heroes = heroes;
        this.shop = new Shop();
        this.floor = 1;
    }

    public void startNewBattle() {
        enemies = EnemyFactory.generate(floor);
        currentBattle = new Battle(heroes, enemies);
        currentBattle.startBattle();
    }

    public void finishBattle() {
        for (Hero h : heroes) {
            h.getEffectManager().getEffects().clear();

            for (Action a : h.getAzioni()) {
                if (a instanceof Ultimate ultimate) {
                    ultimate.resetCharge();
                }
            }
        }

        RewardManager.reward(heroes, enemies, floor);
    }

    public void nextFloor() {
        floor++;
    }

    public boolean isGameWon() {
        return floor > 10;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Battle getCurrentBattle() {
        return currentBattle;
    }

    public Shop getShop() {
        return shop;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}