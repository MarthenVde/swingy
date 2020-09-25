package com.marthenvde.swingy.model;

import java.io.*;
import java.json.simple.*;
import com.marthenvde.swingy.model.characters.Hero;

public class Storage {
    private static FileWriter writer;

    public static void newStorage(String filename) {
        try {
            writer = new FileWriter(filename);
        } catch (Exception e) {
            System.err.println("Error! couldn't create file");
            System.exit(1);
        }
    }



    public static void addHero(Hero newHero) {
        
    }
}
