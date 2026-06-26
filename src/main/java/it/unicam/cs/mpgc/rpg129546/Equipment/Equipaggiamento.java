package it.unicam.cs.mpgc.rpg129546.Equipment;

import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;

/**
 * definisce un pezzo di equipaggiamento
 */
public interface Equipaggiamento extends GenericItem {
    /**
     *
     * @return la rarità del pezzo di qeuipaggiamento (influisce sulle statistiche)
     */
    Rarity getRarity();

    /**
     *
     * @return un numero double che va a modificare determinate statistiche (determinato dalla rarità)
     */
    double getModifier();
}
