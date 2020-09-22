package com.marthenvde.swingy.model.characters;

public class Character {

    private String name;
    private int attack;
    private int defense;
    private int hp;
    private String charClass;
    private int xp;
    private int x;
    private int y;

    public Character(String name, int attack, int defense, int hp, String charClass) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.charClass = charClass;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return this.xp;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getCharClass() {
        return this.charClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
