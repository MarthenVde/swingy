package com.marthenvde.swingy.model.characters;

import java.util.Random;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Character {

    @NotNull(message = "Name should not be null")
    @Size(min = 1, max = 10, message = "Name must be between 1 - 10 characters")
    private String name;

    @Min(value = 0, message = "Attack must not be less than 0")
    private int attack;
    
    @Min(value = 0, message = "Defense must not be less than 0")
    private int defense;
    
    @Min(value = 0, message = "Hp must be greater than 0")
    private int hp;

    @NotNull(message = "charClass must not be null")
    private String charClass;

    @Min(value = 0, message = "Xp must not be less than 0")
    private int xp;
    
    @Min(value = 0, message = "x must not be less than 0")
    private int x;
    
    @Min(value = 0, message = "y must not be less than 0")
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

        // System.out.println("Attack is : " + this.attack + " opponent defense: " + opponent.getDefense());

        if (this.attack > opponent.getDefense()) {
            opponent.setHp(oldHp - (this.attack - opponent.getDefense()));
            // System.out.println(this.name + " Attacked1 "  + opponent.getName() + " with: " + (this.attack - opponent.getDefense()));
            // System.out.println(opponent.getHp());
        } else {
            int luck = new Random().nextInt(5);            
            if (luck >= 4) {
                // System.out.println(this.name + " Attacked2"  + opponent.getName() + " with: " + (this.attack - 2));
                opponent.setHp((opponent.getHp() - (this.attack)));
                // System.out.println(opponent.getHp());
            }
        }
    }

    public boolean simulateFight(Character opponent) {
        // System.out.println("starting fight");
        // System.out.println("Opponent health " + opponent.getHp());
        // System.out.println("player health " + this.getHp());

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
