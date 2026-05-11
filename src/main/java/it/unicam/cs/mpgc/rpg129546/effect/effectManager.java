package it.unicam.cs.mpgc.rpg129546.effect;

import java.util.ArrayList;
import java.util.List;

public class effectManager {
        private List<Effect> effects = new ArrayList<>();

        public void addEffect(Effect e) {
                effects.add(e);
        }

        public List<Effect> getEffects(){
                return effects;
        }

        public void tickAll(){
                for (Effect e : effects){
                        e.tick();
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

