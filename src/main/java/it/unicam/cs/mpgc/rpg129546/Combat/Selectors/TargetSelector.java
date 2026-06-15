package it.unicam.cs.mpgc.rpg129546.Combat.Selectors;
import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Abilities.Interface.Action;
import it.unicam.cs.mpgc.rpg129546.Model.Enemies.Enemy;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TargetSelector {
    public Entity SelectListAction(Action action, Entity source, List<Hero> heroes, List<Enemy> enemies){
        switch (action.getTargetType()){
            case ALLY ->{
                if(source instanceof Hero) {
                    return HeroSelectHero(heroes);
                }
                return SelectorEnemy(enemies);
            }
            case ENEMY -> {
                if(source instanceof Hero) {
                    return HeroSelectEnemy(enemies);
                }
                return SelectorEnemy(heroes);
            }
            case SELF -> {
                return source;
            }
            default -> throw new IllegalStateException("bersagio non valido");
        }

    }

    public Entity SelectListItem(Item i, Entity source, List<Hero> heroes, List<Enemy> enemies){
        switch (i.getTipo()){
            case POTION -> {
                return source;
            }
            case THROWABLE -> {
                if(source instanceof Hero){
                    return HeroSelectEnemy(enemies);
                }
                return SelectorEnemy(heroes);

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
                System.out.println((i+1) + "-" + list.get(i).getNome() + " " + list.get(i).getStatusManager().getHp() + "/" + list.get(i).getStatsManager().getScaledMaxHP());
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
                System.out.println((i+1) + "-" + list.get(i).getNome() + " " + list.get(i).getStatusManager().getHp() + "/" + list.get(i).getStatusManager().getMaxHp());
            }
            int choice = sc.nextInt();
            if(choice>=1 && choice<=list.size() && list.get(choice).getStatusManager().isAlive()){
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
