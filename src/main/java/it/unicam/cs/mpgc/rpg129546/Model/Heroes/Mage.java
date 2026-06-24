package it.unicam.cs.mpgc.rpg129546.Model.Heroes;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

public class Mage extends Hero{
    public Mage(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl,int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk, wis, eva, critMult, critChance, lvl,sogliaLvlUp);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }
    public Mage(){}

    @Override
    public SpriteData getIdleSpriteData(AnimationType type) {
        return switch (type) {
            case IDLE -> new SpriteData("/Sprites/Hero/Mage/mage_idle.png", 81, 81, 8, 3, 150, 0, 0, 1);
            case MELEATTACK -> new SpriteData("/Sprites/Hero/Mage/mage_atk.png", 161, 162, 9, 3, 70, -40, -40, 0.68);
            case MAGICATTACK -> new SpriteData("/Sprites/Hero/Mage/mage_magic_atk.png", 81, 81, 8, 3, 140, 0, 0, 1);
            case USEITEM -> new SpriteData("/Sprites/Hero/Mage/mage_magic_atk.png", 81, 81, 8, 3, 140, 0, 0, 1);
            case ULTIMATE -> new SpriteData("/Sprites/Hero/Mage/mage_ultimate.png", 64, 96, 90, 3, 45, 10, -15, 1);
            case HIT -> new SpriteData("/Sprites/Hero/Mage/mage_hit.png", 48, 37, 2, 2, 120, 15, 20, 1);
            case DEATH -> new SpriteData("/Sprites/Hero/Mage/mage_dead.png", 51, 36, 2, 2, 140, 15, 25, 1);
        };
    }

    @Override
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.MAGE;
    }
}
