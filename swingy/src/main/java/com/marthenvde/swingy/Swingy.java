package com.marthenvde.swingy;

import com.marthenvde.swingy.controller.GameEngine;
import com.marthenvde.swingy.view.ConsoleView;
import com.marthenvde.swingy.view.Renderer;
import com.marthenvde.swingy.model.Storage;
import com.marthenvde.swingy.model.characters.Hero;

public class Swingy 
{
    public static void main( String[] args )
    {
        Renderer renderEngine;
        GameEngine gameEngine;

        if (args.length >= 1) {
            if ((args[0].toLowerCase()).equals("console") || (args[0].toLowerCase()).equals("gui")) {
                if ((args[0].toLowerCase()).equals("console")) {
                    renderEngine = new ConsoleView();
                } else {
                    renderEngine = new ConsoleView();
                    System.out.println("Loading gui view");
                }

                gameEngine = new GameEngine(renderEngine);


                Hero player1 = new Hero("john", 0,0,0,"Warrior");
                Hero player2 = new Hero("john2", 0,0,0,"Warrior");
                Hero player3 = new Hero("john3", 0,0,0,"Warrior");
        
                // Storage.addHero(player1);
                // Storage.addHero(player2);
                // Storage.addHero(player3);

                Storage.extractHeroes();
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
