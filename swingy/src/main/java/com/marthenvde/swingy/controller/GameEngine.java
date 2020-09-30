package com.marthenvde.swingy.controller;

import com.marthenvde.swingy.model.characters.Hero;
import com.marthenvde.swingy.view.Renderer;
import com.marthenvde.swingy.model.Map;

public class GameEngine {
    private final int MAX_LEVEL = 7;
    private Map map;
    private Renderer renderer;
    private Hero player;


    public GameEngine(Renderer renderEngine) {
        this.renderer = renderEngine;
        // TODO: Set controller


        // TODO: Get new player

        // TODO: Setup map

    }

    private Hero loadPlayer() {
        this.renderer.drawSelectionSceen();
        return null;
    }

    public void initWorld(Hero player) {
        
    }

    public void initializeGame() {
        System.out.println("Building");
    }

    // event hanler
    // movement controller
}  