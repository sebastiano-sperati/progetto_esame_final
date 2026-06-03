package it.unicam.cs.mpgc.rpg129546.Items;

import it.unicam.cs.mpgc.rpg129546.Items.Consumabili.Item;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private List<Item> inventario = new ArrayList<>();

    public void addItem(Item item){

        for(Item i : inventario){

            if(i.getClass() == item.getClass()){

                if(item.isFull()){
                    System.out.println("Non puoi portarne più di così");
                    return;
                }

                item.increaseCount();
                return;
            }
        }

        item.increaseCount();
        inventario.add(item);
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
