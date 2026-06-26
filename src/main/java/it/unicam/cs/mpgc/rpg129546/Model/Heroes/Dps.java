package it.unicam.cs.mpgc.rpg129546.Model.Heroes;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Abilities.Enum.CharacterAllocation;

import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

/**
 * definisce tutte le abilità di base e statistiche di un entità dps
 */
public class Dps extends Hero{
    public Dps(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl,sogliaLvlUp);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }
    /**
     * Restituisce la classe di appartenenza dell'eroe.
     *
     * @return allocazione DPS
     */
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.DPS;
    }
    /**
     * Crea un nuovo personaggio DPS inizializzandone
     * statistiche e progressione.
     */
    public Dps(){}
    /**
     * definisce tutti gli sprite utilizzati in base all' azione che effettua o subisce l'entità
     * @param type tipo di azione effettuata o subita
     * @return sprite da utilizzare
     */
    @Override
    public SpriteData getSpriteData(AnimationType type) {
        return switch (type) {
            case IDLE -> new SpriteData("/Sprites/Hero/Dps/dps_idle.png", 130, 68, 4, 3, 130, 0, 0, 1);
            case MELEATTACK -> new SpriteData("/Sprites/Hero/Dps/dps_atk.png", 367, 111, 9, 3, 70, -80, 5, 1);
            case MAGICATTACK -> new SpriteData("/Sprites/Hero/Dps/dps_magic_atk.png", 148, 100, 9, 3, 70, -15, 0, 1);
            case USEITEM -> new SpriteData("/Sprites/Hero/Dps/dps_magic_atk.png", 148, 100, 9, 3, 70, -15, 0, 1);
            case ULTIMATE -> new SpriteData("/Sprites/Hero/Dps/dps_ultimate.png", 368, 190, 30, 3, 55, -90, -25, 0.75);
            case HIT -> new SpriteData("/Sprites/Hero/Dps/dps_hit.png", 55, 54, 2, 2, 100, 15, 10, 1);
            case DEATH -> new SpriteData("/Sprites/Hero/Dps/dps_dead.png", 57, 40, 2, 2, 130, 15, 20, 1);
        };
    }
}
