package it.unicam.cs.mpgc.rpg129546.Show;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class ShowEffects {
    public void showEffects(Entity e){
        for (int i = 0; i < e.getEffectManager().getEffects().size(); i++) {
            System.out.println("[" +
                    e.getEffectManager().getEffects().get(i).getNome() +
                    "-" +
                    e.getEffectManager().getEffects().get(i).getTick() +
                    "/" +
                    e.getEffectManager().getEffects().get(i).getDuration() +
                    "]");
        }
    }
}
