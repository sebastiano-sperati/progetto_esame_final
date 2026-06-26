package it.unicam.cs.mpgc.rpg129546.Model.Enemies;

import it.unicam.cs.mpgc.rpg129546.Model.Entity;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.AnimationType;
import it.unicam.cs.mpgc.rpg129546.Ui.Sprites.SpriteData;

import java.util.ArrayList;

/**
 * definisce un nemico generico, contenente
 * -taglia (influenzata dal livello)
 * -xpDrop(influenzato dal livello)
 */
public abstract class Enemy extends Entity {
    protected int numeroAzioni = 4;
    private final int taglia;
    private final int xpDrop;
    public Enemy(String nome, int maxHp, int maxAp, int dif, int atk, int wis, double eva, double critMult, double critChance, int lvl, int taglia, int xpDrop) {
        super(nome, maxHp, maxAp, dif, atk, wis, eva, critMult, critChance, lvl);
        this.azioni = new ArrayList<>(numeroAzioni);
        this.taglia = taglia;
        this.xpDrop= xpDrop;
    }

    public int getScaledTaglia() {
        return this.taglia + (2 + this.getStatusManager().getLvl());
    }

    public int getScaledXpDrop(){
        return this.xpDrop + (2 * this.getStatusManager().getLvl());
    }
    /**
     * definisce tutti gli sprite utilizzati in base all' azione che effettua o subisce l'entità
     * @param type tipo di azione effettuata o subita
     * @return sprite da utilizzare
     */
    @Override
    public abstract SpriteData getSpriteData(AnimationType type);
}
