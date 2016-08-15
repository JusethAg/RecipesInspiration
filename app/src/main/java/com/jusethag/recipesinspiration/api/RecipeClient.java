package com.jusethag.recipesinspiration.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JusethAg on 8/15/16.
 */

public class RecipeClient {
    private final static String BASE_URL = "http://food2fork.com/api/";
    private Retrofit retrofit;

    public RecipeClient() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RecipeService getRecipeService() {
        return retrofit.create(RecipeService.class);
    }
}
