package it.unicam.cs.mpgc.rpg129546.combat;
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
    public Battle(List<Hero> eroi, List<Enemy> nemici){
        this.eroi = eroi;
        this.nemici = nemici;
    }

    public void Start(){
        System.out.println("INIZIA LA BATTAGLIA!!!");

        while (heroseAlive() && enemyAlive()){
            heroTurn();
            enemyTurn();

            removeDed();
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
                Action selected = Aselector.selectorHero((eroi.get(i)));
                Entity e = Tselector.SelectList(selected,eroi.get(i),eroi,nemici);
                abilityContext ctx = new abilityContext(eroi, nemici);
                if(selected instanceof SplashAbility){
                    ((SplashAbility) selected).executeSplash(eroi.get(i), e , (abilityContext) ctx.getTargets(selected,eroi.get(i)));
                } else{
                    selected.execute(eroi.get(i),e);
                }
            }
        }
    }
    private void enemyTurn(){
        System.out.println("E' IL TURNO DEI NEMICI!!!");
        for (int i = 0; i < nemici.size(); i++) {
            if(nemici.get(i).isAlive()){
                Action selected = Aselector.selectorEnemy(nemici.get(i));
                Entity e = Tselector.SelectList(selected,nemici.get(i),eroi,nemici);
                abilityContext ctx = new abilityContext(eroi,nemici);
                if(selected instanceof  SplashAbility){
                    ((SplashAbility)selected).executeSplash(nemici.get(i), e ,(abilityContext) ctx.getTargets(selected, nemici.get(i)));
                }
            }
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
