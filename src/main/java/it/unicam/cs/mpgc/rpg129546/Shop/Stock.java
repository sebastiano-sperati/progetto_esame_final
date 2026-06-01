package it.unicam.cs.mpgc.rpg129546.Shop;

public class Stock {
    GenericItem item;
    int qta;
    public Stock(GenericItem item, int qta){
        this.item=item;
        this.qta=qta;
    }

    public GenericItem getItem() {
        return item;
    }

    public int getQta() {
        return qta;
    }

    public void decreaseQta(){
        qta--;
    }

    public boolean soldOut(){
        return qta==0;
    }
}
