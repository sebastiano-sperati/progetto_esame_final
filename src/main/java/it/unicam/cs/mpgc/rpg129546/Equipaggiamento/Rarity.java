package it.unicam.cs.mpgc.rpg129546.Equipaggiamento;

public enum Rarity {
    STARTER(1.0,25),
    COMUNE(1.15,150),
    RARO(1.5,200),
    LEGENDARIO(2.0,350);

    private final double modifier;
    private final int prezzo;

    Rarity(double modifier, int prezzo){
        this.modifier=modifier;
        this.prezzo = prezzo;
    }

    public double getModifier() {
        return modifier;
    }

    public int getPrezzo(){
        return prezzo;
    }
}
