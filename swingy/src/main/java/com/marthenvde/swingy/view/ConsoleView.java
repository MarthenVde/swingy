package com.marthenvde.swingy.view;

import java.util.ArrayList;
import com.marthenvde.swingy.model.Map;
import com.marthenvde.swingy.model.artifact.Armor;
import com.marthenvde.swingy.model.artifact.Artifact;
import com.marthenvde.swingy.model.artifact.Helmet;
import com.marthenvde.swingy.model.characters.Hero;
import com.marthenvde.swingy.model.characters.Enemy;

public class ConsoleView implements Renderer {
    public void drawMessage(String message) {
        System.out.println(message);
    }

    public void drawTile(boolean visited) {
        if (visited == false) {
            System.out.print("[ ]");
        } else {
            System.out.print("[#]");
        }
    }

    public void drawArtifactPickup(Artifact artifact) {
        String type;

        if (artifact instanceof Helmet)
            type = "a helmet";
        else if (artifact instanceof Armor)
            type = "armor";
        else
            type = "a weapon";

        System.out.println("You found " + type +  " with power " + artifact.getPower() + "\nequip artifact? (Y/N)");
    }

    public void drawEscape(boolean escaped) {
        if (escaped == true) {
            System.out.println("You succesfully escaped to your previous position!");
        } else {
            System.out.println("You failed to escape.");
        }
    }

    public void drawVictory(String name, String type) {
        System.out.println("You won against " + name + " the " + type);
    }

    public void drawContinueScreen() {
        System.out.print("Want to continue playing? (Y/N): ");
    }

    public void drawMap(Map map) {
        Object[][] grid = map.getGrid();
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] instanceof Hero) {
                    this.drawPlayer();
                } else if ((visited[i][j] != 0) ) {
                    if (grid[i][j] instanceof Enemy) {
                        this.drawMonster();
                    } else {
                        this.drawTile(true);
                    }
                } else {
                    this.drawTile(false);
                }
            }
            System.out.print("\n");
        }
    }
    
    public void drawPlayer() {
        System.out.print("[P]");
    }

    public void drawMonster() {
        System.out.print("[M]");
    }

    public void drawEnemyEncounterOption() {
        System.out.println("You encountered a monster!");
        System.out.println("1. run");
        System.out.println("2. Fight");
    }
    
    public void drawSelectionSceen(ArrayList<Hero> heroes) {
        System.out.println("- Saved Heroes -");
        int i = 1;

        for (Hero hero : heroes) {
            System.out.println(i + ". name: " + hero.getName() + " lvl: " + hero.getLevel());
            i++;
        }
    }
    
    public void drawStartup() {
        System.out.println("  ////////////////////////////");
        System.out.println(" //         Swingy       ///");
        System.out.println("///////////////////////////\n");
    }
    
    public void drawCharacterOptionScreen() {
        System.out.println("- Load previous character? (Y/N) -");
    }
    
    public void drawEndScreen(boolean won) {
        System.out.println("  ////////////////////////////");
        if (won == true) {
            System.out.println(" //        YOU WON!!!     ///");
        } else {
            System.out.println(" //        YOU LOST :(    ///");
        }
        System.out.println("////////////////////////////");
    }

    public void drawCharacterCreationScreen() {
        System.out.println("- Please select a character type -");
        System.out.println("1. Knight");
        System.out.println("2. Barbarian");
        System.out.println("3. Paladin");
        System.out.println("4. Mage");
        System.out.println("5. Assassin");
    }
}
