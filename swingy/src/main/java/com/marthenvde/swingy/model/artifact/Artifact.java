package com.marthenvde.swingy.model.artifact;

public abstract class Artifact {
    private int power;

    Artifact(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
