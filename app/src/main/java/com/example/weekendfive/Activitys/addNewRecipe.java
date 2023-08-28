package com.example.weekendfive.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.weekendfive.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class addNewRecipe extends AppCompatActivity {

    TextInputLayout recipeName, ingredientName, howToDo;
    Button saveRecipe, saveIngredient;
    ArrayList<String> ingredientList;

    TextView ingredientCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);
        ingredientList = new ArrayList<>();

        binding();
        ingredientCounter.setText("Total de Ingredientes: " + ingredientList.size());
    }

    private void binding() {
        saveIngredient = findViewById(R.id.saveIngredientButton);
        saveRecipe = findViewById(R.id.saveRecipeButton);

        recipeName = findViewById(R.id.recipeNameTIL);
        ingredientName = findViewById(R.id.ingredientNameTIL);
        howToDo = findViewById(R.id.howToDoTIL);

        ingredientCounter = findViewById(R.id.ingredientCounter);
    }
}