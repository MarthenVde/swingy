package com.marthenvde.swingy.model.characters;

import java.util.Random;

import com.marthenvde.swingy.model.artifact.Armor;
import com.marthenvde.swingy.model.artifact.Artifact;
import com.marthenvde.swingy.model.artifact.Helmet;
import com.marthenvde.swingy.model.artifact.Weapon;

public class Enemy extends Character {
    public Enemy(String name, int attack, int defense, int hp, String charClass) {
        super(name, attack, defense, hp, charClass);
    }

    public static Artifact generateArtifact() {
        int power = (new Random().nextInt(20));
        int randArtifact = new Random().nextInt(6);

        if (randArtifact == 1) {
            return new Weapon(power);
        } else if (randArtifact == 2) {
            return new Helmet(power);
        } else if (randArtifact == 3) {
            return new Armor(power);
        } else {
            return null;
        }
    }
}
