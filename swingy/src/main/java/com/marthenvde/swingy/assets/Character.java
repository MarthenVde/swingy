package com.marthenvde.swingy.assets;

public class Character extends Asset {

    private String name;
    private int attack;
    private int defense;
    private int hp;

    public Character(String name, int attack, int defense, int hp, int x, int y) {
        super(x, y);
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
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
