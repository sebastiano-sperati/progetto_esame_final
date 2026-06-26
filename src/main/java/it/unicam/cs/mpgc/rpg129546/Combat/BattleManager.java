package it.unicam.cs.mpgc.rpg129546.Combat;

import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.List;

/**
 * contiene la logica per gestire gli eventi che avvengono in automatico dopo ogni turno o round
 */
public class BattleManager {
    /**
     * assicura che ogni eroe e ogni nemico inizi una battaglia con il pieno della vita e della stamina
     * @param eroi lista della squadra di eroi
     * @param nemici lista del gruppo di nemici
     */
    public void BattleStartConditions(List<Hero> eroi,List<Enemy> nemici){
        for (Hero hero : eroi) {

            int heal = hero.getStatsManager().getScaledMaxHP();
            int restore = hero.getStatsManager().getScaledMaxAp();

            hero.getStatusManager().Heal(heal);
            hero.getStatusManager().restore(restore);

            hero.getHeroStatusManager().setAlive(true);

        }
        for(Enemy enemy : nemici){
            int heal = enemy.getStatsManager().getScaledMaxHP();
            int restore = enemy.getStatsManager().getScaledMaxAp();

            enemy.getStatusManager().Heal(heal);
            enemy.getStatusManager().restore(restore);
        }
    }

    /**
     * si assicura che all'inizio di ogni round ogni entità ancora viva possa rigenerare la propria stamina di una quantità predefinita
     * @param eroi lista della squadra di eroi
     * @param nemici lista del gruppo di nemici
     */
    public void StartTurnRestore(List<Enemy>nemici, List<Hero>eroi){
        for (Hero h : eroi){
            if (h.getStatusManager().isAlive()){
                h.getStatusManager().restore(2);
            }
        }

        for (Enemy e : nemici) {
            if(e.getStatusManager().isAlive()){
                e.getStatusManager().restore(2);
            }
        }
    }

    /**
     * permette a tutti gli eroi che hanno sbloccato una Ultimate Ability di caricare dopo ogni turno la propria abilità
     * @param eroi squadra di eroi corrente
     */
    public void ChargeUltimat(List<Hero> eroi){
        for(Hero h : eroi) {
            if(h.getHeroStatusManager().isAlive()) {
                for (int i = 0; i < h.getAzioni().size(); i++) {
                    if (h.getAzioni().get(i) instanceof Ultimate) ((Ultimate) h.getAzioni().get(i)).increaseCharge();
                }
            }
        }
    }

    /**
     * permette di riorganizzare automaticamente il gruppo di nemici, mettendo tutti quelli vivi in cima, e tutti quelli morti in fondo,
     * cosi da impedire al giocatore di bersagliare nemici morti, e allo stesso tempo mantenere la lista piena par calcolare a fine battaglia i reward
     * @param enemies gruppo di nemici
     */
    public void organizeEnemy(List<Enemy> enemies){
        for (int i = 0; i < enemies.size()-1; i++) {
            if(!enemies.get(i).getStatusManager().isAlive()) {
                for (int j = i + 1; j < enemies.size(); j++) {
                    if(enemies.get(j).getStatusManager().isAlive()){
                        Enemy temp = enemies.get(i);
                        enemies.set(i, enemies.get(j));
                        enemies.set(j,temp);
                    }
                }
            }
        }
    }
}
