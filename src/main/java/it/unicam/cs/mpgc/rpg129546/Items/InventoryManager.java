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
    public void showInventory(){
        if(inventario.isEmpty()){
            System.out.println("l'inventario e' vuoto");
            return;
        }
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("[" + (i+1)  + " - " + inventario.get(i).getNome() + "-" + inventario.get(i).getQta() + "/" + inventario.get(i).getMaxQta() + " - " + inventario.get(i).getPrezzo() + "$ ]");
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
