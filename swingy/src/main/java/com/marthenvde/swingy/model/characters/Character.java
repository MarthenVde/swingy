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
        int oldHp = opponent.getHp();

        System.out.println("Attack is : " + this.attack + " opponent defense: " + opponent.getDefense());

        if (this.attack > opponent.getDefense()) {
            opponent.setHp(oldHp - (this.attack - opponent.getDefense()));
            System.out.println(this.name + " Attacked1 "  + opponent.getName() + " with: " + (this.attack - opponent.getDefense()));
            System.out.println(opponent.getHp());
        } else {
            int luck = new Random().nextInt(5);

            System.out.println("Luack is " + luck);
            
            if (luck >= 4) {
                System.out.println(this.name + " Attacked2"  + opponent.getName() + " with: " + (this.attack - 2));
                opponent.setHp((opponent.getHp() - (this.attack - 2)));
                System.out.println(opponent.getHp());
            }
        }
    }

    public boolean simulateFight(Character opponent) {
        System.out.println("starting fight");
        System.out.println("Opponent health " + opponent.getHp());
        System.out.println("player health " + this.getHp());

        while ((this.hp > 0) && (opponent.getHp() > 0)) {
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
