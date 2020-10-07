package com.marthenvde.swingy;

import com.marthenvde.swingy.controller.ConsoleInputController;
import com.marthenvde.swingy.controller.GameEngine;
import com.marthenvde.swingy.controller.GuiInputController;
import com.marthenvde.swingy.controller.Controller;
import com.marthenvde.swingy.view.ConsoleView;
import com.marthenvde.swingy.view.GuiView;
import com.marthenvde.swingy.view.Renderer;
import javax.validation.*;

public class Swingy 
{
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    public static Validator validator = factory.getValidator();
    public static void main( String[] args )
    {
        Renderer renderEngine;
        GameEngine gameEngine;
        Controller controller;


        if (args.length >= 1) {
            if ((args[0].toLowerCase()).equals("console") || (args[0].toLowerCase()).equals("gui")) {

                if ((args[0].toLowerCase()).equals("console")) {
                    renderEngine = new ConsoleView();
                    controller = new ConsoleInputController(renderEngine);
                    
                } else {
                    renderEngine = new GuiView();
                    controller = new GuiInputController(renderEngine);
                }
                gameEngine = new GameEngine(renderEngine, controller);
                gameEngine.Start();

            } else {
                System.err.println("Invalid launch option");
            }
        } else {
            System.err.println("Missing launch mode!");
        }
    }
}
