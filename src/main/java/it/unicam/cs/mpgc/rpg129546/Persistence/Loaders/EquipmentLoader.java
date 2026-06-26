package it.unicam.cs.mpgc.rpg129546.Persistence.Loaders;

import it.unicam.cs.mpgc.rpg129546.Equipment.Armor;
import it.unicam.cs.mpgc.rpg129546.Equipment.Rarity;
import it.unicam.cs.mpgc.rpg129546.Equipment.Weapon;
import it.unicam.cs.mpgc.rpg129546.Equipment.WeaponScaling;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

/**
 * gestisce la logica per far si che, dopo un caricamento,
 * ad un eroe vengano equipaggiati gli oggetti che possedeva prima del salvataggio
 */
public class EquipmentLoader {
    /**
     * all'eroe passato in parametro, da una nuova arma e una nuova armatura, con noma, rarità, e scaliing nel caso dell'arma,
     * uguali a quelli presenti nel salvataggio
     * @param h nuovo eroe a cui equipaggiare gli oggetti
     * @param save salvataggio dell'aroe precedente
     */
    public static void load(Hero h, HeroSave save){
        Weapon w = new Weapon(save.weapon.nome, Rarity.valueOf(save.weapon.rarity), WeaponScaling.valueOf(save.weapon.scaling));

        Armor a = new Armor(save.armor.nome, Rarity.valueOf(save.armor.rarity));

        h.equipaggiaArmatura(a);
        h.equipaggiaArma(w);
    }
}
