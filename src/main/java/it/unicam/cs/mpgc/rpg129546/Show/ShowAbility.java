package it.unicam.cs.mpgc.rpg129546.Show;

import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Action;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class ShowAbility {
    public void showAbility(Entity e){
        for (int i = 0; i < e.getAzioni().size(); i++) {
            Action action = e.getAzioni().get(i);

            System.out.println((i+1) +
                    "-" +
                    action.getNome() +
                    "(Costo : " +
                    action.getCosto() +
                    " AP)");

        }
    }
}
