package it.unicam.cs.mpgc.rpg129546.Persistence.Savers;

import java.util.List;

public class HeroSave {
    public String type;

    public String nome;

    public int hp;
    public int maxHp;
    public int ap;
    public int maxAp;

    public int atk;
    public int def;
    public int wis;

    public int lvl;
    public int xp;
    public int gold;

    public int sogliaLvlUp;

    public WeaponSave weapon;
    public ArmorSave armor;
    public List<ItemSave> inventory;
}
