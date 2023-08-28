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

        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("leite");
        ingredients.add("ovo");
        ingredients.add("agua");
        Recipe recipe = new Recipe("Pudim de Leite", "Bater tudo no liquidificador", ingredients, 1, false);
        recipesList.add(recipe);

        ArrayList<String> ingredients1 = new ArrayList<>();
        ingredients1.add("farinha");
        ingredients1.add("trigo");
        ingredients1.add("agua");
        Recipe recipe1 = new Recipe("Pão Frances", "Bater tudo no liquidificador e fazer massinhas", ingredients1, 2, false);
        recipesList.add(recipe1);

        ArrayList<String> ingredients2 = new ArrayList<>();
        ingredients2.add("macarrao");
        ingredients2.add("queijo");
        ingredients2.add("tomate");
        ingredients2.add("Rucula");
        ingredients2.add("Pepino");
        ingredients2.add("Oregano");
        Recipe recipe2 = new Recipe("Macarrone Ao Cheff", "Colocar tudo no Forno por 1hora", ingredients2, 3, false);
        recipesList.add(recipe2);

        ArrayList<String> ingredients3 = new ArrayList<>();
        ingredients3.add("leite");
        ingredients3.add("whey protein");
        ingredients3.add("banana");
        ingredients3.add("pacoca");
        ingredients3.add("bcaa");
        ingredients3.add("durateston");
        Recipe recipe3 = new Recipe("Vitamina de Monstro", "Bater tudo e beber antes do treino.", ingredients3, 4, false);
        recipesList.add(recipe3);

        ArrayList<String> ingredients4 = new ArrayList<>();
        ingredients4.add("Cebola");
        ingredients4.add("Tomate ");
        ingredients4.add("Pimentao Verde");
        ingredients4.add("Pimentao Amarelo");
        ingredients4.add("Pimentao Albino");
        ingredients4.add("Vinagre");
        Recipe recipe4 = new Recipe("Vinagrete da Vó", "Deixar tudo bem misturado.", ingredients4, 5, false);
        recipesList.add(recipe4);

        ArrayList<String> ingredients5 = new ArrayList<>();
        ingredients5.add("Cafe");
        ingredients5.add("Coca Cola");
        ingredients5.add("Taurina");
        ingredients5.add("Potenay");
        ingredients5.add("bcaa");
        ingredients5.add("Creatina");
        Recipe recipe5 = new Recipe("Pré Treinão", "Bater tudo e beber antes do treino.", ingredients5, 6, false);
        recipesList.add(recipe5);

    }
}