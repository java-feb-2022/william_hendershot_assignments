package com.codingdojo.ninja_gold_game.game.commands;

public class VisitFarm extends Visit{
    
    private final int MIN_GOLD = 10;
    private final int MAX_GOLD = 20;

    private int result_gold;
    private String result_string;

    public VisitFarm() {

    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        this.result_string = "I visted a farm and only found 10-20 gold.";
        System.out.println(this.result_string);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Farm";
    }

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return this.result_string;
    }

}
