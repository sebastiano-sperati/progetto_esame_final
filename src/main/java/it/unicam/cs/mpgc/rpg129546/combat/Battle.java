package it.unicam.cs.mpgc.rpg129546.combat;

import it.unicam.cs.mpgc.rpg129546.Items.Consumabili.Item;
import it.unicam.cs.mpgc.rpg129546.Show.ShowInventory;
import it.unicam.cs.mpgc.rpg129546.Show.ShowSquasStats;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Action;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.abilities.AbilityContext;
import it.unicam.cs.mpgc.rpg129546.Shop.ShopSelector;

import java.util.List;

public class Battle {
    private final List<Hero> eroi;
    private final List<Enemy> nemici;
    private final AbilitySelector Aselector = new AbilitySelector();
    private final TargetSelector Tselector = new TargetSelector();
    private final ActionSelector actionSelector = new ActionSelector();
    private final ItemSelector itemSelector = new ItemSelector();
    private final BattleManager battleManager = new BattleManager();
    private final ShowSquasStats squadStatsView = new ShowSquasStats();
    private final ShowInventory inventoryView = new ShowInventory();

    public Battle(List<Hero> eroi, List<Enemy> nemici){
        this.eroi = eroi;
        this.nemici = nemici;
    }

    public void Start(){
        System.out.println("INIZIA LA BATTAGLIA!!!");

        battleManager.BattleStartConditions(eroi);

        while (heroseAlive() && enemyAlive()){

            battleManager.StartTurnRestore(nemici,eroi);

            heroTurn();

            if(enemyAlive()) enemyTurn();
        }
    }

    //* metodi per controllare che sia in vita almeno un eroe o un nemico
    public boolean heroseAlive(){
        return eroi.stream().anyMatch(hero -> hero.getStatusManager().isAlive());
    }
    private boolean enemyAlive(){return nemici.stream().anyMatch(enemy -> enemy.getStatusManager().isAlive());}

    //*gestione dei turni
    private void heroTurn(){
        System.out.println("E' IL TURNO DEGLI EROI !!!");

        for (int i = 0; i < eroi.size(); i++) {
            if (enemyAlive()) {
                if (eroi.get(i).getStatusManager().isAlive()) {
                    eroi.get(i).getEffectManager().tickAll(eroi.get(i));
                    System.out.println("TOCCA A " + eroi.get(i).getNome());
                    boolean endTurn = false;
                    while (!endTurn) {
                        CombatComand comand = actionSelector.select();
                        switch (comand) {
                            case STATS -> {
                                squadStatsView.showSquadStats(eroi);
                            }
                            case FIGHT -> {
                                Action selected = Aselector.selectorHero((eroi.get(i)));
                                Entity e = Tselector.SelectListAction(selected, eroi.get(i), eroi, nemici);
                                AbilityContext ctx = new AbilityContext(eroi, nemici);
                                if (selected instanceof SplashAbility) {
                                    ((SplashAbility) selected).executeSplash(eroi.get(i), e, ctx.getTargets(selected, eroi.get(i)));
                                } else {
                                    selected.execute(eroi.get(i), e);
                                }
                                endTurn = true;
                            }
                            case ITEM -> {
                                inventoryView.showInventory(eroi.get(i));
                                if (!eroi.get(i).getInventoryManager().getInventario().isEmpty()) {
                                    Item selected = itemSelector.selector(eroi.get(i));
                                    Entity e = Tselector.SelectListItem(selected, eroi.get(i), eroi, nemici);
                                    eroi.get(i).getInventoryManager().useItem(eroi.get(i), e, selected);
                                    endTurn = true;
                                }
                            }
                        }
                    }
                }
                organizeEnemy();
            }
        }
    }
    private void enemyTurn(){
        System.out.println("E' IL TURNO DEI NEMICI!!!");

        for (int i = 0; i < nemici.size(); i++) {
            if (heroseAlive()) {
                if (nemici.get(i).getStatusManager().isAlive()) {
                    nemici.get(i).getEffectManager().tickAll(nemici.get(i));
                    System.out.println("TOCCA A " + nemici.get(i).getNome() + " ");
                    Action selected = Aselector.selectorEnemy(nemici.get(i));
                    Entity e = Tselector.SelectListAction(selected, nemici.get(i), eroi, nemici);
                    AbilityContext ctx = new AbilityContext(eroi, nemici);
                    if (selected instanceof SplashAbility) {
                        ((SplashAbility) selected).executeSplash(nemici.get(i), e, ctx.getTargets(selected, nemici.get(i)));
                    } else {
                        selected.execute(nemici.get(i), e);
                    }
                }
                organizeEnemy();
            }
        }
    }

    private void organizeEnemy(){
        for (int i = 0; i < nemici.size()-1; i++) {
            if(!nemici.get(i).getStatusManager().isAlive()) {
                for (int j = i + 1; j < nemici.size(); j++) {
                    if(nemici.get(j).getStatusManager().isAlive()){
                        Enemy temp = nemici.get(i);
                        nemici.set(i,nemici.get(j));
                        nemici.set(j,temp);
                    }
                }
            }
        }
    }
}
