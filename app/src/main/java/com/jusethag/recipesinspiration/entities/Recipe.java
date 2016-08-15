package com.jusethag.recipesinspiration.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JusethAg on 8/15/16.
 */



public class Recipe {

    private String id;
    private String title;
    @SerializedName("image_url")
    private String imageUrl;
    private boolean favorite;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
