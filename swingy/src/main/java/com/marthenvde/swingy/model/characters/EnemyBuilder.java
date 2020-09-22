package com.marthenvde.swingy.model.characters;

public class EnemyBuilder {
    private int BASE_ENEMY_HEALTH = 45;
    private int BASE_ENEMY_ATTACK = 15;
    private int BASE_ENEMY_DEFENSE = 15;
    private int BASE_ENEMY_XP = 100;

    public Enemy createOgre(String name) {
        Enemy ogre = new Enemy(name, BASE_ENEMY_ATTACK - 5, BASE_ENEMY_DEFENSE + 5, BASE_ENEMY_HEALTH + 10, "Ogre");
        ogre.setXp(BASE_ENEMY_XP);
        return ogre;
    }

    public Enemy createGoblin(String name) {
        Enemy goblin = new Enemy(name, BASE_ENEMY_ATTACK + 5, BASE_ENEMY_DEFENSE + 5, BASE_ENEMY_HEALTH, "Goblin");
        goblin.setXp(BASE_ENEMY_XP + 25);
        return goblin;
    }

    public Enemy createDragon(String name) {
        Enemy dragon = new Enemy(name, BASE_ENEMY_ATTACK + 15, BASE_ENEMY_DEFENSE + 20, BASE_ENEMY_HEALTH - 10, "Dragon");
        dragon.setXp(BASE_ENEMY_XP + 100);
        return dragon;
    }

    public Enemy createSlime(String name) {
        Enemy slime = new Enemy(name, BASE_ENEMY_ATTACK - 10, BASE_ENEMY_DEFENSE - 10, BASE_ENEMY_HEALTH - 15, "Slime");
        slime.setXp(BASE_ENEMY_XP - 50);
        return slime;
    }
}
