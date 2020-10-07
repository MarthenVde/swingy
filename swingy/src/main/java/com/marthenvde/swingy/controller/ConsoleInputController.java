package com.marthenvde.swingy.controller;

import java.io.Console;
import com.marthenvde.swingy.view.Renderer;
public class ConsoleInputController extends InputContoller {
    public String getUserInput() {
        Console console = System.console();
        String response = console.readLine();

        return response;
    }

    public ConsoleInputController(Renderer renderEngine) {
        super(renderEngine);
    }
}
