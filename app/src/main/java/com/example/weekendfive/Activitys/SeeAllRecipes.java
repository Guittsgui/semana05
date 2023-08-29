package com.example.weekendfive.Activitys;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        RecipeAdapter adapter = new RecipeAdapter(recipesList, viewSingleRecipe);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewRecipes.setLayoutManager(layoutManager);
        recyclerViewRecipes.setHasFixedSize(true);
        recyclerViewRecipes.setAdapter(adapter);

    }

    ActivityResultLauncher<Intent> viewSingleRecipe = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    ArrayList<Recipe> returnedList = new ArrayList<>();
                    returnedList = (ArrayList<Recipe>) result.getData().getSerializableExtra("list");
                    recipesList = returnedList;
                    RecipeAdapter adapter = new RecipeAdapter(recipesList, viewSingleRecipe);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerViewRecipes.setLayoutManager(layoutManager);
                    recyclerViewRecipes.setHasFixedSize(true);
                    recyclerViewRecipes.setAdapter(adapter);
                }
            }
    );



    private View.OnClickListener handleReturnToMenuView() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("list", recipesList);
                setResult(10, intent);
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