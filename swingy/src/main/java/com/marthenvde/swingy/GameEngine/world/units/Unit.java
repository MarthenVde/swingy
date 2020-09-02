package com.marthenvde.swingy.GameEngine.world.units;

public class Unit {
    private String name;
    private int level;
    private String unitClass;
    private int attack;
    private int defense;
    private int hp;
    private int xp;
    private int xPos;
    private int yPos;

    public Unit() {
        this.name = null;
        this.level = 0;
        this.unitClass = null;
        this.attack = 0;
        this.defense = 0;
        this.xp = 0;
        this.hp = 100;
        this.xPos = 0;
        this.yPos = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void takeDamage(int incomingDamage) {
        this.hp -= incomingDamage;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getUnitClass() {
        return this.unitClass;
    }

    public void setUnitClass(String unitClass) {
        this.unitClass = unitClass;
    }

    public int getXPos() {
        return this.xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return this.xPos;
    }
    
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

}
