package it.unicam.cs.mpgc.rpg129546.combat;
import it.unicam.cs.mpgc.rpg129546.Items.Item;
import it.unicam.cs.mpgc.rpg129546.abilities.Action;
import it.unicam.cs.mpgc.rpg129546.model.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Hero;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TargetSelector {
    public Entity SelectListAction(Action action, Entity source, List<Hero> eroi, List<Enemy> nemici ){
        switch (action.getTargetType()){
            case ALLY ->{
                if(source instanceof Hero) {
                    return SelectTargetHero(eroi);
                }
                return SelectTargetEnemy(nemici);
            }
            case ENEMY -> {
                if(source instanceof Hero) {
                    return SelectTargetHero(nemici);
                }
                return SelectTargetEnemy(eroi);
            }
            case SELF -> {
                return source;
            }
            default -> throw new IllegalStateException("bersagio non valido");
        }

    }

    public Entity SelectListItem(Item i, Entity source, List<Hero> eroi, List<Enemy> nemici ){
        switch (i.getTipo()){
            case POTION -> {
                return source;
            }
            case THROWABLE -> {
                if(source instanceof Hero){
                    return SelectTargetHero(nemici);
                }
                return SelectTargetEnemy(eroi);

            }
            default -> throw new IllegalStateException("bersagio non valido");
        }
    }

    public Entity SelectTargetHero(List<? extends Entity> list){
        Scanner sc = new Scanner(System.in);
        while (true){
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + "-" + list.get(i).getNome() + list.get(i).getHp() + "/" + list.get(i).getMaxHp());
            }
            int choice = sc.nextInt();
            if(choice>=1 && choice<=list.size()){
                return list.get(choice-1);
            }
            System.out.println("Scelta non valida");
        }
    }

    public Entity SelectTargetEnemy(List<? extends Entity> list){
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

}
