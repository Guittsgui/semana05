package com.example.weekendfive.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.weekendfive.Models.Recipe;
import com.example.weekendfive.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class menuActivity extends AppCompatActivity {


    ArrayList<Recipe> recipesList;
    TextView recipesCounterTV;

    Button addNewRecipeBT, seeAllRecipesBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recipesList = new ArrayList<>();

        fillRecipesList();
        binding();

        recipesCounterTV.setText("Total de Receitas: " + recipesList.size());

        addNewRecipeBT.setOnClickListener(handleShowAddNewRecipeView());

    }

    private View.OnClickListener handleShowAddNewRecipeView() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addNewRecipe.class);
                startActivity(intent);
            }
        };
    }

    private void binding() {
        recipesCounterTV = findViewById(R.id.recipeCounterTV);
        addNewRecipeBT = findViewById(R.id.addRecipeButton);
        seeAllRecipesBT = findViewById(R.id.seeAllRecipesButton);
    }

    private void fillRecipesList() {
    }
}