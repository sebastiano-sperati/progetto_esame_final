package it.unicam.cs.mpgc.rpg129546.Combat;

import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.List;

public class BattleManager {

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
    public void ChargeUltimat(List<Hero> eroi){
        for(Hero h : eroi) {
            for (int i = 0; i < h.getAzioni().size(); i++) {
                if (h.getAzioni().get(i) instanceof Ultimate) ((Ultimate) h.getAzioni().get(i)).increaseCharge();
            }
        }
    }

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
