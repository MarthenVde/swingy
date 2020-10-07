package com.marthenvde.swingy.controller;

import java.util.ArrayList;
import com.marthenvde.swingy.model.characters.Enemy;
import com.marthenvde.swingy.model.characters.Hero;
import com.marthenvde.swingy.view.Renderer;
import com.marthenvde.swingy.model.Map;
import com.marthenvde.swingy.model.Storage;
import com.marthenvde.swingy.model.artifact.Armor;
import com.marthenvde.swingy.model.artifact.Artifact;
import com.marthenvde.swingy.model.artifact.Helmet;
import com.marthenvde.swingy.model.artifact.Weapon;
import com.marthenvde.swingy.model.characters.HeroBuilder;
import java.util.Random;

public class GameEngine {
    private final int MAX_LEVEL = 5;
    private Map map;
    private Renderer renderer;
    private Hero player;
    private Controller controller;
    private ArrayList<Hero> heroes;
    private int mapSize;
    private final Random random = new Random();
    private int baseHp;

    private String uniqueHeroName() {
        String input = this.controller.getInputName().strip();

        if (this.heroes != null) {
            for (int i = 0; i < this.heroes.size(); i++) {
                if (this.heroes.get(i).getName().equals(input)) {
                    this.renderer.drawMessage("Please use a unique name!");
                    return uniqueHeroName();
                }
            }
        }
        return input;
    }

    private void createNewHero() {
        this.renderer.drawCharacterCreationScreen();
        int selectedNum = this.controller.getNumberChoice(5);
        String name = uniqueHeroName();


        switch (selectedNum) {
            case 1:
                this.player = new HeroBuilder().createKnight(name);
                break;
            case 2:
                this.player = new HeroBuilder().createBarbarian(name);
                break;
            case 3:
                this.player = new HeroBuilder().createPaladin(name);
                break;
            case 4:
                this.player = new HeroBuilder().createMage(name);
                break;
            case 5:
                this.player = new HeroBuilder().createAssassin(name);
                break;
            default:
                this.player = new HeroBuilder().createKnight(name);
                break;
        }
        Storage.addHero(this.player);
        this.baseHp = this.player.getHp();
    }

    public GameEngine(Renderer renderEngine, Controller inputController) {
        this.renderer = renderEngine;
        this.controller = inputController;
        this.heroes = Storage.extractHeroes();
        this.player = null;
        this.renderer.drawStartup();

        if (this.heroes != null) {
            this.renderer.drawCharacterOptionScreen();
            String choice = this.controller.getYesNo();
            
            if (choice.equals("y")) {
                this.renderer.drawSelectionSceen(this.heroes);
                int selectedNum = this.controller.getNumberChoice(heroes.size());
                this.player = heroes.get(selectedNum - 1);
                return;
            }
        }
        this.createNewHero();
    }

    private void resetHp() {
        this.player.setHp(this.baseHp);
    }

    private Map generateMap() {
        int level = this.player.getLevel();

        if (level > this.MAX_LEVEL) {
            this.player.setLevel(this.MAX_LEVEL);
        }

        this.mapSize = (level - 1) * 5 + 10 - (level % 2);
        // System.out.println("Generating map size: " + mapSize);

        return new Map(this.mapSize, this.player);
    }

    public void roundEnd() {
        this.resetHp();
        Storage.updateHero(this.player);
        this.renderer.drawContinueScreen();

   
        String choice = this.controller.getYesNo();
            
        if (choice.equals("y")) {
            this.Start();
        } else {
            System.exit(0);
        }
    }

    private void addXp(int xp) {
        int newXp = this.player.getXp() + xp;
        int lvl = 0;

        if (newXp >= 1000)
            lvl = 1;
        if (newXp >= 2450)
            lvl = 2;
        if (newXp >= 4800)
            lvl = 3;
        if (newXp >= 8050)
            lvl = 4;
        if (newXp >= 12200) {
            lvl = 5;
            newXp = 12200;
        }

        this.player.setLevel(lvl);
        this.player.setXp(newXp);
    }

    public void startFight(Enemy enemy) {
        int xp = enemy.getXp();
        boolean wonFight = this.player.simulateFight(enemy);

        if (wonFight == true) {
            this.renderer.drawVictory(enemy.getName(), enemy.getCharClass());
            this.addXp(xp);
            Artifact droppedArtifact = Enemy.generateArtifact();

            if (droppedArtifact != null) {
                this.renderer.drawArtifactPickup(droppedArtifact);
                if (this.controller.getYesNo().equals("y")) {
                    if (droppedArtifact instanceof Helmet) {
                        this.player.setHelmet((Helmet)droppedArtifact);
                    } else if (droppedArtifact instanceof Armor) {
                        this.player.setArmor((Armor)droppedArtifact);
                    } else if (droppedArtifact instanceof Weapon) {
                        this.player.setWeapon((Weapon)droppedArtifact);
                    }
                }
            }
        } else {
            this.renderer.drawMessage("You lost the fight!");
            this.renderer.drawEndScreen(false);
            this.roundEnd();
        }
    }
    
    public void Start() {
        this.map = this.generateMap();
        
        while (true) {
            this.renderer.drawMap(this.map);
            String direction = this.controller.getMovementInput();
            int x = this.player.getX();
            int y = this.player.getY();
            
            switch (direction) {
                case "up":
                x--;
                break;
                case "left":
                y--;
                break;
                case "down":
                x++;
                break;
                case "right":
                y++;
            }
            
            if (x <= 0 || x >= (this.mapSize - 1) || y <= 0 || y >= (this.mapSize - 1)) {
                this.map.updatePlayerPosition(x, y);
                this.renderer.drawMap(this.map);
                this.renderer.drawEndScreen(true);
                this.roundEnd();
            }
            
            if (this.map.getGrid()[x][y] instanceof Enemy) {
                this.renderer.drawEnemyEncounterOption();
                Enemy enemy = (Enemy)this.map.getGrid()[x][y];
                int action = this.controller.getNumberChoice(2);
            
                if (action == 1) {
                    boolean ranAway = this.random.nextBoolean();

                    if (ranAway == false) {
                        this.renderer.drawEscape(false);
                        this.startFight(enemy);
                    } else {
                        this.renderer.drawEscape(true);
                        x = this.player.getX();
                        y = this.player.getY();
                    }
                } else {
                    this.startFight(enemy);
                }
            }
            this.map.updatePlayerPosition(x, y);
        }
    }
}  