package it.unicam.cs.mpgc.rpg129546.combat;
import it.unicam.cs.mpgc.rpg129546.Items.Consumabili.Item;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.model.Nemici.Enemy;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TargetSelector {
    public Entity SelectListAction(Action action, Entity source, List<Hero> eroi, List<Enemy> nemici ){
        switch (action.getTargetType()){
            case ALLY ->{
                if(source instanceof Hero) {
                    return HeroSelectHero(eroi);
                }
                return SelectorEnemy(nemici);
            }
            case ENEMY -> {
                if(source instanceof Hero) {
                    return HeroSelectEnemy(nemici);
                }
                return SelectorEnemy(eroi);
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
                    return HeroSelectEnemy(nemici);
                }
                return SelectorEnemy(eroi);

            }
            default -> throw new IllegalStateException("bersagio non valido");
        }
    }

    public Entity HeroSelectEnemy(List<? extends Entity> list){
        Scanner sc = new Scanner(System.in);
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getStatusManager().isAlive()) index++;
        }
        while (true){
            for (int i = 0; i < index; i++) {
                System.out.println((i+1) + "-" + list.get(i).getNome() + list.get(i).getStatusManager().getHp() + "/" + list.get(i).getStatsManager().getScaledMaxHP());
            }
            int choice = sc.nextInt();
            if(choice>=1 && choice<=index){
                return list.get(choice-1);
            }
            System.out.println("Scelta non valida");
        }
    }


    public Entity HeroSelectHero(List<? extends Entity> list) {
        Scanner sc = new Scanner(System.in);
        while (true){
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1) + "-" + list.get(i).getNome() + list.get(i).getStatusManager().getHp() + "/" + list.get(i).getStatusManager().getMaxHp());
            }
            int choice = sc.nextInt();
            if(choice>=1 && choice<=list.size()){
                return list.get(choice-1);
            }
            System.out.println("Scelta non valida");
        }
   }


    public Entity SelectorEnemy(List<? extends Entity> list){
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

}
