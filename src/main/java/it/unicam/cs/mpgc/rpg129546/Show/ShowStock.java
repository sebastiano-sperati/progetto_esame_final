package it.unicam.cs.mpgc.rpg129546.Show;

import it.unicam.cs.mpgc.rpg129546.Shop.Stock;

import java.util.List;

public class ShowStock {
    public void showStock(List<Stock>stock){
        System.out.println("===SHOP===");
        for (int i = 0; i < stock.size(); i++) {
            System.out.println((i+1) + " " + stock.get(i).getItem().getNome() + " " + stock.get(i).getItem().getPrezzo() + "$ - qta: " + stock.get(i).getQta());
        }
    }
}
