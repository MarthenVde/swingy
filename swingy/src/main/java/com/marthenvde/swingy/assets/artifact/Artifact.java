package com.marthenvde.swingy.assets.artifact;

public abstract class Artifact {
    private String name;
    private int power;


    Artifact(int power, String name) {
        this.power = power;
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
