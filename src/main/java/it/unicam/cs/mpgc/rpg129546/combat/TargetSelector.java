package it.unicam.cs.mpgc.rpg129546.combat;
import it.unicam.cs.mpgc.rpg129546.abilities.Action;
import it.unicam.cs.mpgc.rpg129546.model.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Hero;

import java.util.List;
import java.util.Scanner;

public class TargetSelector {
    public Entity SelectList(Action action, Entity source, List<Hero> eroi, List<Enemy> nemici ){
        switch (action.getTargetType()){
            case ALLY ->{
                return SelectTarget(eroi);
            }
            case ENEMY -> {
                return SelectTarget(nemici);
            }
            case SELF -> {
                return source;
            }
            default -> throw new IllegalStateException("bersagio non valido");
        }

    }
    public Entity SelectTarget(List<? extends Entity> list){
        Scanner sc = new Scanner(System.in);
        while (true){
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + "-" + list.get(i).getNome());
                int choice = sc.nextInt();
                if(choice>=1 && choice<=list.size()){
                    return list.get(choice-1);
                }
                System.out.println("Scelta non valida");
            }
        }
    }

}
