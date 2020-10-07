package com.marthenvde.swingy.controller;

import com.marthenvde.swingy.view.GuiView;
import com.marthenvde.swingy.view.Renderer;

public class GuiInputController extends InputContoller {
    public String getUserInput() {
        synchronized(GuiView.submitBtn) {
            try {
                GuiView.submitBtn.wait();
            } catch (InterruptedException e){
                System.err.println("Button press interrupted");
            }
            String inputText = GuiView.inputField.getText();
            GuiView.inputField.setText("");
            return inputText;
        }
    }

    public GuiInputController(Renderer renderEngine) {
        super(renderEngine);
    }
}
