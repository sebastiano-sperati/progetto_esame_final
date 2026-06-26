package it.unicam.cs.mpgc.rpg129546.Game;

import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Combat.Battle;
import it.unicam.cs.mpgc.rpg129546.Game.Factory.EnemyFactory;
import it.unicam.cs.mpgc.rpg129546.Game.Reward.RewardData;
import it.unicam.cs.mpgc.rpg129546.Game.Reward.RewardManager;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveData;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveManager;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.GenericSaver;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta una partita completa del gioco.
 *
 * La classe coordina i principali componenti del modello,
 * gestendo il ciclo di gioco, l'avanzamento dei piani,
 * le battaglie, il negozio, le ricompense e la persistenza.
 *
 * Game funge da punto di accesso principale al modello
 * per i controller dell'interfaccia grafica.
 */
public class Game {

    private final List<Hero> heroes;
    private List<Enemy> enemies;
    private Battle currentBattle;
    private final Shop shop;
    private RewardData lastReward;

    private int floor;

    public Game(List<Hero> heroes) {
        this.heroes = heroes;
        this.shop = new Shop();
        this.floor = 1;
    }

    /**
     * fa iniziare una nuova battaglia, generando randomicamente dei nemici
     */
    public void startNewBattle() {
        enemies = EnemyFactory.generate(floor);
        currentBattle = new Battle(heroes, enemies);
        currentBattle.startBattle();
    }

    /**
     * a fine battaglia, rimuove tutti gli effetti sugli eroi, e resetta le Ultimate Ability, dando in fine il reward
     */
    public void finishBattle() {
        for (Hero h : heroes) {
            h.getEffectManager().getEffects().clear();

            for (Action a : h.getAzioni()) {
                if (a instanceof Ultimate ultimate) {
                    ultimate.resetCharge();
                }
            }
        }
        lastReward = RewardManager.reward(heroes,enemies);
    }

    public RewardData getLastReward(){return lastReward;}

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

    public void setFloor(int floor) {
        this.floor = floor;
    }
    /**
     * Salva lo stato corrente della partita.
     *
     * Gli oggetti del modello vengono convertiti nelle rispettive
     * strutture di persistenza e successivamente serializzati
     * tramite il SaveManager.
     */
    public void saveGame() {

        try {

            GenericSaver saver = new GenericSaver();

            List<HeroSave> heroSaves = new ArrayList<>();

            for (Hero hero : heroes) {

                HeroSave heroSave = new HeroSave();

                saver.GenericSaver(heroSave, hero);

                heroSaves.add(heroSave);
            }

            SaveData data = new SaveData(heroSaves, floor);

            SaveManager.save(data);

            System.out.println("Partita salvata!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}