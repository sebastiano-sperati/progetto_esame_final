package it.unicam.cs.mpgc.rpg129546.Combat.Selectors;

import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.Scanner;

public class ItemSelector {
    Scanner sc = new Scanner(System.in);
    public int choice;
    public Item selector(Hero h){
        while (true){
            System.out.println("selezionare un azione");
            choice = sc.nextInt();
            if(choice>=1 && choice<= h.getInventoryManager().getInventario().size()){
                return h.getInventoryManager().getInventario().get(choice-1);
            }
            System.out.println("selezione non valida");
        }
    }
}
