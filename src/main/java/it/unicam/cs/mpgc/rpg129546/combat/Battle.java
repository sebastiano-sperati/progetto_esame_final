package it.unicam.cs.mpgc.rpg129546.combat;
import it.unicam.cs.mpgc.rpg129546.Items.Item;
import it.unicam.cs.mpgc.rpg129546.Items.ItemType;
import it.unicam.cs.mpgc.rpg129546.abilities.Action;
import it.unicam.cs.mpgc.rpg129546.abilities.SplashAbility;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Hero;
import it.unicam.cs.mpgc.rpg129546.model.Enemy;
import it.unicam.cs.mpgc.rpg129546.abilities.abilityContext;

import java.util.List;

public class Battle {
    private final List<Hero> eroi;
    private final List<Enemy> nemici;
    private final AbilitySelector Aselector = new AbilitySelector();
    private final TargetSelector Tselector = new TargetSelector();
    private final actionSelector actionSelector = new actionSelector();
    private final ItemSelector itemSelector = new ItemSelector();
    private final BattleManager battleManager = new BattleManager();
    public Battle(List<Hero> eroi, List<Enemy> nemici){
        this.eroi = eroi;
        this.nemici = nemici;
    }

    public void Start(){
        System.out.println("INIZIA LA BATTAGLIA!!!");
        battleManager.BattleStartConditions(nemici,eroi);
        while (heroseAlive() && enemyAlive()){
            battleManager.StartTurnRestore(nemici,eroi);
            heroTurn();
            enemyTurn();
        }
        End();
    }
    //* metodi per controllare che sia in vita almeno un eroe o un nemico
    private boolean heroseAlive(){
        return eroi.stream().anyMatch(Hero :: isAlive);
    }
    private boolean enemyAlive(){
        return nemici.stream().anyMatch(Enemy :: isAlive);
    }
    //*gestione dei turni
    private void heroTurn(){
        System.out.println("E' IL TURNO DEGLI EROI !!!");

        for (int i = 0; i < eroi.size(); i++) {
            if(eroi.get(i).isAlive()){
                eroi.get(i).getManager().tickAll(eroi.get(i));
                System.out.println("TOCCA A " + eroi.get(i).getNome());
                boolean endTurn = false;
                while (!endTurn) {
                    CombatComand comand = actionSelector.select();
                    switch (comand) {
                        case STATS ->{
                            eroi.get(i).showSquadStats(eroi);
                        }
                        case FIGHT -> {
                            Action selected = Aselector.selectorHero((eroi.get(i)));
                            Entity e = Tselector.SelectList(selected, eroi.get(i), eroi, nemici);
                            abilityContext ctx = new abilityContext(eroi, nemici);
                            if (selected instanceof SplashAbility) {
                                ((SplashAbility) selected).executeSplash(eroi.get(i), e,  ctx.getTargets(selected, eroi.get(i)));
                            } else {
                                selected.execute(eroi.get(i), e);
                                System.out.println("fatto");
                            }
                            endTurn = true;
                        }
                        case ITEM -> {
                            Item selected = itemSelector.selector(eroi.get(i));
                            if(selected.getTipo() == ItemType.POTION){
                                selected.use(eroi.get(i),eroi.get(i));
                            } else {
                                Entity e = Tselector.SelectList(selected, eroi.get(i), eroi, nemici);

                            }
                        }
                    }
                }
            }
            removeDed();
        }
    }
    private void enemyTurn(){
        System.out.println("E' IL TURNO DEI NEMICI!!!");

        for (int i = 0; i < nemici.size(); i++) {
            if(nemici.get(i).isAlive()){
                nemici.get(i).getManager().tickAll(nemici.get(i));
                System.out.println("TOCCA A " + nemici.get(i).getNome() + " ");
                Action selected = Aselector.selectorEnemy(nemici.get(i));
                Entity e = Tselector.SelectList(selected,nemici.get(i),eroi,nemici);
                abilityContext ctx = new abilityContext(eroi,nemici);
                if(selected instanceof  SplashAbility){
                    ((SplashAbility)selected).executeSplash(nemici.get(i), e , ctx.getTargets(selected, nemici.get(i)));
                }else {
                    selected.execute(nemici.get(i), e);
                }
            }
            removeDed();
        }
    }
    private void removeDed(){
        nemici.removeIf(n -> !n.isAlive());
        eroi.removeIf(e -> !e.isAlive());
    }
    private void End(){
        if(heroseAlive()){
            System.out.println("VITTORIA !!!");
        } else {
            System.out.println("sconfitta...");
        }
    }
}
