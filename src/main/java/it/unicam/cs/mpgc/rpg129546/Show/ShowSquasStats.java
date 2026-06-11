package it.unicam.cs.mpgc.rpg129546.Show;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.List;

public class ShowSquasStats {
    ShowEffects effectsView = new ShowEffects();
    public void showSquadStats(List<? extends Entity> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNome() +  "Lvl: " + list.get(i).getStatusManager().getLvl());
            System.out.println("[" + list.get(i).getArma().getNome() + " - " + list.get(i).getArmatura().getNome() + "]");
            System.out.print(": HP " + list.get(i). getStatusManager().getHp()+ "/" + list.get(i).getStatsManager().getScaledMaxHP() + " | ");
            System.out.println("AP " + list.get(i).getStatusManager().getAp() + "/" + list.get(i).getStatsManager().getScaledMaxAp() );
            System.out.println("Atk: " + list.get(i).getEffectaApplier().modifyDmg(list.get(i)) + " | Dif: " + list.get(i).getEffectaApplier().modifyDif(list.get(i)));
            System.out.print("Prob crit: ");
            System.out.printf("%.2f",list.get(i).getEffectaApplier().modifyCC(list.get(i)));
            System.out.print(" Danno critico: ");
            System.out.printf("%.2f",list.get(i).getEffectaApplier().modifyCM(list.get(i)));
            System.out.println(" Schivata: ");
            System.out.printf("%.2f",list.get(i).getEffectaApplier().modifyEva(list.get(i)));
            System.out.println();
            effectsView.showEffects(list.get(i));
            System.out.println();
        }
    }
}
