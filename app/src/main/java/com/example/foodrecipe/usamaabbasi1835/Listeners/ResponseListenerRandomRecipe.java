package com.example.foodrecipe.usamaabbasi1835.Listeners;

import com.example.foodrecipe.usamaabbasi1835.Models.RandomRecipeApiResponse;

public interface ResponseListenerRandomRecipe {

    void didFetch(RandomRecipeApiResponse response, String message);
    void didError(String message);

}
