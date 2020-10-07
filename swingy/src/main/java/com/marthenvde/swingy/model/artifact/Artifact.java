package com.marthenvde.swingy.model.artifact;

import javax.validation.constraints.Min;
public abstract class Artifact {

    @Min(value = 0, message = "Power can't be less than 0")
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
