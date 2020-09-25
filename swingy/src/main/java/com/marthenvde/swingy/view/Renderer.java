package com.marthenvde.swingy.view;

import com.marthenvde.swingy.model.Map;
public interface Renderer {
    public void drawTile(boolean visited);
    public void drawMap(Map map);
    public void drawPlayer();
    public void drawMonster();
	public void drawSelectionSceen();
}
