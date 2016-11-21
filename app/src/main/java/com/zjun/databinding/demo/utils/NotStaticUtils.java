package com.zjun.databinding.demo.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zjun.databinding.demo.R;

/**
 * File Name    : NotStaticUtils
 * Description  :
 * Author       : Ralap
 * Create Date  : 2016/11/18
 * Version      : v1
 */
public class NotStaticUtils {
    @BindingAdapter({"imgSrc"})
    public void showImg(ImageView imageView, String src) {
        if (src == null) {
            imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(imageView.getContext()).load(src).into(imageView);
        }
    }
}
