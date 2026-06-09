package it.unicam.cs.mpgc.rpg129546.combat;

import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;

public class BattleManager {

    public void BattleStartConditions(List<Hero> eroi){
        for (Hero hero : eroi) {
            hero.getHeroStatusManager().Heal(hero.getStatsManager().getScaledMaxHP());
            hero.getHeroStatusManager().restore(hero.getStatsManager().getScaledMaxAp());
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
}
