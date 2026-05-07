package it.unicam.cs.mpgc.rpg129546.combat;
import it.unicam.cs.mpgc.rpg129546.model.Hero;
import it.unicam.cs.mpgc.rpg129546.model.Enemy;
import java.util.List;

public class Battle {
    private final List<Hero> eroi;
    private final List<Enemy> nemici;
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
        
        //*da implementare(sceglie cosa fare -> sceglie il terget -> viene applicato l'attacco -> vengono applicati gli effetti)
    }
    private void enemyTurn(){
        System.out.println("E' IL TURNO DEI NEMICI!!!");
        //*da implementare
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
