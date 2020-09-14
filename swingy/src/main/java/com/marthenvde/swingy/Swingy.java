package com.marthenvde.swingy;

public class Swingy 
{
    public static void main( String[] args )
    {
        if (args.length >= 1) {
            if ((args[0].toLowerCase()).equals("console") || (args[0].toLowerCase()).equals("gui")) {
                if ((args[0].toLowerCase()).equals("console")) {
                    System.out.println("Loading console view");
                } else {
                    System.out.println("Loading gui view");
                }
            } else {
                System.err.println("Invalid launch option");
            }
        } else {
            System.err.println("Missing launch mode!");
        }
    }
}
