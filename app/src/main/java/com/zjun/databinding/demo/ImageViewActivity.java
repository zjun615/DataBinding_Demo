package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zjun.databinding.demo.R;
import com.zjun.databinding.demo.databinding.ActivityImageViewBinding;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityImageViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_image_view);
        binding.setImgUrl1("http://avatar.csdn.net/4/9/8/1_a10615.jpg");
        binding.setImgUrl2(null);
    }
}
