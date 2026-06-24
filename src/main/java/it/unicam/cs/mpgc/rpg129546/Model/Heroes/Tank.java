package it.unicam.cs.mpgc.rpg129546.Model.Heroes;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

public class Tank extends Hero{
    public Tank(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl, sogliaLvlUp);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }
    public Tank(){}

    @Override
    public SpriteData getIdleSpriteData(AnimationType type) {
        return switch (type) {
            case IDLE -> new SpriteData("/Sprites/Hero/Tank/tank_idle.png", 104, 80, 4, 3, 170, 0, 0, 1);
            case MELEATTACK -> new SpriteData("/Sprites/Hero/Tank/tank_mele_atk.png", 194, 125, 12, 3, 80, -35, -10, 0.90);
            case MAGICATTACK -> new SpriteData("/Sprites/Hero/Tank/tank_magic_atk.png", 93, 80, 8, 3, 150, 5, 0, 1);
            case USEITEM -> new SpriteData("/Sprites/Hero/Tank/tank_magic_atk.png", 93, 80, 8, 3, 150, 5, 0, 1);
            case ULTIMATE -> new SpriteData("/Sprites/Hero/Tank/tank_ultimate.png", 337, 177, 24, 3, 65, -90, -25, 0.72);
            case HIT -> new SpriteData("/Sprites/Hero/Tank/tank_hit.png", 82, 52, 1, 1, 350, 10, 15, 1);
            case DEATH -> new SpriteData("/Sprites/Hero/Tank/tank_dead.png", 62, 40, 2, 2, 150, 15, 25, 1);
        };
    }

    @Override
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.TANK;
    }
}
