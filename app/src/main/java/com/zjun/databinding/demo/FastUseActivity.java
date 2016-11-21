package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zjun.databinding.demo.bean.User;
import com.zjun.databinding.demo.databinding.ActivityFastUseBinding;

/**
 * Databinding快速使用
 */
public class FastUseActivity extends AppCompatActivity {

    private ActivityFastUseBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 换掉setContentView()
//        setContentView(R.layout.activity_fast_use);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_fast_use);

        initView();
    }

    private void initView() {
        findViewById(R.id.btn_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User("张君宝", "张三丰", true, 30);
                mBinding.setUser(user);
            }
        });

        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User("黄蓉", "蓉儿", false, 12);
                mBinding.setUser(user);
            }
        });
    }


}
