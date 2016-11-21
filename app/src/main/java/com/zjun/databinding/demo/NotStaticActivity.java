package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zjun.databinding.demo.databinding.ActivityNotStaticBinding;
import com.zjun.databinding.demo.utils.MyComponent;

/**
 * 非static方法
 */
public class NotStaticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置默认的组件
//        DataBindingUtil.setDefaultComponent(new MyComponent());

//        ActivityNotStaticBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_not_static);
        ActivityNotStaticBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_not_static, new MyComponent());
        dataBinding.setSrc1("http://avatar.csdn.net/4/9/8/1_a10615.jpg");
        dataBinding.setSrc2(null);
    }
}
