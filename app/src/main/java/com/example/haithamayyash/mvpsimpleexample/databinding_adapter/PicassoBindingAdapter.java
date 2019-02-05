package com.example.haithamayyash.mvpsimpleexample.databinding_adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoBindingAdapter {
    @BindingAdapter("imageResourse")
    public static void setImageResource(ImageView view, String res) {
        Picasso.get().load(res).into(view);
    }
}
