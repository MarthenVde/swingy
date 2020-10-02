package com.marthenvde.swingy.controller;

import java.util.ArrayList;

import com.marthenvde.swingy.model.characters.Enemy;
import com.marthenvde.swingy.model.characters.Hero;
import com.marthenvde.swingy.view.Renderer;
import com.marthenvde.swingy.model.Map;
import com.marthenvde.swingy.model.Storage;
import com.marthenvde.swingy.controller.InputContoller;
import com.marthenvde.swingy.model.characters.HeroBuilder;
import java.util.Random;

public class GameEngine {
    private final int MAX_LEVEL = 7;
    private Map map;
    private Renderer renderer;
    private Hero player;
    private InputContoller controller;
    private ArrayList<Hero> heroes;
    private Object[][] grid;
    private int mapSize;
    private final Random random = new Random();

    public GameEngine(Renderer renderEngine, InputContoller inputContoller) {
        this.renderer = renderEngine;
        this.controller = inputContoller;
        this.heroes = Storage.extractHeroes();
        this.player = null;
        this.renderer.drawStartup();

        if (this.heroes != null) {
            this.renderer.drawCharacterOptionScreen();
            String choice = this.controller.getYesNo();
            int selectedNum;
            
            if (choice.equals("y")) {
                this.renderer.drawSelectionSceen(this.heroes);
                selectedNum = this.controller.getNumberChoice(heroes.size());

                this.player = heroes.get(selectedNum - 1);
            } else {
                this.renderer.drawCharacterCreationScreen();
                selectedNum = this.controller.getNumberChoice(5);
                String name = this.controller.getInputName();

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
            }
        }

        
    }

    private Map generateMap() {
        int level = this.player.getLevel();
        this.mapSize = (level - 1) * 5 + 10 - (level % 2);
        System.out.println("Generating map size: " + mapSize);

        return new Map(this.mapSize, this.player);
    }

    public void roundEnd() {
        Storage.updateHero(this.player);

        if (this.player.getLevel() == MAX_LEVEL) {
            String choice = this.controller.getYesNo();
            
            if (choice.equals("y")) {
                this.Start();
            } else {
                this.renderer.drawEndScreen(true);
            }
        }
    }

    public void startFight(Enemy enemy) {
        int xp = enemy.getXp();
        boolean wonFight = this.player.simulateFight(enemy);

        if (wonFight) {
            this.renderer.drawVictory(enemy.getName(), enemy.getCharClass());
            // get artifact
            // artifact selection
        } else {

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
                this.renderer.drawContinueScreen();
                
                String choice =  this.controller.getYesNo();

                if (choice.equals("y")) {
                    this.Start();
                }
                break;
            }
            
            if (this.map.getGrid()[x][y] instanceof Enemy) {
                this.renderer.drawEnemyEncounterOption();
                int action = this.controller.getNumberChoice(2);
            
                if (action == 1) {
                    boolean ranAway = this.random.nextBoolean();

                    if (ranAway == false) {
                        this.renderer.drawEscape(false);
                        this.startFight();
                    } else {
                        this.renderer.drawEscape(true);
                        int x = this.player.getX();
                        int y = this.player.getY();
                    }
                } else {
                    this.startFight();
                }
            }

            this.map.updatePlayerPosition(x, y);
        }
    }
    // event hanler
    // movement controller
}  