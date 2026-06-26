package it.unicam.cs.mpgc.rpg129546.Persistence.Savers;

import it.unicam.cs.mpgc.rpg129546.Equipment.Armor;
import it.unicam.cs.mpgc.rpg129546.Equipment.Weapon;
import it.unicam.cs.mpgc.rpg129546.Items.Consumables.Item;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.ArrayList;

/**
 * gestisce la logica con cui, alla fine di una battaglia, nel caso si voglia salvare e uscire,
 * si riesce a salvare lo stato attuale degli eroi
 */
public class GenericSaver {
    /**
     * passa in parametro l'eroe da salvare e il luogo in cui salvare le informazioni,
     * per poi richiamare i metodi per effettuare il salvataggio
     * @param save dove salvare i dati
     * @param h eroe di cui si devono salvare i dati
     */
    public void GenericSaver(HeroSave save, Hero h){
        HeroSaver(save,h);
        EquipSaver(save,h.getArma(),h.getArmatura());
        InvSaver(save,h);
    }

    /**
     * salva di un solo eroe, solo le variabili importanti che sono mutevoli
     * @param save dove salvare i dati
     * @param hero eroe di cui salvare i dati
     */
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

    /**
     * per ogni arma e armatura passata in parametro, ne salva i dati fondamentali
     * @param save dove salvare i dati
     * @param w arma da salvare
     * @param a armatura da salvare
     */
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

    /**
     * salva, per ogni eroe passato in parametro, tutte le infomazioni relativa al suo inventario
     * @param save dove salvare i dati
     * @param h eroi di cui si devono salvare i dati
     */
    public void InvSaver(HeroSave save, Hero h){
        for(Item i : h.getInventoryManager().getInventario()){
            ItemSave itemSave = new ItemSave();

            itemSave.nome = i.getNome();
            itemSave.qta = i.getQta();

            save.inventory.add(itemSave);
        }
    }
}
