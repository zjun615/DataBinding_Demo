package com.zjun.databinding.demo.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zjun.databinding.demo.R;

/**
 * File Name    : DBUtils
 * Description  :
 * Author       : Ralap
 * Create Date  : 2016/11/16
 * Version      : v1
 */
public class DBUtils {
    /**
     * 使用DataBinding来加载图片
     * 使用@BindingAdapter注解，注解值（这里的imageUrl）可任取，注解值将成为自定义属性
     * 此自定义属性可在xml布局文件中使用，自定义属性的值就是这里定义String类型url
     * 《说明》：
     * 1. 方法名可与注解名一样，也可不一样
     * 2. 第一个参数必须是View，就是自定义属性所在的View
     * 3. 第二个参数就是自定义属性的值，与注解值对应。据说这是数组，可多个，但没测试成功
     * 这里需要INTERNET权限，别忘了
     *
     * @param imageView     ImageView控件
     * @param url           图片网络地址
     */
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (url == null) {
            imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(imageView.getContext()).load(url).into(imageView);
        }
    }
}
