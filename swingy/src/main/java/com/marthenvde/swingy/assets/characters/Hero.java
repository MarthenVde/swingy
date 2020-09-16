package com.marthenvde.swingy.assets.characters;

import com.marthenvde.swingy.assets.artifact.*;

public class Hero extends Character {
    private int level;
    private Armor armor;
    private Weapon weapon;
    private Helmet helmet;
    
    public Hero(String name, int attack, int defense, int hp, String charClass) {
        super(name, attack, defense, hp, charClass);
        this.armor = null;
        this.helmet = null;
        this.weapon = null;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    } 

    public Helmet getHelmet() {
        return this.helmet;
    }

    public void equipArmor(Armor armor) {
        if (this.armor != null) {
            this.setDefense(this.getDefense() - this.armor.getPower());
        }
        this.armor = armor;
        this.setDefense(this.getDefense() + armor.getPower());
    }

    public void equipWeapon(Weapon weapon) {
        if (this.weapon != null) {
            this.setAttack(this.getAttack() - this.weapon.getPower());
        }
        this.weapon = weapon;
        this.setAttack(this.getAttack() + weapon.getPower());
    }

    public void equipHelmet(Helmet helmet) {
        if (this.helmet != null) {
            this.setHp(this.getHp() - this.helmet.getPower());
        }
        this.helmet = helmet;
        this.setHp(this.getHp() + helmet.getPower());
    }
}