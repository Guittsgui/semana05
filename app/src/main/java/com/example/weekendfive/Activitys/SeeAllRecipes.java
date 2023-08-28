package com.example.weekendfive.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.weekendfive.Adapters.RecipeAdapter;
import com.example.weekendfive.Models.Recipe;
import com.example.weekendfive.R;

import java.util.ArrayList;

public class SeeAllRecipes extends AppCompatActivity {

    ArrayList<Recipe> recipesList;

    TextView recipeCounter;

    RecyclerView recyclerViewRecipes;

    Button returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_recipes);

        recipesList = new ArrayList<>();
        recipesList = (ArrayList<Recipe>) getIntent().getSerializableExtra("list");

        binding();

        recipeCounter.setText("Total de Receitas: " + recipesList.size());
        returnButton.setOnClickListener(handleReturnToMenuView());

        RecipeAdapter adapter = new RecipeAdapter(recipesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewRecipes.setLayoutManager(layoutManager);
        recyclerViewRecipes.setHasFixedSize(true);
        recyclerViewRecipes.setAdapter(adapter);

        


    }

    private View.OnClickListener handleReturnToMenuView() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
    }

    private void binding() {
        recipeCounter = findViewById(R.id.allRecipesCounterTV);
        returnButton = findViewById(R.id.returnButton);
        recyclerViewRecipes = findViewById(R.id.recipesRecyclerView);

    }
}