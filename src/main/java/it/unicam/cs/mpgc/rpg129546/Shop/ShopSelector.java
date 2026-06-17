package it.unicam.cs.mpgc.rpg129546.Shop;

import java.util.Scanner;

public class ShopSelector {
    private final Scanner sc= new Scanner(System.in);

    public ShopComand select(){
        while(true) {
            System.out.println("1-compra");
            System.out.println("2-vendi");
            System.out.println("3-esci");

            int choice = sc.nextInt();

            if(choice>0 && choice < 4) {
                return switch (choice) {
                    case 1 -> ShopComand.BUY;
                    case 2 -> ShopComand.SELL;
                    case 3 -> ShopComand.EXIT;
                    default -> throw new IllegalStateException();
                };
            } else {
                System.out.println("selezione non valida");
            }
        }
    }

}
