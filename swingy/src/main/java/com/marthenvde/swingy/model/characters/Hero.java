package com.marthenvde.swingy.model.characters;
import com.marthenvde.swingy.model.artifact.*;
import javax.validation.constraints.Min;

public class Hero extends Character {

    @Min(value = 0, message = "lvl must not be less 0")
    private int level;
    private Armor armor;
    private Weapon weapon;
    private Helmet helmet;
    private int id;
    private static int idCounter = 0;
    
    public Hero(String name, int attack, int defense, int hp, String charClass) {
        super(name, attack, defense, hp, charClass);
        this.armor = null;
        this.helmet = null;
        this.weapon = null;
        this.id = nextId();
    }

    private static int nextId() {
        return idCounter++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
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
