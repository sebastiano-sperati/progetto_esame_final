package it.unicam.cs.mpgc.rpg129546.Combat;

import it.unicam.cs.mpgc.rpg129546.Combat.Selectors.AbilitySelector;
import it.unicam.cs.mpgc.rpg129546.Combat.Selectors.ActionSelector;
import it.unicam.cs.mpgc.rpg129546.Combat.Selectors.ItemSelector;
import it.unicam.cs.mpgc.rpg129546.Combat.Selectors.TargetSelector;
import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Show.ShowInventory;
import it.unicam.cs.mpgc.rpg129546.Show.ShowSquasStats;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Abilities.AbilityContext;

import java.util.List;

public class Battle {
    private final List<Hero> heroes;
    private final List<Enemy> enemies;
    private final AbilitySelector AbilitySelector = new AbilitySelector();
    private final TargetSelector TargetSelector = new TargetSelector();
    private final ActionSelector ActionSelector = new ActionSelector();
    private final ItemSelector ItemSelector = new ItemSelector();
    private final BattleManager BattleManager = new BattleManager();
    private final ShowSquasStats SquadStatsView = new ShowSquasStats();
    private final ShowInventory InventoryView = new ShowInventory();

    public Battle(List<Hero> heroes, List<Enemy> enemies){
        this.heroes = heroes;
        this.enemies = enemies;
    }

    public void Start(){
        System.out.println("INIZIA LA BATTAGLIA!!!");

        BattleManager.BattleStartConditions(heroes, enemies);

        while (heroseAlive() && enemyAlive()){

            BattleManager.ChargeUltimat(heroes);


            BattleManager.StartTurnRestore(enemies, heroes);

            heroTurn();

            if(enemyAlive()) enemyTurn();
        }
    }

    public boolean heroseAlive(){
        return heroes.stream().anyMatch(hero -> hero.getStatusManager().isAlive());
    }
    private boolean enemyAlive(){return enemies.stream().anyMatch(enemy -> enemy.getStatusManager().isAlive());}

    private void heroTurn(){
        System.out.println("E' IL TURNO DEGLI EROI !!!");

        for (int i = 0; i < heroes.size(); i++) {
            if (enemyAlive()) {
                if (heroes.get(i).getStatusManager().isAlive()) {
                    heroes.get(i).getEffectManager().tickAll(heroes.get(i));
                    System.out.println("TOCCA A " + heroes.get(i).getNome());
                    boolean endTurn = false;
                    while (!endTurn) {
                        CombatComand comand = ActionSelector.select();
                        switch (comand) {
                            case STATS -> {
                                SquadStatsView.showSquadStats(heroes);
                            }
                            case FIGHT -> {
                                Action selected = AbilitySelector.selectorHero(heroes.get(i));
                                Entity e = TargetSelector.SelectListAction(selected, heroes.get(i), heroes, enemies);
                                AbilityContext ctx = new AbilityContext(heroes, enemies);
                                if (selected instanceof SplashAbility) {
                                    ((SplashAbility) selected).executeSplash(heroes.get(i), e, ctx.getTargets(selected, heroes.get(i)));
                                } else {
                                    selected.execute(heroes.get(i), e);
                                }
                                endTurn = true;
                            }
                            case ITEM -> {
                                InventoryView.showInventory(heroes.get(i));
                                if (!heroes.get(i).getInventoryManager().getInventario().isEmpty()) {
                                    Item selected = ItemSelector.selector(heroes.get(i));
                                    Entity e = TargetSelector.SelectListItem(selected, heroes.get(i), heroes, enemies);
                                    heroes.get(i).getInventoryManager().useItem(heroes.get(i), e, selected);
                                    endTurn = true;
                                }
                            }
                        }
                    }
                }
                BattleManager.organizeEnemy(enemies);
            }
        }
    }
    private void enemyTurn(){
        System.out.println("E' IL TURNO DEI NEMICI!!!");

        for (int i = 0; i < enemies.size(); i++) {
            if (heroseAlive()) {
                if (enemies.get(i).getStatusManager().isAlive()) {
                    enemies.get(i).getEffectManager().tickAll(enemies.get(i));
                    System.out.println("TOCCA A " + enemies.get(i).getNome() + " ");
                    Action selected = AbilitySelector.selectorEnemy(enemies.get(i));
                    Entity e = TargetSelector.SelectListAction(selected, enemies.get(i), heroes, enemies);
                    AbilityContext ctx = new AbilityContext(heroes, enemies);
                    if (selected instanceof SplashAbility) {
                        ((SplashAbility) selected).executeSplash(enemies.get(i), e, ctx.getTargets(selected, enemies.get(i)));
                    } else {
                        selected.execute(enemies.get(i), e);
                    }
                }
                BattleManager.organizeEnemy(enemies);
            }
        }
    }


}
