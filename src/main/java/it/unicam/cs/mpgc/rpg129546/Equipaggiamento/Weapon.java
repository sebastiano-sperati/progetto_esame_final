package it.unicam.cs.mpgc.rpg129546.Equipaggiamento;

public class Weapon implements Equipaggiamento{
    private final String nome;
    private final Rarity rarity;
    private final WeaponScaling scaling;

    public Weapon(String nome,Rarity rarity,WeaponScaling scaling){
        this.nome=nome;
        this.rarity=rarity;
        this.scaling=scaling;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getPrezzo() {
        return rarity.getPrezzo();
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public double getModifier() {
        return rarity.getModifier();
    }

    public WeaponScaling getScaling() {
        return scaling;
    }
}
