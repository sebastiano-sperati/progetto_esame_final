package it.unicam.cs.mpgc.rpg129546.Show;

import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Ultimate;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

public class ShowAbility {
    public void showAbility(Entity e){

        for (int i = 0; i < e.getAzioni().size(); i++) {
            Action action = e.getAzioni().get(i);

            System.out.println((i + 1) + "-" + action.getName() + "(Costo : " + action.getCost() + " AP)");

            if(action instanceof Ultimate){
                System.out.println("Carica: " + ((Ultimate) action).getCharge() + "/" + ((Ultimate) action).getRequiredCharge());
            }
        }
    }
}
