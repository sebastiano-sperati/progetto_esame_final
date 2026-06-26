package it.unicam.cs.mpgc.rpg129546.Persistence.Loaders;

import it.unicam.cs.mpgc.rpg129546.Game.Game;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveData;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.Abilities.AbilityRegistry;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * gestisce la logica per caricare gli eroi al loro stato di salvataggio, senza implementare tutte le logiche,
 * mantenedo una singola responsabilità, per poi far iniziare una nuova partita
 */
public class SaveLoader {
    /**
     * dopo aver inizializzato una nuova lista di eroi, costruita richiamando, per ogni eroe presente nel salvataggio,
     * i vari metodi per ricaricare: equipaggiamento, inventario e statistiche, fa iniziare una nuova partita,
     * con la squadra caricata, dall'ultimo piano in cui ci si era interrotti
     * @param data dati salvati dalla partita precedente
     * @return una nuova partita con i dati di quella precedente
     */
    public static Game loadGame(SaveData data){
        List<Hero> eroi = new ArrayList<>();

        for(HeroSave save : data.getHeroes()){
            Hero h = HeroLoader.Load(save);

            InventoryLoader.load(h,save.inventory,new Shop());

            EquipmentLoader.load(h,save);

            AbilityRegistry.getAbilityFor(h);

            eroi.add(h);
        }
        Game game = new Game(eroi);
        game.setFloor(data.getFloor());
        return game;
    }
}

