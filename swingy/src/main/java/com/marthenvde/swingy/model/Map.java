package com.marthenvde.swingy.model;

import com.marthenvde.swingy.model.characters.*;
import com.marthenvde.swingy.model.misc.Tile;
import java.util.*;

public class Map {
    private List<Enemy> enemies = new ArrayList<Enemy>();
    private Object[][] grid;
    private int size;
    private Hero player;

    Map(int size, Hero player) {
        // Validate size
        grid = new Object[size][size];
        this.player = player;
        this.size = size;

        // Set map to null
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = null;
            }
        }

        int center = (size / 2) + 1;
        grid[center][center] = this.player;
        this.player.setX(center);
        this.player.setY(center);

        // Calculate how many enemies there should be
        int outerTileCount = (size * 4) - 4;
        int innerTileCount = ((size * size) - outerTileCount) - 1;
        int enemyCount = (int)((float)innerTileCount * 0.45);
        Random random = new Random();

        for (int i = 0; i < enemyCount; i++) {
            while (this.mapFull() == false) {
                int randXPos = random.nextInt(((size - 1) - 1));
                int randYPos = random.nextInt(((size - 1) - 1));

                if (grid[randXPos][randYPos] == null) {
                    // Generate enemy
                    System.out.println(randXPos);
                    System.out.println(randYPos);
                    grid[randXPos][randYPos] = new CharacterGenerator().generateRandomEnemy();
                    enemies.add((Enemy)grid[randXPos][randYPos]);
                    break;
                }
            }
        }
    }

    private boolean mapFull() {
        for (int i = 1; i < (size - 1); i++) {
            for (int j = 1; j < (size - 1); j++) {
                if (grid[i][j] == null)
                    return false;
            }
        }
        return true;
    }

    public Object[][] getGrid() {
        return this.grid;
    }

    public Hero getPlayer() {
        return this.player;
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }
}
