package it.unicam.cs.mpgc.rpg129546.Persistence.Loaders;

import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Armor;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Rarity;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.Weapon;
import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.WeaponScaling;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

public class EquipmentLoader {
    public static void load(Hero h, HeroSave save){
        Weapon w = new Weapon(save.weapon.nome, Rarity.valueOf(save.weapon.rarity), WeaponScaling.valueOf(save.weapon.scaling));

        Armor a = new Armor(save.armor.nome, Rarity.valueOf(save.armor.rarity));

        h.equipaggiaArmatura(a);
        h.equipaggiaArma(w);
    }
}
