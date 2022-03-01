package com.codingdojo.ninja_gold_game.game.commands;

public class VisitCave extends Visit{
    
    private final int MIN_GOLD = 5;
    private final int MAX_GOLD = 10;

    private int result_gold;
    private String result_string;

    public VisitCave() {

    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        this.result_string = "I visted a cave and only found 5-10 gold.";
        System.out.println(this.result_string);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Cave";
    }

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return this.result_string;
    }

}
