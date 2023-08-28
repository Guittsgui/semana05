package com.example.weekendfive.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weekendfive.Activitys.SeeSingleRecipe;
import com.example.weekendfive.Models.Recipe;
import com.example.weekendfive.R;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    ArrayList<Recipe> recipeList;
    public RecipeAdapter(ArrayList<Recipe> recipeList){
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlerecipelayout, parent, false);
        return new ViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recipeName.setText(recipeList.get(position).getName().toString());

        holder.isFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.seeRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SeeSingleRecipe.class);
                Recipe recipe = recipeList.get(holder.getAdapterPosition());
                intent.putExtra("recipe",recipe);
                view.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView recipeName;
        ImageView isFavorite;
        Button seeRecipe;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            recipeName = itemView.findViewById(R.id.nameFieldTV);
            isFavorite = itemView.findViewById(R.id.isFavoriteField);
            seeRecipe = itemView.findViewById(R.id.seeMoreButton);
        }
    }
}
