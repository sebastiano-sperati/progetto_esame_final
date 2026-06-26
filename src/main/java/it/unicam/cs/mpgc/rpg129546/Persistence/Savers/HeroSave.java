package it.unicam.cs.mpgc.rpg129546.Persistence.Savers;

import java.util.List;

/**
 * definisce tutte le variabili fondamentali per identificare un eroe (statistiche come atk, wis, dif, eva, critChance e crit mult,
 * non sono strettamente variabili, in quanto il loro valore è fisso, e viene poi scalato tramite il livello, è quindi inutile salvarle,
 * e ad ogni nuovo caricamento, tramite heroFactory(), basta semplicemente rimettere gli stessi valori)
 */
public class HeroSave {
    public String type;

    public String nome;

    public int hp;
    public int maxHp;
    public int ap;
    public int maxAp;


    public int lvl;
    public int xp;
    public int gold;

    public int sogliaLvlUp;

    public WeaponSave weapon;
    public ArmorSave armor;
    public List<ItemSave> inventory;
}
