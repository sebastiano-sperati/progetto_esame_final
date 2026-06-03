package it.unicam.cs.mpgc.rpg129546.model;

import it.unicam.cs.mpgc.rpg129546.Equipaggiamento.WeaponScaling;

public class StatsManager {
    private final Entity owner;

    public StatsManager (Entity owner){
        this.owner = owner;
    }

    public int getScaledDmg(){
        if(owner.getArma().getScaling() == WeaponScaling.STR) {
            return (int) (getScaledAtk() * owner.getArma().getModifier());
        }
        return (int) (getScaledWis() * owner.getArma().getModifier());
    }

    public int getScaledAtk(){
        return owner.getAtk()  + owner.getStatusManager().getLvl() * 3;
    }

    public int getScaledWis(){
        return owner.getWis() + owner.getStatusManager().getLvl() * 3;
    }

    public int getScaledDif(){ return (int) ((owner.getDif() + owner.getStatusManager().getLvl() * 2) + owner.getArmatura().getModifier());}

    public double getScaledEva(){
        return Math.min(owner.getEva() + owner.getStatusManager().getLvl() * 0.005,0.5);
    }

    public double getScaledCM(){
        return owner.getCritMult() + owner.getStatusManager().getLvl() * 0.02;
    }

    public double getScaledCC(){
        return owner.getCritChance() + owner.getStatusManager().getLvl() * 0.01;
    }

    public int getScaledMaxHP(){
        return owner.getStatusManager().getMaxHp() + owner.getStatusManager().getLvl() * 2;
    }

    public int getScaledMaxAp(){
        return owner.getStatusManager().getMaxAp() + owner.getStatusManager().getLvl() * 2;

    }
}
