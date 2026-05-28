package it.unicam.cs.mpgc.rpg129546.combat;

import it.unicam.cs.mpgc.rpg129546.Items.Item;
import it.unicam.cs.mpgc.rpg129546.model.Hero;

import java.util.Scanner;

public class ItemSelector {
    Scanner sc = new Scanner(System.in);
    public int choice;
    public Item selector(Hero h){
        while (true){
            System.out.println("selezionare un azione");
            h.getItemManager().showInventory();
            choice = sc.nextInt();
            if(choice>=1 && choice<= h.getItemManager().getInventario().size()){
                Item selected = h.getItemManager().getInventario().get(choice-1);
                return selected;
            }
            System.out.println("selezione non valida");
        }
    }
}
