package it.unicam.cs.mpgc.rpg129546.Shop;

public interface GenericItem {
    int getPrezzo();
    String getNome();
    default int getShopQta(){
        return 1;
    }
    GenericItem getCopy();
}
