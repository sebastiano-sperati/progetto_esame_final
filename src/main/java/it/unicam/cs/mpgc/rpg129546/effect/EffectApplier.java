package it.unicam.cs.mpgc.rpg129546.effect;

import it.unicam.cs.mpgc.rpg129546.model.Entity;

public class EffectApplier {
    public int modifyAtk(Entity e){
        int atk = e.getScaledAtk();
        for (Effect effect : e.getEffectManager().getEffects()){
            atk=effect.modifyAtk(atk);
        }
        return atk;
    }

    public int modifyDif(Entity e){
        int dif = e.getScaledDif();
        for (Effect effect:e.getEffectManager().getEffects()){
            dif=effect.modifyDif(dif);
        }
        return dif;
    }

    public double modifyEva(Entity e){
        double eva = e.getScaledEva();
        for (Effect effect : e.getEffectManager().getEffects()){
            eva=effect.modifyEva(eva);
        }
        return eva;
    }

    public double modifyCM(Entity e){
        double cm = e.getScaledCM();
        for (Effect effect : e.getEffectManager().getEffects()){
            cm=effect.modifyCritMult(cm);
        }
        return cm;
    }

    public double modifyCC(Entity e){
        double cc = e.getScaledCC();
        for (Effect effect : e.getEffectManager().getEffects()){
            cc = effect.modifyCritChance(cc);
        }
        return cc;
    }
    public void applyDOT(Entity entity, Effect effect){
        effect.damageOverTime(entity);
    }
}
