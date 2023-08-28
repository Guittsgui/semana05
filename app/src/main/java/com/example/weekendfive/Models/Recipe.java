package com.example.weekendfive.Models;

import java.util.ArrayList;

public class Recipe {

    String name, howToMake;
    ArrayList<String> ingredient;

    Integer id;

    public Recipe(String name, String howToMake,Integer id) {
        this.name = name;
        this.howToMake = howToMake;
        this.id = id;
    }

    public Recipe(String name, String howToMake, ArrayList<String> ingredient, Integer id) {
        this.name = name;
        this.howToMake = howToMake;
        this.ingredient = ingredient;
        this.id = id;
    }

    public Recipe(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHowToMake() {
        return howToMake;
    }

    public void setHowToMake(String howToMake) {
        this.howToMake = howToMake;
    }

    public ArrayList<String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(ArrayList<String> ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
