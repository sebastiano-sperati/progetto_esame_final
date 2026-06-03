package it.unicam.cs.mpgc.rpg129546.Show;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.List;

public class ShowSquasStats {
    ShowEffects effectsView = new ShowEffects();
    public void showSquadStats(List<? extends Entity> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNome());
            System.out.print(": HP " + list.get(i).getStatusManager().getHp() + "/" + list.get(i).getStatusManager().getMaxHp() + " | ");
            System.out.println("AP " + list.get(i).getStatusManager().getAp() + "/" + list.get(i).getStatusManager().getMaxAp() );
            System.out.println("Atk: " + list.get(i).getEffectaApplier().modifyDmg(list.get(i)) + " | Dif: " + list.get(i).getEffectaApplier().modifyDif(list.get(i)));
            System.out.print("Prob crit: ");
            System.out.printf("%.2f",list.get(i).getEffectaApplier().modifyCC(list.get(i)));
            System.out.print(" Danno critico: " + list.get(i).getEffectaApplier().modifyCM(list.get(i)) + " Schivata: ");
            System.out.printf("%.2f",list.get(i).getEffectaApplier().modifyEva(list.get(i)));
            System.out.println();
            effectsView.showEffects(list.get(i));
            System.out.println();
        }
    }
}
