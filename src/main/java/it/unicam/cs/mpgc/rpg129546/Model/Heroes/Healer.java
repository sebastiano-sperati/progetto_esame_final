package it.unicam.cs.mpgc.rpg129546.Model.Heroes;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

/**
 * definisce tutte le abilità di base e statistiche di un entità healer
 */
public class Healer extends Hero{
    public Healer(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl, sogliaLvlUp);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }

    /**
     * crea un nuovo personaggio HEALER inizianizzaondone statistiche e progressione
     */
    public Healer(){}
    /**
     * definisce tutti gli sprite utilizzati in base all' azione che effettua o subisce l'entità
     * @param type tipo di azione effettuata o subita
     * @return sprite da utilizzare
     */
    @Override
    public SpriteData getSpriteData(AnimationType type) {
        return switch (type) {
            case IDLE -> new SpriteData("/Sprites/Hero/Healer/healer_idle.png", 81, 81, 8, 3, 150, 0, 0, 1);
            case MELEATTACK -> new SpriteData("/Sprites/Hero/Healer/healer_atk.png", 170, 150, 18, 3, 70, -45, -25, 0.70);
            case MAGICATTACK -> new SpriteData("/Sprites/Hero/Healer/healer_magic_atk.png", 82, 82, 8, 3, 140, 0, 0, 1);
            case USEITEM -> new SpriteData("/Sprites/Hero/Healer/healer_magic_atk.png", 82, 82, 8, 3, 140, 0, 0, 1);
            case ULTIMATE -> new SpriteData("/Sprites/Hero/Healer/healer_ultimate.png", 323, 243, 24, 3, 60, -115, -80, 0.62);
            case HIT -> new SpriteData("/Sprites/Hero/Healer/healer_hit.png", 47, 39, 2, 2, 120, 15, 20, 1);
            case DEATH -> new SpriteData("/Sprites/Hero/Healer/healer_dead.png", 55, 37, 2, 2, 150, 15, 25, 1);
        };
    }


    /**
     * resituisce la classe di appartenenza dell'eroe
     *
     * @return allocazione HEALER
     */
    @Override
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.HEALER;
    }
}
