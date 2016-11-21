package com.zjun.databinding.demo.utils;

import android.databinding.DataBindingComponent;

/**
 * File Name    : MyComponent
 * Description  :
 * Author       : Ralap
 * Create Date  : 2016/11/18
 * Version      : v1
 */
public class MyComponent implements DataBindingComponent{
    private NotStaticUtils utils;

    @Override
    public NotStaticUtils getNotStaticUtils() {
        if (utils == null) {
            utils = new NotStaticUtils();
        }
        return utils;
    }
}
