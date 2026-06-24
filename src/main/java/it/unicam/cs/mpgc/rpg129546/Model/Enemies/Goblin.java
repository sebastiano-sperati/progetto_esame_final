package it.unicam.cs.mpgc.rpg129546.Model.Enemies;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.MultiAtk;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

public class Goblin extends Enemy{
    public Goblin(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl, int taglia, int xpDrop) {
        super(nome, maxHp, maxAp, dif, atk, wis, eva, critMult, critChance, lvl, taglia, xpDrop);
        this.hp=this.maxHp;
        this.ap=this.maxAp;
        this.dif = dif;
        this.atk=atk;
        this.eva=eva;
        this.critChance=critChance;
        this.critMult=critMult;
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
        azioni.add(new MultiAtk());
    }

    @Override
    public SpriteData getIdleSpriteData(AnimationType type) {
        return switch (type) {
            case IDLE -> new SpriteData("/Sprites/Enemy/Goblin/goblin_idle.png", 106, 98, 8, 3, 170, 0, 0, 1);
            case MELEATTACK -> new SpriteData("/Sprites/Enemy/Goblin/goblin_mele_atk.png", 155, 102, 15, 3, 70, -18, -5, 0.90);
            case MAGICATTACK -> new SpriteData("/Sprites/Enemy/Goblin/goblin_magic_atk.png", 100, 107, 8, 3, 150, 0, -5, 1);
            case USEITEM -> new SpriteData("/Sprites/Enemy/Goblin/goblin_magic_atk.png", 100, 107, 8, 3, 150, 0, -5, 1);
            case ULTIMATE -> new SpriteData("/Sprites/Enemy/Goblin/goblin_magic_atk.png", 100, 107, 8, 3, 150, 0, -5, 1);
            case HIT -> new SpriteData("/Sprites/Enemy/Goblin/goblin_hit.png", 54, 53, 2, 2, 120, 10, 15, 1);
            case DEATH -> new SpriteData("/Sprites/Enemy/Goblin/goblin_dead.png", 56, 43, 2, 2, 150, 12, 20, 1);
        };
    }
}
