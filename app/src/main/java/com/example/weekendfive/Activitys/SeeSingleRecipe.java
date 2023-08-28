package com.example.weekendfive.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.weekendfive.Models.Recipe;
import com.example.weekendfive.R;

public class SeeSingleRecipe extends AppCompatActivity {

    TextView name ;
    Recipe recipe;

    Button finishBT;
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
    }

    private void binding() {
        name = findViewById(R.id.nameFinalField);
        finishBT = findViewById(R.id.finishButton);
    }
}