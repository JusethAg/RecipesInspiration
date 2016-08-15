package com.jusethag.recipesinspiration.api;

import com.jusethag.recipesinspiration.entities.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by JusethAg on 8/15/16.
 */

public interface RecipeService {

    @GET("search")
    Call<RecipeSearchResponse> search(
            @Query("key") String key,
            @Query("sort") String sort,
            @Query("count") int count,
            @Query("page") int page);
}
