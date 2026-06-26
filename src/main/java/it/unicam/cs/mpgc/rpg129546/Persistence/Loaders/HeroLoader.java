package it.unicam.cs.mpgc.rpg129546.Persistence.Loaders;

import it.unicam.cs.mpgc.rpg129546.Game.Factory.HeroFactory;
import it.unicam.cs.mpgc.rpg129546.Persistence.Savers.HeroSave;
import it.unicam.cs.mpgc.rpg129546.Model.Heroes.Hero;

/**
 * gestisce la logica per far si che si crei un nuovo eroe, identico a quello presente nel salvataggio
 */
public class HeroLoader {
    /**
     * crea un nuovo eroe, della stessa classe di quello passato in parametro,
     * con le stesse statistiche, la classe serve solo per rigenerare la classe dell eroe, e le sue statistiche,
     * non si occupa di inventario o equipaggiamenti
     * @param save eroe salvato
     * @return un nuovo eroe con le stesse statistiche di quello in parametro
     */
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
