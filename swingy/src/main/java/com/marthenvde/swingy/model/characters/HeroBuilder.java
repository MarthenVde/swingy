package com.marthenvde.swingy.model.characters;

public class HeroBuilder {
    private int BASE_HEALTH = 125;
    private int BASE_ATTACK = 25;
    private int BASE_DEFENSE = 20;
    private int BASE_XP = 0;

    public Hero createKnight(String name) {
        Hero knight = new Hero(name, BASE_ATTACK, BASE_DEFENSE + 5, BASE_HEALTH + 10, "Knight", BASE_HEALTH + 10);
        knight.setXp(BASE_XP);
        knight.setLevel(0);
        return knight;
    }
    public Hero createBarbarian(String name) {
        Hero knight = new Hero(name, BASE_ATTACK + 5, BASE_DEFENSE + 5, BASE_HEALTH - 10, "Barbarian", BASE_HEALTH - 5);
        knight.setXp(BASE_XP);
        knight.setLevel(0);
        return knight;
    }

    public Hero createPaladin(String name) {
        Hero knight = new Hero(name, BASE_ATTACK - 10, BASE_DEFENSE + 20, BASE_HEALTH + 25, "Paladin", BASE_HEALTH + 25);
        knight.setXp(BASE_XP);
        knight.setLevel(0);
        return knight;
    }

    public Hero createMage(String name) {
        Hero knight = new Hero(name, BASE_ATTACK + 15, BASE_DEFENSE - 5, BASE_HEALTH - 20, "Mage", BASE_HEALTH - 20);
        knight.setXp(BASE_XP);
        knight.setLevel(0);
        return knight;
    }

    public Hero createAssassin(String name) {
        Hero assassin = new Hero(name, BASE_ATTACK + 20, BASE_DEFENSE - 10, BASE_HEALTH  - 15, "Assassin", BASE_HEALTH - 15);
        assassin.setXp(BASE_XP);
        assassin.setLevel(0);
        return assassin;
    }
}
