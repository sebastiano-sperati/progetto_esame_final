package it.unicam.cs.mpgc.rpg129546.Persistence.Loaders;

import it.unicam.cs.mpgc.rpg129546.Game.Factory.HeroFactory;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

public class HeroLoader {
    public static Hero Load(HeroSave save){

        Hero hero = HeroFactory.generateSave(save.type, save);

        hero.getStatusManager().setHp(save.hp);
        hero.getStatusManager().setAp(save.ap);
        hero.getHeroStatusManager().setXp(save.xp);
        hero.getHeroStatusManager().setGold(save.gold);
        hero.getHeroStatusManager().setSogliaLvlUp(save.sogliaLvlUp);

        return hero;
    }
}
