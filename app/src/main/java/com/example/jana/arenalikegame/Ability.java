package com.example.jana.arenalikegame;

import java.io.Serializable;
import java.util.ArrayList;

public class Ability implements Serializable {
    class Effect implements Serializable {
        private final String targetAttribute;
        private int value;

        public Effect(String targetAttribute, int value) {
            this.targetAttribute = targetAttribute;
            this.value = value;
        }
    }

    private final String abilityName;
    private final int cost;
    private ArrayList<Effect> effects;

    public Ability(String abilityName, int cost) {
        this.abilityName = abilityName;
        this.cost = cost;
        effects = new ArrayList<>();
    }

    public int getCost() {
        return this.cost;
    }

    public void setEffects(Effect effect) {
        effects.add(effect);
    }

    public void applyEffects(Character targetUnit) {
        for(int i = 0; i < effects.size(); i++)
            switch(effects.get(0).targetAttribute){
                case "damege" :break;
                case "defense" : break;
                case "health" : targetUnit.setHealth(targetUnit.getHealth() - effects.get(0).value);
                                break;
            }
    }
}
