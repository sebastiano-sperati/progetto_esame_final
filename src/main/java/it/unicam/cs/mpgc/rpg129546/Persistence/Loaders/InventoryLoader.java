package it.unicam.cs.mpgc.rpg129546.Persistence.Loaders;

import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.ItemSave;
import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.List;

/**
 * gestisce la logica con cui viene ricostruito l'inventario di un eroe, andando ad inserire all'interno della sua lista,
 * nuovi oggetti identici a quelli salvati, con la stessa quantità
 */
public class InventoryLoader {
    /**
     * per ogni eroe, controlla la lista di elementi salvati, per poi attingere al catalogo dello shop, contenente
     * una lista di tutti gli item presenti in game, per infine riaggiungerli al suo inventario
     * @param h eroe a cui aggiungere gli item
     * @param items lista di item salvati
     * @param shop negozio da cui prendere il catalogo
     */
    public static void load(Hero h, List<ItemSave> items, Shop shop){
        for(ItemSave save : items){

            for(GenericItem prototype : shop.getCatalogo()){

                if(prototype.getNome().equals(save.nome)){

                    Item item = (Item) prototype.getCopy();

                    h.getInventoryManager().addItem(item);

                    item.setQta(save.qta);

                }
            }
        }
    }
}
