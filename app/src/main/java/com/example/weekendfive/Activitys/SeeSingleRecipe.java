package com.example.weekendfive.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weekendfive.Models.Recipe;
import com.example.weekendfive.R;

public class SeeSingleRecipe extends AppCompatActivity {

    TextView name, isFavorite, prepareMode, ingredients;
    Recipe recipe;
    Button finishBT;

    ImageView star;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_single_recipe);
        recipe = (Recipe) getIntent().getSerializableExtra("recipe");
        binding();

        fillInfos();

        finishBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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