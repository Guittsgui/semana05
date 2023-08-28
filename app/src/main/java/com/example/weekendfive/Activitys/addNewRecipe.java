package com.example.weekendfive.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weekendfive.Models.Recipe;
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

        saveIngredient.setOnClickListener(handleSaveIngredient());

        saveRecipe.setOnClickListener(handleSaveRecipe());
    }

    private View.OnClickListener handleSaveRecipe() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (recipeName.getEditText().getText().toString().equals("")){
                    recipeName.setError(" Informe o nome da Receita");
                    return;
                }else{
                    recipeName.setError(null);
                }
                if(ingredientList.size() == 0){
                    ingredientName.setError("Adicione ao menos um Ingrediente");
                    return;
                }else{
                    ingredientName.setError(null);
                }

                if( howToDo.getEditText().getText().toString().equals("") ){
                    howToDo.setError("Informe como preparar a Receita");
                    return;
                }else{
                    howToDo.setError(null);
                }

                String name = recipeName.getEditText().getText().toString();
                String prepare = howToDo.getEditText().getText().toString();
                Recipe recipe = new Recipe(name, prepare, ingredientList);

                Intent intent = new Intent();
                intent.putExtra("recipe" , recipe);
                setResult(10, intent);
                finish();
            }
        };
    }

    private View.OnClickListener handleSaveIngredient() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ingredientName.getEditText().getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "preencha o campo", Toast.LENGTH_LONG).show();
                    return;
                }
                String ingredient = ingredientName.getEditText().getText().toString();
                ingredientList.add(ingredient);
                ingredientCounter.setText("Total de Ingredientes: " + ingredientList.size());
                ingredientName.getEditText().setText("");
                Toast.makeText(getApplicationContext(), "Ingrediente adicionado com Sucesso", Toast.LENGTH_LONG).show();
                ingredientName.setError(null);
            }
        };
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