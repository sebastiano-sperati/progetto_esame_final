package it.unicam.cs.mpgc.rpg129546.Equipaggiamento;

import it.unicam.cs.mpgc.rpg129546.Shop.GenericItem;

public interface Equipaggiamento extends GenericItem {
    Rarity getRarity();
    double getModifier();
}
