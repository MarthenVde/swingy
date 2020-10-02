package com.marthenvde.swingy.model.characters;

import java.util.Random;

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

    public void attack(Character opponent) {
        if (this.attack > opponent.getDefense()) {
            opponent.setHp(opponent.getHp() - (opponent.getDefense() - this.attack));
        } else {
            int luck = new Random().nextInt(5);

            if (luck >= 4) {
                opponent.setHp(opponent.getHp() - this.attack);
            }
        }
    }

    public boolean simulateFight(Character opponent) {
        while (this.hp > 0 && opponent.getHp() > 0) {
            this.attack(opponent);
            opponent.attack(this);
        }

        return (this.hp > 0);
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
