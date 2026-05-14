package it.unicam.cs.mpgc.rpg129546.combat;

import java.util.Scanner;

public class actionSelector {
    private final Scanner sc = new Scanner(System.in);
    public CombatComand select(){
        while (true){
            System.out.println("1-combatti");
            System.out.println("2-mostra statistiche squadra");
            int choice = sc.nextInt();
            switch (choice){
                case 1 -> {
                    return CombatComand.FIGHT;
                }
                case 2->{
                    return CombatComand.STATS;
                }
                default -> System.out.println("scelta non valida");
            }
        }
    }
}
