package it.unicam.cs.mpgc.rpg129546.combat;

import java.util.Scanner;

public class ActionSelector {
    private final Scanner sc = new Scanner(System.in);
    public CombatComand select(){
        while (true){
            System.out.println("1-combatti");
            System.out.println("2-mostra statistiche squadra");
            System.out.println("3-mostra oggetti");
            int choice = sc.nextInt();
            switch (choice){
                case 1 -> {
                    return CombatComand.FIGHT;
                }
                case 2->{
                    return CombatComand.STATS;
                }
                case 3->{
                    return CombatComand.ITEM;
                }
                default -> System.out.println("scelta non valida");
            }
        }
    }
}
