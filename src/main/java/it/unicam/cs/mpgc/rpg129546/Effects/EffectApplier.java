package it.unicam.cs.mpgc.rpg129546.Effects;

import it.unicam.cs.mpgc.rpg129546.Effects.Effect.Effect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

public class EffectApplier {
    public int modifyDmg(Entity e){
        int dmg = e.getStatsManager().getScaledDmg();
        for (Effect effect : e.getEffectManager().getEffects()){
            dmg =effect.modifyAtk(dmg);
        }
        return dmg;
    }

    public int modifyDif(Entity e){
        int dif = e.getStatsManager().getScaledDif();
        for (Effect effect:e.getEffectManager().getEffects()){
            dif=effect.modifyDif(dif);
        }
        return dif;
    }

    public double modifyEva(Entity e){
        double eva = e.getStatsManager().getScaledEva();
        for (Effect effect : e.getEffectManager().getEffects()){
            eva=effect.modifyEva(eva);
        }
        return eva;
    }

    public double modifyCM(Entity e){
        double cm = e.getStatsManager().getScaledCM();
        for (Effect effect : e.getEffectManager().getEffects()){
            cm=effect.modifyCritMult(cm);
        }
        return cm;
    }

    public double modifyCC(Entity e){
        double cc = e.getStatsManager().getScaledCC();
        for (Effect effect : e.getEffectManager().getEffects()){
            cc = effect.modifyCritChance(cc);
        }
        return cc;
    }
}
