package it.unicam.cs.mpgc.rpg129546.Model.Enemies;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.*;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

/**
 * definisce abilità e statistiche della classe rappresentante un boss
 */
public class Boss extends Enemy{
    public Boss(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl, int taglia, int xpDrop) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl, taglia, xpDrop);
        this.hp=this.maxHp=180;
        this.ap=this.maxAp=40;
        this.dif=12;
        this.atk=20;
        this.eva=eva;
        this.critChance=critChance;
        this.critMult=critMult;
        azioni.add(new MultiAtk());
        azioni.add(new FireBall());
        azioni.add(new DebufAtk());
        azioni.add(new Defend());
        azioni.add(new BaseAtk());
    }

    /**
     * definisce tutti gli sprite utilizzati in base all' azione che effettua o subisce l'entità
     * @param type tipo di azione effettuata o subita
     * @return sprite da utilizzare
     */
    @Override
    public SpriteData getSpriteData(AnimationType type) {
        return switch (type) {
            case IDLE -> new SpriteData("/Sprites/Enemy/Boss/boss_idle.png", 104, 80, 8, 3, 170, 0, 0, 1);
            case MELEATTACK -> new SpriteData("/Sprites/Enemy/Boss/boss_mele_atk.png", 194, 125, 15, 3, 70, -55, -20, 0.90);
            case MAGICATTACK -> new SpriteData("/Sprites/Enemy/Boss/boss_magic_atk.png", 194, 125, 15, 3, 70, -45, -15, 0.90);
            case USEITEM -> new SpriteData("/Sprites/Enemy/Boss/boss_magic_atk.png", 194, 125, 15, 3, 70, -45, -15, 0.90);
            case ULTIMATE -> new SpriteData("/Sprites/Enemy/Boss/boss_ulti.png", 334, 333, 30, 3, 50, -120, -100, 0.65);
            case HIT -> new SpriteData("/Sprites/Enemy/Boss/boss_hit.png", 82, 60, 2, 2, 120, 15, 20, 1);
            case DEATH -> new SpriteData("/Sprites/Enemy/Boss/boss_dead.png", 82, 60, 2, 2, 150, 18, 30, 1);
        };
    }
}
