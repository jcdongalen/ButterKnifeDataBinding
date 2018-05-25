package com.example.johndongalen.myapplication.util;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

public class BindingUtils {

    @BindingAdapter("bind:color")
    public static void setAmount(TextView textView, int color) {
        if (textView.getText().equals("qwe 1")) {
            textView.setTextColor(color);
        } else {
            textView.setTextColor(Color.RED);
        }
    }

    @BindingAdapter("bind:icon")
    public static void setIcon(ImageView imageView, int icon){
    }
}
