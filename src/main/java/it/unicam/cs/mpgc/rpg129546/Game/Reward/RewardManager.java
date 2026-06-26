package it.unicam.cs.mpgc.rpg129546.Game.Reward;

import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;

import java.util.List;

/**
 * gestisce i metodi di calcolo dei reward guadagnati, e l'assegnazione
 */
public class RewardManager {
    /**
     * calcola, in base alla lista di nemici, quanti xp e quanto oro ha guadagnato il party, per poi dare ad ognuno il reward
     * @param eroi guadagnano il reward
     * @param nemici definiscono il valore del reward
     * @return un reward data, da comunicare all'interfaccia
     */
    public static RewardData reward(List<Hero>eroi, List<Enemy>nemici){
        int xp = caclulatexp(nemici);
        int gold = calculateGold(nemici);

        for(Hero h:eroi){
            h.getHeroStatusManager().addGold(gold);
            h.getHeroStatusManager().addXp(xp);
        }
        return new RewardData(xp,gold);
    }

    /**
     * calcola in base ai nemici quanta esperienza è stata guadagnata
     * @param list lista di nemici sconfitti
     * @return quantita di xp
     */

    private static int caclulatexp(List<Enemy> list){
        int xp = 0;
        for(Enemy e : list){
            xp += e.getScaledXpDrop();
        }
        return xp;
    }

    /**
     * calcola in base ai nemici, quanto oro è stato guadagnato
     * @param list lista di nemici sconfitti
     * @return quantità di oro
     */
    private static int calculateGold(List<Enemy>list){
        int gold = 0;
        for(Enemy e : list){
            gold += e.getScaledTaglia();
        }
        return gold;
    }

}

