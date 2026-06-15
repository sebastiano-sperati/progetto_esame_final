package it.unicam.cs.mpgc.rpg129546.Persistence.Savers;

import it.unicam.cs.mpgc.rpg129546.Equipment.Armor;
import it.unicam.cs.mpgc.rpg129546.Equipment.Weapon;
import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.ArrayList;

public class GenericSaver {

    public void GenericSaver(HeroSave save, Hero h){
        HeroSaver(save,h);
        EquipSaver(save,h.getArma(),h.getArmatura());
        InvSaver(save,h);
    }

    public void HeroSaver(HeroSave save, Hero hero){
        save.type = hero.getClass().getSimpleName();
        save.nome = hero.getNome();

        save.hp = hero.getStatusManager().getHp();
        save.maxHp = hero.getStatusManager().getMaxHp();

        save.ap = hero.getStatusManager().getAp();
        save.maxAp = hero.getStatusManager().getMaxAp();

        save.lvl = hero.getStatusManager().getLvl();
        save.gold = hero.getHeroStatusManager().getGold();

        save.xp = hero.getHeroStatusManager().getXp();
        save.sogliaLvlUp = hero.getHeroStatusManager().getSogliaLvlUp();
    }

    public void EquipSaver(HeroSave save, Weapon w, Armor a){
        save.weapon = new WeaponSave();
        save.weapon.nome = w.getNome();
        save.weapon.rarity = String.valueOf(w.getRarity());
        save.weapon.scaling = String.valueOf(w.getScaling());

        save.armor = new ArmorSave();
        save.armor.nome = a.getNome();
        save.armor.rarity = a.getRarity().name();
        save.inventory = new ArrayList<>();
    }

    public void InvSaver(HeroSave save, Hero h){
        for(Item i : h.getInventoryManager().getInventario()){
            ItemSave itemSave = new ItemSave();

            itemSave.nome = i.getNome();
            itemSave.qta = i.getQta();

            save.inventory.add(itemSave);
        }
    }
}
