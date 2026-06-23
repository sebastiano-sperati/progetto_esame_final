package it.unicam.cs.mpgc.rpg129546.Model.Heroes;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

public class Healer extends Hero{
    public Healer(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl, sogliaLvlUp);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }
    public Healer(){}

    @Override
    public SpriteData getIdleSpriteData(AnimationType type) {
        return switch (type){
            case IDLE -> new SpriteData("/Sprites/Hero/Idle/healer_idle.png",84,72,8,3, 170);
            case MELEATTACK -> new SpriteData("/Sprites/Hero/Attack/Mele/healer_atk.png", 96, 79, 10, 3, 75);
            case MAGICATTACK -> new SpriteData("/Sprites/Hero/Attack/Magic/healer_magic_atk.png", 96, 79, 10, 3, 75);
            case USEITEM -> new SpriteData("/Sprites/Hero/Attack/Magic/healer_magic_atk.png", 488, 277, 22, 3, 75);
            case ULTIMATE -> new SpriteData("/Sprites/Hero/Attack/Ultimate/healer_ultimate.png", 104, 80, 8, 4, 90);
            case HIT -> new SpriteData("/Sprites/Hero/takeDamage/Hit/healer_hit.png", 104, 80, 1, 1, 1000);
            case DEATH -> new SpriteData("/Sprites/Hero/takeDamage/Death/healer_death.png", 104, 80, 6, 3, 130);
        };
    }


    @Override
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.HEALER;
    }
}
