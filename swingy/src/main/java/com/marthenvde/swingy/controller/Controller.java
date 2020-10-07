package com.marthenvde.swingy.controller;

public interface Controller {
    public String getInputName();
    public String getYesNo();
    public int getNumberChoice(int upper);
    public String getMovementInput();
    abstract String getUserInput();
}
