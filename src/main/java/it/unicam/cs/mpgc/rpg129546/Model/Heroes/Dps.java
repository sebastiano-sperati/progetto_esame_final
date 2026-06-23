package it.unicam.cs.mpgc.rpg129546.Model.Heroes;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;

import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

public class Dps extends Hero{
    public Dps(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl,sogliaLvlUp);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }

    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.DPS;
    }
    public Dps(){}

    @Override
    public SpriteData getIdleSpriteData(AnimationType type) {
        return switch (type){
            case IDLE -> new SpriteData("/Sprites/Hero/Idle/dps_idle.png", 104, 80, 4, 3, 180);
            case MELEATTACK -> new SpriteData("/Sprites/Hero/Attack/Mele/dps_atk.png", 194, 125, 12, 3, 70);
            case MAGICATTACK -> new SpriteData("/Sprites/Hero/Attack/Magic/dps_magic_atk.png",104,80,4,3,180);
            case USEITEM -> new SpriteData("/Sprites/Hero/Attack/Magic/dps_magic_atk.png",104,80,4,3,180);
            case ULTIMATE -> new SpriteData("/Sprites/Hero/Attack/Ultimate/dps_ultimate.png", 334, 333, 128, 3, 50);
            case HIT -> new SpriteData("/Sprites/Hero/takeDamage/Hit/dps_hit.png", 104, 80, 1, 1, 100);
            case DEATH -> new SpriteData("/Sprites/Hero/takeDamage/Death/dps_death.png", 104, 80, 6, 3, 130);
        };
    }

}
