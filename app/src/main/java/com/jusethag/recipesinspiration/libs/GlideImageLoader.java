package com.jusethag.recipesinspiration.libs;

import android.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jusethag.recipesinspiration.libs.base.ImageLoader;

/**
 * Created by JusethAg on 8/13/16.
 */

public class GlideImageLoader implements ImageLoader {

    private RequestManager requestManager;

    public void setLoaderContext(Fragment fragment) {
        this.requestManager = Glide.with(fragment);
    }

    @Override
    public void load(ImageView imageView, String url) {
        requestManager
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }
}
