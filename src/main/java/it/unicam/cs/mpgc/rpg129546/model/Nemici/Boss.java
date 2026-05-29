package it.unicam.cs.mpgc.rpg129546.model.Nemici;

public class Boss extends Enemy{
    public Boss(String nome, int maxHp, int maxAp, int dif, int atk,int wis, double eva, double critMult, double critChance, int lvl) {
        super(nome, maxHp, maxAp, dif, atk,wis, eva, critMult, critChance, lvl);
        this.hp=this.maxHp=180;
        this.ap=this.maxAp=40;
        this.dif=12;
        this.atk=20;
        this.eva=eva;
        this.critChance=critChance;
        this.critMult=critMult;
    }
}
