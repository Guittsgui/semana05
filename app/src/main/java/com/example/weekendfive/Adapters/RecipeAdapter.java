package com.example.weekendfive.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weekendfive.Activitys.SeeSingleRecipe;
import com.example.weekendfive.Models.Recipe;
import com.example.weekendfive.R;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    ArrayList<Recipe> recipeList;

    ActivityResultLauncher<Intent> viewSingleRecipe;
    public RecipeAdapter(ArrayList<Recipe> recipeList, ActivityResultLauncher<Intent> viewSingleRecipe){
        this.recipeList = recipeList;
        this.viewSingleRecipe = viewSingleRecipe;
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
        Recipe r = recipeList.get(position);

        holder.recipeName.setText(recipeList.get(position).getName().toString());

        if(r.getFavorite().equals(true)){
            holder.isFavorite.setImageResource(R.drawable.truestar);
        }else{
            holder.isFavorite.setImageResource(R.drawable.falsestar);
        }


        holder.isFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r.getFavorite().equals(false)){
                    r.setFavorite(true);
                    holder.isFavorite.setImageResource(R.drawable.truestar);
                }else{
                    r.setFavorite(false);
                    holder.isFavorite.setImageResource(R.drawable.falsestar);
                }
            }
        });

        holder.seeRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SeeSingleRecipe.class);
                Recipe recipe = recipeList.get(holder.getAdapterPosition());
                intent.putExtra("recipe",recipe);
                intent.putExtra("list", recipeList);
                viewSingleRecipe.launch(intent);
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
