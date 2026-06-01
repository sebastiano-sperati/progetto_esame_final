package it.unicam.cs.mpgc.rpg129546.combat;

import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;

public class BattleManager {
    public void BattleStartConditions(List<Enemy>nemici, List<Hero>eroi){
        for (Hero h : eroi){
            h.Heal(h.getMaxHp());
        }

        for (Enemy e : nemici){
            e.Heal(e.getMaxHp());
        }

    }

    public void StartTurnRestore(List<Enemy>nemici, List<Hero>eroi){
        for (Hero h : eroi){
            if (h.isAlive()){
                h.restore(2);
            }
        }

        for (Enemy e : nemici) {
            if(e.isAlive()){
                e.restore(2);
            }
        }

    }

    public int goldReward(List<Enemy>list){
        int reward = 0;
        for (int i = 0; i < list.size(); i++) {
            reward += list.get(i).getScaledTaglia();
        }
        return reward;
    }

    public int xpReward(List<Enemy>list){
        int reward = 0;
        for (int i = 0; i < list.size(); i++) {
            reward += list.get(i).getScaledXpDrop();
        }
        return reward;
    }
}
