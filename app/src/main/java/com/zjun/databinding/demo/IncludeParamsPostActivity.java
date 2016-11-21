package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zjun.databinding.demo.bean.User;
import com.zjun.databinding.demo.databinding.ActivityIncludeParamsPostBinding;

/**
 * Databinding在include布局传递参数
 */
public class IncludeParamsPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityIncludeParamsPostBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include_params_post);
        User user = new User("郭靖", "", true, 18);
        binding.setUser(user);
    }
}
