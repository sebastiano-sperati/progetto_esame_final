package it.unicam.cs.mpgc.rpg129546.Show;

import it.unicam.cs.mpgc.rpg129546.Model.Entity;

public class ShowInventory {
    public void showInventory(Entity e){
        if(e.getInventoryManager().getInventario().isEmpty()){
            System.out.println("l'inventario e' vuoto");
            return;
        }
        for (int i = 0; i < e.getInventoryManager().getInventario().size(); i++) {
            System.out.println("[" +
                    (i+1)  +
                    " - " +
                    e.getInventoryManager().getInventario().get(i).getNome() +
                    "-" +
                    e.getInventoryManager().getInventario().get(i).getQta() +
                    "/" +
                    e.getInventoryManager().getInventario().get(i).getMaxQta() +
                    " - " +
                    e.getInventoryManager().getInventario().get(i).getPrezzo() +
                    "$ ]");
        }
    }
}
