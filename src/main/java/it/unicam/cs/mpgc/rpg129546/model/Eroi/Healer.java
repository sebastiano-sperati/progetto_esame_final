package it.unicam.cs.mpgc.rpg129546.model.Eroi;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.abilities.abilità.BaseAbilities.*;

public class Healer extends Hero{
    public Healer(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl, sogliaLvlUp);
        azioni.add(new BaseAtk());
        azioni.add(new Defend());
    }
    public Healer(){}
    @Override
    public CharacterAllocation getCharacterAllocation(){
        return CharacterAllocation.HEALER;
    }
}
