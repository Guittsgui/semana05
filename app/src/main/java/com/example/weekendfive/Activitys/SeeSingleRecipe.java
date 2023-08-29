package com.example.weekendfive.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weekendfive.Models.Recipe;
import com.example.weekendfive.R;

import java.util.ArrayList;

public class SeeSingleRecipe extends AppCompatActivity {

    TextView name, isFavorite, prepareMode, ingredients;
    Recipe recipe;

    ArrayList<Recipe> listRecipe;
    Button finishBT;

    ImageView star;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_single_recipe);
        recipe = (Recipe) getIntent().getSerializableExtra("recipe");
        listRecipe = new ArrayList<>();
        listRecipe = (ArrayList<Recipe>) getIntent().getSerializableExtra("list");
        binding();

        fillInfos();

        star.setOnClickListener(handleChangeFavorite());

        finishBT.setOnClickListener(handleFinishChanges());
    }

    private View.OnClickListener handleFinishChanges() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeListWithAlterRecipe();
                Intent intent = new Intent();
                intent.putExtra("list", listRecipe);
                setResult(10, intent);
                finish();
            }
        };
    }

    private void changeListWithAlterRecipe() {
        Integer count = 0;
        for ( int i = 0 ; i < listRecipe.size(); i++){
            if (recipe.getId().toString().equals(listRecipe.get(i).getId().toString())){
                listRecipe.get(i).setFavorite(recipe.getFavorite());
            }
        }
    }

    private View.OnClickListener handleChangeFavorite() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe.setFavorite(!recipe.getFavorite());
                if(recipe.getFavorite().equals(true)){
                    isFavorite.setText("Esta é uma receita favorita.");
                    star.setImageResource(R.drawable.truestar);
                }else{
                    isFavorite.setText("Esta não é uma receita favorita.");
                    star.setImageResource(R.drawable.falsestar);
                }
            }
        };
    }

    private void fillInfos() {

        name.setText(recipe.getName());

        if(recipe.getFavorite().equals(true)){
            isFavorite.setText("Esta é uma receita favorita.");
            star.setImageResource(R.drawable.truestar);
        }else{
            isFavorite.setText("Esta não é uma receita favorita.");
            star.setImageResource(R.drawable.falsestar);
        }


        prepareMode.setText(recipe.getHowToMake());
        ingredients.setText(recipe.getAllIngredients());
    }

    private void binding() {
        name = findViewById(R.id.nameFinalField);
        finishBT = findViewById(R.id.finishButton);
        isFavorite = findViewById(R.id.isfavoriteTVField);
        prepareMode = findViewById(R.id.prepareModeTV);
        ingredients = findViewById(R.id.ingredientsTVF);
        star = findViewById(R.id.finalStar);
    }
}