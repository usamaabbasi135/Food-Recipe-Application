package com.example.foodrecipe.usamaabbasi1835;

import android.content.Context;

import com.example.foodrecipe.usamaabbasi1835.Listeners.ResponseListenerRandomRecipe;
import com.example.foodrecipe.usamaabbasi1835.Models.RandomRecipeApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManagerAPI {
    //Creating a retrofit object and context object

    Context context;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.spoonacular.com")
            .addConverterFactory(GsonConverterFactory.create()).build();

    //Creating the constructor for the RequestManagerAPI Class


    public RequestManagerAPI(Context context) {
        this.context = context;
    }

    public void getRandomRecipes(ResponseListenerRandomRecipe listener, List<String> tags){
        RandomRecipeCalls randomRecipeCalls = retrofit.create(RandomRecipeCalls.class);
        Call<RandomRecipeApiResponse> callToRandomRecipe = randomRecipeCalls
                .callRandomRecipeApi(context.getString(R.string.api_key),"10", tags);
        callToRandomRecipe.enqueue(new Callback<RandomRecipeApiResponse>() {
            @Override
            public void onResponse(Call<RandomRecipeApiResponse> call, Response<RandomRecipeApiResponse> response) {
                if(!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(Call<RandomRecipeApiResponse> call, Throwable t) {

                listener.didError(t.getMessage());
            }
        });
    }
    private interface RandomRecipeCalls{
           @GET("/recipes/random")
        Call<RandomRecipeApiResponse> callRandomRecipeApi(
                @Query("apiKey") String apiKey,
                @Query("number") String number,
                @Query("tags")   List<String> tags);
    }
}
