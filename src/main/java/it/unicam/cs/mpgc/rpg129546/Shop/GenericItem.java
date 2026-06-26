package it.unicam.cs.mpgc.rpg129546.Shop;

/**
 * contiene i metodi per definire un oggetto generico, che questo sia un item o un pezzo di equipaggiamento
 */
public interface GenericItem {
    /**
     * @return il prezzo dell'item nel negozio
     */
    int getPrezzo();
    String getNome();

    /**
     * la quantità massima dell'item all'interno del negozio
     * @return di default ritorna 1, per far si che i pezzi di equipaggiamento non si possano trovare in massa,
     * viene poi fatto l'overraid per gli item, che tornano un numero random da 2 a 7
     */
    default int getShopQta(){
        return 1;
    }

    /**
     * ridà un nuovo item dello stesso tipo, facendo si che una volta che viene comprato un oggetto dallo shop,
     * due eroi non condividono un puntatore verso uno stesso oggetto, ma abbiano due oggetti completamente diversi
     * @return una copia dell'oggetto acquistato
     */
    GenericItem getCopy();
}
