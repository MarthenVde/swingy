package com.marthenvde.swingy.controller;

import com.marthenvde.swingy.view.Renderer;

abstract class InputContoller implements Controller {
    private Renderer renderEngine;

    public abstract String getUserInput();
    
    InputContoller(Renderer rendererEngine) {
        this.renderEngine = rendererEngine;
    }

    public String getInputName() {
        renderEngine.drawMessage("Please Input a name.");
        String input = getUserInput().strip();

        if (input.length() > 10) {
            renderEngine.drawMessage("Please keep your name under 10 characters!");
            return getInputName();
        } else {
            return input;
        }
    }

    public String getYesNo() {
        String input = getUserInput();
        
        if ((input.toLowerCase().equals("n")) || (input.toLowerCase().equals("y"))) {
            return input.toLowerCase();
        } else {
            renderEngine.drawMessage("Incorrect use - (Y/N)");
            return getYesNo();
        }
    }

    public String getMovementInput() {
        renderEngine.drawMessage("Select type direction to move (UP, DOWN, LEFT, RIGHT):");
        String input = getUserInput().toLowerCase();

        if (input.equals("up") || input.equals("down") 
            || input.equals("left") || input.equals("right")) {
            return input;
        } else {
            renderEngine.drawMessage("Invalid direction!");
            return getMovementInput();
        }
    }

    public int getNumberChoice(int upper) {
        if (upper > 0) {
            String input = getUserInput();
            try {
                int choice = Integer.parseInt(input);

                if ((choice > upper) || (choice < 1)) {
                    renderEngine.drawMessage("Out of selection range!");
                    return getNumberChoice(upper);
                } else {
                    return choice;
                }
            } catch (NumberFormatException e) {
                renderEngine.drawMessage("Please use and integer!");
                return getNumberChoice(upper);
            }
        } else {
            renderEngine.drawMessage("Error! upper needs to be greater than 0");
            System.exit(1);
            return 0;
        }
    }

    // public int getNumberChoice(int upper);
    // public String getMovementInput();
    // public void wait
}
