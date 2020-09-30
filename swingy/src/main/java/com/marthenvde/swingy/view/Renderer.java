package com.marthenvde.swingy.view;

import com.marthenvde.swingy.model.Map;
import java.util.ArrayList;
import com.marthenvde.swingy.model.characters.Hero;
public interface Renderer {
    public void drawTile(boolean visited);
    public void drawMap(Map map);
    public void drawPlayer();
    public void drawMonster();
    public void drawSelectionSceen(ArrayList<Hero> heroes);
    public void drawCharacterOptionScreen();
    public void drawStartup();
    public void drawEndScreen(boolean won);
    public void drawCharacterCreationScreen();
}
