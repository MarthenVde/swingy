package com.marthenvde.swingy;

import com.marthenvde.swingy.controller.GameEngine;
import com.marthenvde.swingy.view.ConsoleView;
import com.marthenvde.swingy.view.Renderer;

public class Swingy 
{
    public static void main( String[] args )
    {
        Renderer renderEngine;
        GameEngine gameEngine;

        System.out.println(9 / 2);
        if (args.length >= 1) {
            if ((args[0].toLowerCase()).equals("console") || (args[0].toLowerCase()).equals("gui")) {
                if ((args[0].toLowerCase()).equals("console")) {
                    renderEngine = new ConsoleView();
                } else {
                    renderEngine = new ConsoleView();
                    System.out.println("Loading gui view");
                }

                gameEngine = new GameEngine(renderEngine);
                
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
