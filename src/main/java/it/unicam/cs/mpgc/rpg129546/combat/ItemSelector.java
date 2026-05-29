package it.unicam.cs.mpgc.rpg129546.combat;

import it.unicam.cs.mpgc.rpg129546.Items.Oggetti.Item;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.Scanner;

public class ItemSelector {
    Scanner sc = new Scanner(System.in);
    public int choice;
    public Item selector(Hero h){
        while (true){
            System.out.println("selezionare un azione");
            choice = sc.nextInt();
            if(choice>=1 && choice<= h.getItemManager().getInventario().size()){
                return h.getItemManager().getInventario().get(choice-1);
            }
            System.out.println("selezione non valida");
        }
    }
}
