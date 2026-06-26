package it.unicam.cs.mpgc.rpg129546.Model.Enemies;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.DebufAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

/**
 * definisce tutte le statisstiche o azioni per un entità orco
 */
public class Orco extends Enemy {
    public Orco(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl, int taglia, int xpDrop) {
        super(nome, maxHp, maxAp, dif, atk, wis, eva, critMult, critChance, lvl, taglia, xpDrop);
        this.hp = this.maxHp = maxHp;
        this.ap = this.maxAp = maxAp;
        this.dif = dif;
        this.atk = atk;
        this.eva = eva;
        this.critChance = critChance;
        this.critMult = critMult;
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new DebufAtk());
    }

    /**
     * definisce tutti gli sprite utilizzati in base all' azione che effettua o subisce l'entità
     * @param type tipo di azione effettuata o subita
     * @return sprite da utilizzare
     */
    @Override
    public SpriteData getSpriteData(AnimationType type) {
        return switch (type) {
            case IDLE -> new SpriteData("/Sprites/Enemy/Ogre/ogre_idle.png", 104, 80, 8, 3, 170, 0, 0, 1);
            case MELEATTACK ->
                    new SpriteData("/Sprites/Enemy/Ogre/ogre_mele_atk.png", 194, 125, 15, 3, 75, -45, -18, 0.88);
            case MAGICATTACK -> new SpriteData("/Sprites/Enemy/Ogre/ogre_magic_atk.png", 104, 80, 8, 3, 150, 0, 0, 1);
            case USEITEM -> new SpriteData("/Sprites/Enemy/Ogre/ogre_magic_atk.png", 104, 80, 8, 3, 150, 0, 0, 1);
            case ULTIMATE -> new SpriteData("/Sprites/Enemy/Ogre/ogre_ulti.png", 334, 333, 30, 3, 55, -110, -95, 0.62);
            case HIT -> new SpriteData("/Sprites/Enemy/Ogre/ogre_hit.png", 82, 60, 2, 2, 120, 15, 18, 1);
            case DEATH -> new SpriteData("/Sprites/Enemy/Ogre/ogre_dead.png", 80, 55, 2, 2, 150, 18, 28, 1);
        };
    }
}