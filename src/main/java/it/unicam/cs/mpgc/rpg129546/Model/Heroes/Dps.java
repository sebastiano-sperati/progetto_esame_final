package it.unicam.cs.mpgc.rpg129546.Model.Heroes;

import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.BaseAtk;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.Defend;
import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;

import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;
import javafx.scene.image.Image;

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
    public SpriteData getIdleSpriteData() {
        return new SpriteData("/Sprites/dps_idle.png",104,80,4,3,180);
    }

}
