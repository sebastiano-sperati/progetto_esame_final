package it.unicam.cs.mpgc.rpg129546.effect;

import it.unicam.cs.mpgc.rpg129546.effect.Effetti.Effect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;
import java.util.List;

public class EffectManager {

        private List<Effect> effects = new ArrayList<>();

        public void addEffect(Effect e) {
                effects.removeIf(effect -> effect.getClass()==e.getClass());
                effects.add(e);
        }

        public List<Effect> getEffects(){
                return effects;
        }

        public void tickAll(Entity owner){
                for (Effect e : effects){
                        e.tick();
                        if(e.getType() == TickType.DOT) e.damageOverTime(owner);
                }
                effects.removeIf(Effect::isExpired);
        }

        public boolean hasEffect(Class<?extends Effect>effectClass){
                for (Effect e : effects){
                        if(effectClass.isInstance(e)) return true;
                }
                return false;
        }
}

