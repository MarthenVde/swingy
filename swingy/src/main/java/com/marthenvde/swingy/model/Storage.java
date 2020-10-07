package com.marthenvde.swingy.model;

import java.io.*;
import java.util.ArrayList;
import com.marthenvde.swingy.model.characters.Hero;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

public class Storage {
    private static final String FILENAME = "Heroes.txt";
    private static Gson gson = new Gson();

    public static void updateHero(Hero hero) {
        int id = hero.getId();
        ArrayList<Hero> heroes = extractHeroes();
        boolean modified = false;

        if (heroes != null) {
            // Clear old file
            for (Hero tmpHero : heroes) {
                if (id == tmpHero.getId()) {
                    heroes.remove(tmpHero);
                    heroes.add(hero);
                    modified = true;
                    break;
                }
            }

            if (modified) {   
                try {
                    FileOutputStream writer = new FileOutputStream(FILENAME);
                    writer.write(("").getBytes());
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error! file not found");
                    System.exit(1);
                }
                
                for (Hero updatedHero : heroes) {
                    addHero(updatedHero);
                }
            }    
        } 
    }

    public static void addHero(Hero hero) {
        File saveFile = new File(FILENAME);
        if (saveFile.exists() == false) {
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                System.err.println("Error! could not create file");
            }
        }
        
        try {
            FileWriter saveFileWriter = new FileWriter(saveFile.getAbsoluteFile(), true);
            BufferedWriter bufferWriter = new BufferedWriter(saveFileWriter);
            String data = gson.toJson(hero);

            bufferWriter.write(data.toString() + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.err.println("Error! could not write to file: " + e.toString());
            System.exit(1);
        }
    }

    public static  ArrayList<Hero> extractHeroes() {
        File saveFile = new File(FILENAME);
        ArrayList<Hero> heroes = new ArrayList<>();

        if (!saveFile.exists()) {
            return null;
            // System.err.println("Error! file not found");
            // System.exit(1);
        }
        try {
            Reader reader = new InputStreamReader(new FileInputStream(saveFile), "UTF-8");
            JsonStreamParser jsp = new JsonStreamParser(reader);
            Hero hero;

            while (jsp.hasNext()) {
                JsonElement jElement = jsp.next();
                try {
                    hero = gson.fromJson(jElement, Hero.class);
                    System.out.print("HERO: " + hero.getName() + "\n");
                    heroes.add(hero);
                } catch (Exception e) {
                    System.err.println("Error! invalid save file");
                    System.exit(1);
                }
            }
            reader.close();
            return heroes;
        } catch (Exception e) {
            System.err.println("Error! could not load data from file: " + e.toString());
            System.exit(1);
        }
        return null;
    }
}
