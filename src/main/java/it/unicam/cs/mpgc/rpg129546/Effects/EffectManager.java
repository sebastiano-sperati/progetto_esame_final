package it.unicam.cs.mpgc.rpg129546.Effects;

import it.unicam.cs.mpgc.rpg129546.Effects.Effect.Effect;
import it.unicam.cs.mpgc.rpg129546.Model.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * gestisce la logica dietro alla gestione degli effetti
 *
 * Contiene:
 * -metodi per aggiunta e rimozione degli effetti
 * -metodi per effettuare un tick su tutti gli effetti in una lista
 * -metodi per ricercare un singolo effetto
 */
public class EffectManager {

        private List<Effect> effects = new ArrayList<>();

        /**
         * aggiunge un effetto e, se gia è presente, lo sostituisce, estendendone la durata al massimo
         * @param e effetto da aggiungere
         */
        public void addEffect(Effect e) {
                effects.removeIf(effect -> effect.getClass()==e.getClass());
                effects.add(e);
        }

        public List<Effect> getEffects(){
                return effects;
        }

        /**
         * effettua un tick su tutti gli effetti di un entità, richiamando il metodo damageOverTime() ove possibile, e rimuovendo quelli scaduti
         * @param owner entità a cui effettuare i tick
         */
        public void tickAll(Entity owner){
                for (Effect e : effects){
                        e.tick();
                        if(e.getType() == TickType.DOT) e.damageOverTime(owner);
                }
                effects.removeIf(Effect::isExpired);
        }

        /**
         * ricerca un singolo effetto specifico nella lista di un entità
         * @param effectClass effetto da ricercare
         * @return true se l'effetto è presente, false altrimenti
         */
        public boolean hasEffect(Class<?extends Effect>effectClass){
                for (Effect e : effects){
                        if(effectClass.isInstance(e)) return true;
                }
                return false;
        }
}

