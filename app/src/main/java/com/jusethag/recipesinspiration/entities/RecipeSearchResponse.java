package com.jusethag.recipesinspiration.entities;



import java.util.List;

/**
 * Created by JusethAg on 8/15/16.
 */

public class RecipeSearchResponse {

    private int count;
    private List<Recipe> recipes;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Recipe getFirstRecipe() {
        Recipe firstRecipe = null;
        if (!recipes.isEmpty()) {
            firstRecipe = recipes.get(0);
        }

        return firstRecipe;
    }
}
