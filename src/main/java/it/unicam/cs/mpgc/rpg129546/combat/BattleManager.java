package it.unicam.cs.mpgc.rpg129546.combat;

import it.unicam.cs.mpgc.rpg129546.model.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Hero;

import java.util.List;

public class BattleManager {
    public void BattleStartConditions(List<Enemy>nemici, List<Hero>eroi){
        for (Enemy e : nemici){
            e.Heal(e.getMaxHp());
        }
        for (Hero h : eroi){
            h.Heal(h.getMaxHp());
        }
    }

    public void StartTurnRestore(List<Enemy>nemici, List<Hero>eroi){
        for (Enemy e : nemici) {
            if(e.isAlive()){
                e.restore(2);
            }
        }
        for (Hero h : eroi){
            if (h.isAlive()){
                h.restore(2);
            }
        }
    }
}
