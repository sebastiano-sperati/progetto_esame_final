package it.unicam.cs.mpgc.rpg129546.combat;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;

public class BattleManager {

    public void BattleStartConditions(List<Hero> eroi,List<Enemy> nemici){
        for (Hero hero : eroi) {

            int heal = hero.getStatsManager().getScaledMaxHP();
            int restore = hero.getStatsManager().getScaledMaxAp();

            hero.getStatusManager().Heal(heal);
            hero.getStatusManager().restore(restore);

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
}
