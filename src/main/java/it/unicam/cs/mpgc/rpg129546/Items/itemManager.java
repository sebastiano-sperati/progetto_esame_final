package it.unicam.cs.mpgc.rpg129546.Items;

import java.util.ArrayList;
import java.util.List;

public class itemManager {
    private List<Item> inventario = new ArrayList<>();
    public void addItem(Item i){
        for(Item item : inventario){
            if (i.getClass() == item.getClass()){
                if(item.isFull()){
                    System.out.println("non puoi portarne più di cosi");
                } else {
                    i.increaseCount();
                }
            } else {
                inventario.add(i);
                i.increaseCount();
            }
        }
    }

    public void showInventory(){
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("[" + (i+1)  + " - " + inventario.get(i).getNome() + "-" + inventario.get(i).getQta() + "/" + inventario.get(i).getMaxQta() + "]");
        }
    }

    public void itemUsed(Item i){
        i.decreaseCount();
        inventario.removeIf(Item::isEmpty);
    }

    public List<Item> getInventario(){
        return inventario;
    }
}
