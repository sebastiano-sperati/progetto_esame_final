package it.unicam.cs.mpgc.rpg129546.Items;

import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * implementa la logica per gestire l'inventario di ogni eroe, con la possibilità di aggiungere e usare oggetti
 */
public class InventoryManager {

    private List<Item> inventario = new ArrayList<>();

    /**
     * permette di aggiungere un oggetto, controllando se sono trasportabili altri oggetti dello stesso tipo,
     * ed incrementandone il numero se possibile
     * @param item oggetto da aggiungere
     */
    public void addItem(Item item){

        for(Item i : inventario){

            if(i.getClass() == item.getClass()){

                if(item.isFull()){
                    System.out.println("Non puoi portarne più di così");
                    return;
                }

                i.increaseCount();
                return;
            }
        }

        item.increaseCount();
        inventario.add(item);
    }

    /**
     * permette di utilizzare un oggetto su un' entità
     * @param source chi usa l'oggetto
     * @param target chi subisce gli effetti dell'oggetto
     * @param i l'oggetto utilizzato
     */
    public void useItem(Entity source, Entity target, Item i){
        i.use(source,target);
        i.decreaseCount();
        inventario.removeIf(Item::isEmpty);
    }

    public List<Item> getInventario(){
        return inventario;
    }
}
