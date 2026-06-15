package it.unicam.cs.mpgc.rpg129546.Combat.Selectors;

import it.unicam.cs.mpgc.rpg129546.Show.ShowAbility;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;
import java.util.Scanner;

public class AbilitySelector {
    Scanner sc = new Scanner(System.in);
    public int choice;
    ShowAbility abilityView = new ShowAbility();

    public Action selectorHero(Hero h){
        while(true){
            System.out.println("selezionare un abilità");
            abilityView.showAbility(h);
            choice = sc.nextInt();
            if(choice>=1 && choice <= h.getAzioni().size()){
                Action selected = h.getAzioni().get(choice-1);
                if(selected instanceof Ultimate){
                    if(!((Ultimate) selected).isReady()){
                        System.out.println("ancore non è il momento...");
                        continue;
                    }
                }
                if(h.getStatusManager().getAp() < selected.getCost()){
                    System.out.println("AP insufficienti");
                    continue;
                }
                return selected;
            }
            System.out.println("selezionare un azione disponibile");
        }
    }

    public Action selectorEnemy(Enemy e){
        Action selected = e.getAzioni().getFirst();
        for (int i = 0; i < e.getAzioni().size(); i++) {
            if (e.getStatusManager().getAp() >= e.getAzioni().get(i).getCost() && selected.getCost() < e.getAzioni().get(i).getCost()){
                selected = e.getAzioni().get(i);
            }
        }
        return selected;
    }
}
