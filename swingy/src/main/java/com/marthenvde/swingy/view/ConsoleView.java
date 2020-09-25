package com.marthenvde.swingy.view;

import com.marthenvde.swingy.model.Map;
import com.marthenvde.swingy.model.characters.Hero;
import com.marthenvde.swingy.model.characters.Enemy;

public class ConsoleView implements Renderer {
    public void drawTile(boolean visited) {
        if (visited == false) {
            System.out.print("*");
        } else {
            System.out.print("_");
        }
    }

    public void drawMap(Map map) {
        Object[][] grid = map.getGrid();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] instanceof Hero) {
                    this.drawPlayer();
                } else if (grid[i][j] instanceof Enemy) {
                    this.drawMonster();
                } else if (grid[i][j] == null) {
                    this.drawTile(false);
                } else {
                    System.out.print("?");
                }
            }
            System.out.print("\n");
        }
    }
    
    public void drawPlayer() {
        System.out.print("P");
    }

    public void drawMonster() {
        System.out.print("M");
    }
    
    public void drawSelectionSceen() {
        System.out.print(" ---- START ----");
        System.out.print("  Load previous character? (Y/N)");
    }
}
