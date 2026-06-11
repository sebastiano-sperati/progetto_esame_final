package it.unicam.cs.mpgc.rpg129546.model.Eroi;

import it.unicam.cs.mpgc.rpg129546.abilities.CharacterAllocation;
import it.unicam.cs.mpgc.rpg129546.model.Entity;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.util.ArrayList;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dps.class, name = "DPS"),
        @JsonSubTypes.Type(value = Tank.class, name = "TANK"),
        @JsonSubTypes.Type(value = Healer.class, name = "HEALER"),
        @JsonSubTypes.Type(value = Mage.class, name = "MAGE"),
})

public class Hero extends Entity {
    protected int xp;
    protected int sogliaLvlUp;
    protected int numeroAzioni;
    protected int gold;
    protected HeroStatusManager heroStatusManager;
    public Hero(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl, int sogliaLvlUp) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl);
        this.gold=10000;
        this.xp = 0;
        this.numeroAzioni=4;
        this.azioni=new ArrayList<>(numeroAzioni);
        this.sogliaLvlUp = sogliaLvlUp;
        this.heroStatusManager = new HeroStatusManager(this,hp,maxHp,atk,maxAp,lvl,isAlive,xp,sogliaLvlUp,gold);
    }

    public CharacterAllocation getCharacterAllocation() {
        return null;
    }

    public Hero() {
        super();
    }

    public HeroStatusManager getHeroStatusManager(){return this.heroStatusManager;}
}
