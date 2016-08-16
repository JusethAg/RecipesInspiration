package com.jusethag.recipesinspiration.main.events;

import com.jusethag.recipesinspiration.entities.Recipe;

/**
 * Created by JusethAg on 8/15/16.
 */

public class RecipeMainEvent {
    public final static int NEXT_EVENT = 0;

    private int type;
    private String error;
    private Recipe recipe;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
