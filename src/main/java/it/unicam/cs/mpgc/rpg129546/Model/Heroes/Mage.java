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
        return switch (type){
            case IDLE -> new SpriteData("/Sprites/Hero/Idle/mage_idle.png",88,89,8,3, 170);
            case MELEATTACK -> new SpriteData("/Sprites/Hero/Attack/Mele/mage_atk.png", 153, 105, 10, 3, 75);
            case MAGICATTACK -> new SpriteData("/Sprites/Hero/Attack/Magic/mage_magic_atk.png", 153, 105, 10, 3, 75);
            case USEITEM -> new SpriteData("/Sprites/Hero/Attack/Magic/mage_magic_atk.png", 153, 105, 10, 3, 75);
            case ULTIMATE -> new SpriteData("/Sprites/Hero/Attack/Ultimate/mage_ultimate.png", 557, 760, 107, 4, 90);
            case HIT -> new SpriteData("/Sprites/Hero/takeDamage/Hit/mage_hit.png", 88, 89, 1,1, 1000);
            case DEATH -> new SpriteData("/Sprites/Hero/takeDamage/Death/mage_death.png", 104, 80, 6, 3, 130);
        };
    }

    @Override
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.MAGE;
    }
}
