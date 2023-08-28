package com.example.weekendfive.Activitys;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        seeAllRecipesBT.setOnClickListener(handleShowAllRecipesView());

    }

    private View.OnClickListener handleShowAllRecipesView() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(recipesList.size() == 0){
                    Toast.makeText(getApplicationContext(), "Você não possui receitas",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), SeeAllRecipes.class);
                intent.putExtra("list" , recipesList);
                viewAllRecipes.launch(intent);
            }
        };
    }

    ActivityResultLauncher<Intent> viewAddNewRecipe = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 10){
                        Recipe newRecipe = (Recipe) result.getData().getSerializableExtra("recipe");
                        newRecipe.setId(recipesList.size() + 1);
                        newRecipe.setFavorite(false);
                        recipesList.add(newRecipe);
                        recipesCounterTV.setText("Total de Receitas: " + recipesList.size());
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> viewAllRecipes = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                }
            }
    );

    private View.OnClickListener handleShowAddNewRecipeView() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addNewRecipe.class);
                viewAddNewRecipe.launch(intent);
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