package it.unicam.cs.mpgc.rpg129546.Persistence.Loaders;

import it.unicam.cs.mpgc.rpg129546.Items.Consumabili.Item;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.ItemSave;
import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.List;

public class InventoryLoader {
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
