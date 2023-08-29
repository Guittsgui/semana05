package com.example.weekendfive.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {

    String name, howToMake;
    ArrayList<String> ingredientList;
    Integer id;

    Boolean isFavorite;

    public Recipe(String name, String howToMake,ArrayList<String> ingredientList){
        this.name = name;
        this.howToMake = howToMake;
        this.ingredientList = ingredientList;
    }

    public Recipe(String name, String howToMake, ArrayList<String> ingredient, Integer id, Boolean isFavorite) {
        this.name = name;
        this.howToMake = howToMake;
        this.ingredientList = ingredient;
        this.id = id;
        this.isFavorite = isFavorite;
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
        return ingredientList;
    }

    public void setIngredient(ArrayList<String> ingredient) {
        this.ingredientList = ingredient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public String getAllIngredients(){
        String allIngreds = "";
        Integer count = 1;

        for (String ingred : this.ingredientList){
            allIngreds +=  count + " º ingrediente: " + ingred + " ";
            count++;
        }

        return allIngreds;
    }
}
