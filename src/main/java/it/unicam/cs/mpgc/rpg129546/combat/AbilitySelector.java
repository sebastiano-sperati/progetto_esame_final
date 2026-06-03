package it.unicam.cs.mpgc.rpg129546.combat;

import it.unicam.cs.mpgc.rpg129546.Show.ShowAbility;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Action;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;
import java.util.Scanner;

public class AbilitySelector {
    Scanner sc = new Scanner(System.in);
    public int choice;
    ShowAbility abilityView = new ShowAbility();
    //selector per il giocatore
    public Action selectorHero(Hero h){
        while(true){
            System.out.println("selezionare un abilità");
            abilityView.showAbility(h);
            choice = sc.nextInt();
            if(choice>=1 && choice <= h.getAzioni().size()){
                Action selected = h.getAzioni().get(choice-1);
                if(h.getStatusManager().getAp() < selected.getCosto()){
                    System.out.println("AP insufficienti");
                    continue;
                }
                return selected;
            }
            System.out.println("selezionare un azione disponibile");
        }
    }
    //selector per l'ai (sceglie sempre l'azione più costosa disponibile
    public Action selectorEnemy(Enemy e){
        Action selected = null;
        for (int i = 0; i < e.getAzioni().size(); i++) {
            if (e.getStatusManager().getAp() >= e.getAzioni().get(i).getCosto()){
                selected = e.getAzioni().get(i);
            }
        }
        return selected;
    }
}
