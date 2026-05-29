package it.unicam.cs.mpgc.rpg129546.effect;

import it.unicam.cs.mpgc.rpg129546.effect.Effetti.Effect;
import it.unicam.cs.mpgc.rpg129546.model.Entity;

import java.util.ArrayList;
import java.util.List;

public class effectManager {
        private List<Effect> effects = new ArrayList<>();

        public void addEffect(Effect e) {
                effects.removeIf(effect -> effect.getClass()==e.getClass());
                effects.add(e);
        }

        public List<Effect> getEffects(){
                return effects;
        }

        public void showEffects(){
                for (int i = 0; i < effects.size(); i++) {
                        System.out.println("[" + effects.get(i).getNome() + "-" + effects.get(i).getTick() + "/" + effects.get(i).getDuration() + "]");
                }
        }

        public void tickAll(Entity owner){
                for (Effect e : effects){
                        e.tick();
                        if(e.getType() == tickType.DOT) owner.getEffectaApplier().applyDOT(owner,e);
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

