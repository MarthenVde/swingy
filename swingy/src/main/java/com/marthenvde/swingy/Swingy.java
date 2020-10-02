package com.marthenvde.swingy;

import java.util.ArrayList;

import com.marthenvde.swingy.controller.ConsoleInputController;
import com.marthenvde.swingy.controller.GameEngine;
import com.marthenvde.swingy.controller.InputContoller;
import com.marthenvde.swingy.view.ConsoleView;
import com.marthenvde.swingy.view.Renderer;
import com.marthenvde.swingy.model.Storage;
import com.marthenvde.swingy.model.characters.Hero;
import com.marthenvde.swingy.model.Map;

public class Swingy 
{
    public static void main( String[] args )
    {
        Renderer renderEngine;
        GameEngine gameEngine;
        InputContoller controller;

        if (args.length >= 1) {
            if ((args[0].toLowerCase()).equals("console") || (args[0].toLowerCase()).equals("gui")) {
                if ((args[0].toLowerCase()).equals("console")) {
                    renderEngine = new ConsoleView();
                    controller = new ConsoleInputController();
                    
                } else {
                    renderEngine = new ConsoleView();
                    controller = new ConsoleInputController();
                    System.out.println("Loading gui view");
                }

                
                
                Hero player1 = new Hero("john", 0,0,0,"Warrior");
                Hero player2 = new Hero("john2", 0,0,0,"Warrior");
                Hero player3 = new Hero("john3", 0,0,0,"Warrior");
                
                // Storage.addHero(player1);
                // Storage.addHero(player2);
                Map map = new Map(3, player1);
                
                gameEngine = new GameEngine(renderEngine, controller);
                gameEngine.Start();
                // renderEngine.drawMap(map);
                // renderEngine.drawStartup();
                // renderEngine.drawSelectionSceen();
                // renderEngine.drawEndScreen(true);
                // renderEngine.drawEndScreen(false);
                
                
                // renderEngine.drawMap(map);
                
                // Storage.addHero(player3);

                // ArrayList<Hero> myHeroes = Storage.extractHeroes();
                
                // System.out.println("UPDATING HEROES\n");
                // player1.setName("Frederik");
                // Storage.updateHero(player1);

                // myHeroes = Storage.extractHeroes();

                // TODO: Get player

                // 

                // gameEngine.s

            } else {
                System.err.println("Invalid launch option");
            }
        } else {
            System.err.println("Missing launch mode!");
        }
    }
}
