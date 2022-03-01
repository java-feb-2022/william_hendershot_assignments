package com.codingdojo.ninja_gold_game.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import com.codingdojo.ninja_gold_game.game.commands.Visit;
import com.codingdojo.ninja_gold_game.game.commands.VisitCave;
import com.codingdojo.ninja_gold_game.game.commands.VisitFarm;
import com.codingdojo.ninja_gold_game.game.commands.VisitNull;

public class VisitFactory {
    
    HashMap<String, Visit> availableCommands = new HashMap<String, Visit>();

    public VisitFactory() {
        availableCommands.put("cave", new VisitCave());
        availableCommands.put("farm", new VisitFarm());
    }

    public Visit getVisit(String visitType) {
        
        if (availableCommands.containsKey(visitType.toLowerCase())){
            Constructor<?> constructor;
            try {
                constructor = availableCommands.get(visitType.toLowerCase()).getClass().getConstructor();
                System.out.printf("My memlocation is in factory at: %s%n", availableCommands.get(visitType.toLowerCase()));
                try {
                    return (Visit) constructor.newInstance();
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return new VisitNull();
    }

    //Filling a runtime level call to pull all classes from a given package root.
    //Only compiled once at the start of a JVM run?
    //Example from https://www.baeldung.com/java-find-all-classes-in-package
    public void getCommandNames() {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("com.codingdojo.ninja_gold_game.game.commands".replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        
        try{
            String line;
            while ((line = reader.readLine()) != null ) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
