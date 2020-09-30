package com.marthenvde.swingy.controller;

import java.util.ArrayList;
import com.marthenvde.swingy.model.characters.Hero;
import com.marthenvde.swingy.view.Renderer;
import com.marthenvde.swingy.model.Map;
import com.marthenvde.swingy.model.Storage;
import com.marthenvde.swingy.controller.InputContoller;
import com.marthenvde.swingy.model.characters.HeroBuilder;

public class GameEngine {
    private final int MAX_LEVEL = 7;
    private Map map;
    private Renderer renderer;
    private Hero player;
    private InputContoller controller;
    private ArrayList<Hero> heroes;

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
                // select previous hero
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

    public void Gameloop() {

    }
    // event hanler
    // movement controller
}  