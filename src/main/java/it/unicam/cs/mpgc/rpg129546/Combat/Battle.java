package it.unicam.cs.mpgc.rpg129546.Combat;

import it.unicam.cs.mpgc.rpg129546.Abilities.AbilityContext;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.Combat.Selectors.AbilitySelector;
import it.unicam.cs.mpgc.rpg129546.Combat.Selectors.TargetSelector;
import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.List;

/**
 * gestisce una singola battaglia tra la squadra di eroi e un gruppo di nemici.
 *
 * la classe contiene tutta la logica del combattimento:
 * - gestione dei turni;
 * - esecuzione delle azioni;
 * - controllo della vittoria e della sconfitta;
 * - utilizzo degli oggetti;
 * - avanzamento del round.
 */
public class Battle {

    private final List<Hero> heroes;
    private final List<Enemy> enemies;
    private final BattleManager battleManager = new BattleManager();

    private int currentHeroIndex = 0;

    public Battle(List<Hero> heroes, List<Enemy> enemies) {
        this.heroes = heroes;
        this.enemies = enemies;
    }

    public void startBattle() {
        battleManager.BattleStartConditions(heroes, enemies);
        startNewRound();
    }

    public void startNewRound() {
        currentHeroIndex = 0;
        battleManager.ChargeUltimat(heroes);
        battleManager.StartTurnRestore(enemies, heroes);
    }

    public Hero getCurrentHero() {
        while (currentHeroIndex < heroes.size()) {
            Hero hero = heroes.get(currentHeroIndex);

            if (hero.getStatusManager().isAlive()) {
                return hero;
            }

            currentHeroIndex++;
        }

        return null;
    }

    /**
     * contiene la logica per far eseguire ad un eroe una singola azione
     * @param action azione selezionata
     * @param target entità che subirà l'azione
     */

    public void executeHeroAction(Action action, Entity target) {
        Hero hero = getCurrentHero();

        if (hero == null || action == null || target == null) {
            return;
        }

        hero.getEffectManager().tickAll(hero);

        AbilityContext ctx = new AbilityContext(heroes, enemies);

        if (action instanceof SplashAbility splash) {
            splash.executeSplash(hero, target, ctx.getTargets(action, hero));
        } else {
            action.execute(hero, target);
        }

        battleManager.organizeEnemy(enemies);
        currentHeroIndex++;
    }

    /**
     * contiene la logica per far utilizzare un singolo oggetto a un eroe
     * @param item oggetto utilizzato
     * @param target entità che subira gli effetti dell'oggetto
     */

    public void useItem(Item item, Entity target) {
        Hero hero = getCurrentHero();

        if (hero == null || item == null || target == null) {
            return;
        }

        hero.getInventoryManager().useItem(hero, target, item);
        battleManager.organizeEnemy(enemies);
        currentHeroIndex++;
    }

    /**
     * contiene la logica per far si che un nemico effettui una singola azione
     * Ogni nemico vivo seleziona automaticamente un'azione e un bersaglio.
     */
    public void executeEnemyTurn() {
        for (Enemy enemy : enemies) {
            if (!enemy.getStatusManager().isAlive()) {
                continue;
            }

            if (!heroesAlive()) {
                return;
            }

            enemy.getEffectManager().tickAll(enemy);

            Action selected = AbilitySelector.selectorEnemy(enemy);
            Entity target = TargetSelector.SelectListAction(selected,enemy,heroes,enemies);

            AbilityContext ctx = new AbilityContext(heroes, enemies);

            if (selected instanceof SplashAbility splash) {
                splash.executeSplash(enemy, target, ctx.getTargets(selected, enemy));
            } else {
                selected.execute(enemy, target);
            }

            battleManager.organizeEnemy(enemies);
        }
    }

    /**
     * controlla se il turno degli eroi è finito
     * @return true se tutti gli eroi hanno giocato, false altrimenti
     */
    public boolean allHeroesPlayed() {
        return currentHeroIndex >= heroes.size();
    }

    /**
     * controlli per vedere se una delle due squadre ha vinto
     * @return true se ci sono entità vive, false altrimenti
     */
    public boolean heroesAlive() {
        return heroes.stream().anyMatch(h -> h.getStatusManager().isAlive());
    }
    public boolean enemiesAlive() {
        return enemies.stream().anyMatch(e -> e.getStatusManager().isAlive());
    }

    public boolean isFinished() {
        return !heroesAlive() || !enemiesAlive();
    }

    public boolean heroesWon() {
        return heroesAlive() && !enemiesAlive();
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}