package com.marthenvde.swingy.model.characters;
import java.util.*;

public class CharacterGenerator {
    private String[] enemyNames = {
        "Drace Bloodworth",
        "Enigma La Croix",
        "Brink Thornheart",
        "Cloven Blackwood",
        "Raven Ripper",
        "Raven Diablo",
        "Requiem Grim",
        "Moon Soulton",
        "Weiss Lobo",
        "Crowley Blankley",
        "Enigma Jinx",
        "Sceledrus Serphent",
        "Lincoln Le Torneau",
        "Sisk Mortem",
        "Driscoll Wood",
        "Oklarth Tenebris",
        "Franz Wolf",
        "Hunter Whitmore",
        "Smoky Hook",
        "Gotham Sharpe"
    };

    private final int ENEMY_TYPE_COUNT = 4;

    public Enemy generateRandomEnemy() {
        Random randomIndex = new Random();
        String name = enemyNames[randomIndex.nextInt(enemyNames.length)];

        int enemyTypeIndex = randomIndex.nextInt(ENEMY_TYPE_COUNT);
        Enemy newEnemy = null;
        switch (enemyTypeIndex) {
            case 0:
                newEnemy = new EnemyBuilder().createSlime(name);
                break;
            case 1:
                newEnemy = new EnemyBuilder().createOgre(name);
                break;
            case 2:
                newEnemy = new EnemyBuilder().createGoblin(name);
                break;
            case 3:
                newEnemy = new EnemyBuilder().createDragon(name);
                break;
            default:
                newEnemy = new EnemyBuilder().createSlime(name);
        }
        return newEnemy;
    }
}
