package it.unicam.cs.mpgc.rpg129546.Shop;

/**
 * genera un item nello stock con una quantità decisa dal tipo di item venduto
 */
public class Stock {
    GenericItem item;
    int qta;
    public Stock(GenericItem item, int qta){
        this.item= item;
        this.qta=qta;
    }

    public GenericItem getItem() {
        return item;
    }

    public int getQta() {
        return qta;
    }

    /**
     * ad ogni acquisto, viene decrementata la qujantità di item presenti nello shop
     */
    public void decreaseQta(){
        qta--;
    }

    /**
     *
     * @return true nel caso non ci siano più item nello shop, false altrimenti
     */
    public boolean soldOut(){
        return qta==0;
    }
}
