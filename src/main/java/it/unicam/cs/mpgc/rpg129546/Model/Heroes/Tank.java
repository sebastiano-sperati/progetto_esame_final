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
        return switch (type){
            case IDLE -> new SpriteData("/Sprites/Hero/Idle/tank_idle.png",101,81,4,3, 170);
            case MELEATTACK -> new SpriteData("/Sprites/Hero/Attack/Mele/tank_atk.png", 101, 81, 24, 3, 100);
            case MAGICATTACK -> new SpriteData("/Sprites/Hero/Attack/Magic/tank_magic_atk.png",101,81,4,3, 170);
            case USEITEM -> new SpriteData("/Sprites/Hero/Attack/Magic/tank_magic_atk.png",101,81,4,3, 170);
            case ULTIMATE -> new SpriteData("/Sprites/Hero/Attack/Ultimate/tank_ultimate.png", 618, 198, 36, 4, 90);
            case HIT -> new SpriteData("/Sprites/Hero/takeDamege/Hit/tank_hit.png", 101, 81, 1, 1, 1000);
            case DEATH -> new SpriteData("/Sprites/Hero/takeDamage/Death/tank_death.png", 101, 81, 6, 3, 130);
        };
    }

    @Override
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.TANK;
    }
}
