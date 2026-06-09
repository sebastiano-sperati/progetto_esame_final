package it.unicam.cs.mpgc.rpg129546.Persistence.Loaders;

import it.unicam.cs.mpgc.rpg129546.Game.Game;
import it.unicam.cs.mpgc.rpg129546.Persistence.SaveData;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;
import it.unicam.cs.mpgc.rpg129546.Shop.Shop;
import it.unicam.cs.mpgc.rpg129546.model.Eroi.Hero;

import java.util.ArrayList;
import java.util.List;

public class SaveLoader {
    public static Game loadGame(SaveData data){
        List<Hero> eroi = new ArrayList<>();

        for(HeroSave save : data.getHeroes()){
            Hero h = HeroLoader.Load(save);

            InventoryLoader.load(h,save.inventory,new Shop());

            EquipmentLoader.load(h,save);

            eroi.add(h);
        }
        Game game = new Game(eroi);
        game.setFloor(data.getFloor());
        return game;
    }
}

