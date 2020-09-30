package com.marthenvde.swingy.controller;

import java.io.Console;
import java.text.ParseException;
public class ConsoleInputController implements InputContoller {
    public String getInputName() {
        System.out.println("Please input a Hero name:");
        Console console = System.console();
        String response = console.readLine();

        return response;
    }

    public String getYesNo() {
        Console console = System.console();
        String response = console.readLine();
        
        if ((response.toLowerCase().equals("n")) || (response.toLowerCase().equals("y"))) {
            return response.toLowerCase();
        } else {
            System.out.println("Incorrect use - (Y/N)");
            return getYesNo();
        }
    }
    
    public int getNumberChoice(int upper) {
        if (upper > 0) {
            String input = System.console().readLine();
            try {
                int choice = Integer.parseInt(input);

                if ((choice > upper) || (choice < 1)) {
                    System.out.println("Out of selection range!");
                    return getNumberChoice(upper);
                } else {
                    return choice;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please use and integer!");
                return getNumberChoice(upper);
            }
        } else {
            System.err.println("Error! upper needs to be greater than 0");
            System.exit(1);
            return 0;
        }
    }
}
