package it.unicam.cs.mpgc.rpg129546.Model.Heroes;

import it.unicam.cs.mpgc.rpg129546.Abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.Abilities.Ability.BaseAbilities.*;

public class Mage extends Hero{
    public Mage(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl,int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk, wis, eva, critMult, critChance, lvl,sogliaLvlUp);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }
    public Mage(){}
    @Override
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.MAGE;
    }
}
