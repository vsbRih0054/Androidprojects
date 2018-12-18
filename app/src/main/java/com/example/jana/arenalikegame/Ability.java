package com.example.jana.arenalikegame;

import java.util.ArrayList;

public class Ability {
    class Effect {
        private final String targetAttribute;
        private int value;

        public Effect(String targetAttribute, int value) {
            this.targetAttribute = targetAttribute;
            this.value = value;
        }
    }

    private final int cost;
    private ArrayList<Effect> effects;

    public Ability(int cost) {
        this.cost = cost;
        effects = new ArrayList<>();
    }

    public void setEffects(Effect effect) {
        effects.add(effect);
    }

    public void applyEffects(Character targetUnit) {
        for(int i = 0; i < effects.size(); i++)
            switch(effects.get(i).targetAttribute){
                case "damege" : int uder = effects.get(i).value;
                                targetUnit.setVydrzMana(targetUnit.getVydrzMana()-cost);
                                targetUnit.nastavZpravu(String.format("%s použil schopnost s úderem za %s hp", targetUnit.getName(), uder));
                                targetUnit.defenseCharacter(uder);
                                break;
                case "defense" :
                                 break;
                case "health" : break;
            }
    }
}
