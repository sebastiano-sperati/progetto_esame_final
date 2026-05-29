package it.unicam.cs.mpgc.rpg129546.Items;

import it.unicam.cs.mpgc.rpg129546.Items.Oggetti.Item;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;
import java.util.List;

public class itemManager {
    private List<Item> inventario = new ArrayList<>();
    public void addItem(Item i){
        if(inventario.isEmpty()) {
            inventario.add(i);
            i.increaseCount();
        } else {
            for (Item item : inventario) {
                if (i.getClass() == item.getClass()) {
                    if (item.isFull()) {
                        System.out.println("non puoi portarne più di cosi");
                        return;
                    } else {
                        i.increaseCount();
                    }
                } else {
                    inventario.add(i);
                    i.increaseCount();
                }
            }
        }
    }

    public void showInventory(){
        if(inventario.isEmpty()){
            System.out.println("l'inventario e' vuoto");
            return;
        }
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("[" + (i+1)  + " - " + inventario.get(i).getNome() + "-" + inventario.get(i).getQta() + "/" + inventario.get(i).getMaxQta() + "]");
        }
    }

    public void useItem(Entity source, Entity target, Item i){
        i.use(source,target);
        i.decreaseCount();
        inventario.removeIf(Item::isEmpty);
    }

    public List<Item> getInventario(){
        return inventario;
    }
}
