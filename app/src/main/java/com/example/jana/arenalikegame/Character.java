package com.example.jana.arenalikegame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Character implements Serializable {
    private String name;
    private String charClass;
    private String hostility;
    private int strenght;
    private int dexterity;
    private int vitality;
    private int willPower;
    private int health;
    private int maxHealth;
    private int maxStamina;
    private int stamina;
    private int attackPower;
    private int defense;
    private Dice dice;
    String massage;
    List<Ability> abilities = new ArrayList<>();

    Character(String name, String charClass, String hostility, int strenght, int dexterity, int vitality, int willPower, Dice dice) {
        this.name = name;
        this.charClass = charClass;
        this.hostility = hostility;
        this.strenght = strenght;
        this.dexterity = dexterity;
        this.vitality = vitality;
        this.willPower = willPower;
        this.dice=dice;
        health = vitality *30;
        maxHealth = health;
        if(charClass =="Warrior")
            attackPower = strenght *3;
        else if(charClass =="Rogue")
            attackPower = dexterity *2+ strenght;
        else if(charClass =="Mage")
            attackPower = willPower;
        defense = dexterity +10;
        stamina =10* willPower;
        maxStamina = stamina;
        Ability ability1 = new Ability("Ability1",10);
        Ability.Effect effect1 = ability1.new Effect("health", 30);
        ability1.setEffects(effect1);
        abilities.add(ability1);

        Ability ability2 = new Ability("Ability2",12);
        Ability.Effect effect2 = ability2.new Effect("health", 20);
        ability2.setEffects(effect2);
        abilities.add(ability2);

        Ability ability3 = new Ability("Ability3",14);
        Ability.Effect effect3 = ability3.new Effect("health", 100);
        ability3.setEffects(effect3);
        abilities.add(ability3);
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getVitality() {
        return vitality;
    }

    public void setSilaVule(int silavule) {
        this.willPower =silavule;
    }

    public int getSilaVule() {
        return willPower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getCharClass() {
        return charClass;
    }

    public String getHostility() { return this.hostility; }

    public int getMaxZdravi() {
        return maxHealth;
    }

    public void setZdravi() {
        health = vitality *30;
        maxHealth = health;
    }

    public void setHealth(int health) {
        this.health = health;

    }

    public int getHealth() {
        return health;
    }

    public void setVydrzMana() {
        stamina = 10* willPower;
        maxStamina = stamina;
    }

    public void setVydrzMana(int vydrzmana) {
        this.stamina =vydrzmana;
    }

    public int getVydrzMana() {
        return stamina;
    }

    public int getMaxVydrzMana() {
        return maxStamina;
    }

    public void setUtok() {
        if(charClass =="Warrior")
            attackPower = strenght *3;
        else if(charClass =="Rogue")
            attackPower = dexterity *2+ strenght;
        else if(charClass =="Mage")
            attackPower = willPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setObrana() {
        defense = dexterity +10;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void defenseCharacter(int uder) {
        int zraneni=uder-(defense + dice.throwDice());
        if (zraneni > 0) {
            health -= zraneni;
            massage = String.format("%s utrpěl poškození %s hp", name, zraneni);
            if( health<=0) {
                health=0;
                massage += " a zemřel";
            }
        } else
            massage = String.format("%s odrazil útok", name);
    }

    public void attack(Character protivnik) {
        int uder = attackPower + dice.throwDice();
        nastavZpravu(String.format("%s útočí s úderem za %s hp", name, uder));
        protivnik.defenseCharacter(uder);
    }

    public void useAbility(int abilittId, Character protivnik) {
        if (this.stamina >=  abilities.get(abilittId).getCost()) {
            abilities.get(abilittId).applyEffects(protivnik);
            this.stamina -= abilities.get(abilittId).getCost();
        }
    }

    protected void nastavZpravu(String zprava) {
        this.massage = zprava;
    }

    public String vratPosledniZpravu() {
        return massage;
    }
}
