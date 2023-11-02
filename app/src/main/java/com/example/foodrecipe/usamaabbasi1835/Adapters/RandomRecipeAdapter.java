package com.example.foodrecipe.usamaabbasi1835.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrecipe.usamaabbasi1835.Models.Recipe;
import com.example.foodrecipe.usamaabbasi1835.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder> {

    Context context;
    List<Recipe> recipeList;

    public RandomRecipeAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.random_recipe_list, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {

        //Getting the title from recipeList
        holder.title_text_view.setText(recipeList.get(position).title);
        holder.title_text_view.setSelected(true);

        //Getting the likes from recipe list
        holder.textView_likes.setText(recipeList.get(position).aggregateLikes +" Likes");

        //Getting the servings from recipe list
        holder.textView_servings.setText(recipeList.get(position).servings +" Servings");

        //Getting the time from recipe list
        holder.textView_time.setText(recipeList.get(position).readyInMinutes + " Minutes");

        //Getting the image of the recipe list using picasso
        Picasso.get().load(recipeList.get(position).image).into(holder.recipe_imageView);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}

class RandomRecipeViewHolder extends RecyclerView.ViewHolder {

    CardView random_list_container;
    TextView title_text_view, textView_servings, textView_likes, textView_time;
    ImageView recipe_imageView;



    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        random_list_container = itemView.findViewById(R.id.random_list_container);
        title_text_view = itemView.findViewById(R.id.title_text_view);
        textView_servings = itemView.findViewById(R.id.textView_servings);
        textView_likes = itemView.findViewById(R.id.textView_likes);
        textView_time = itemView.findViewById(R.id.textView_time);
        recipe_imageView = itemView.findViewById(R.id.recipe_imageView);

    }
}