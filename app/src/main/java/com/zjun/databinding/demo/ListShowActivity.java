package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zjun.databinding.demo.bean.User;
import com.zjun.databinding.demo.databinding.ActivityListShowBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * List展示
 */
public class ListShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListShowBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_show);
        List<User> userList = new ArrayList<>();
        userList.add(new User("黄药师", "东邪", true, 30));
        userList.add(new User("欧阳锋", "西毒", true, 33));
        binding.setUserList(userList);

        initData();

    }

    private void initView() {

    }

    private void initData() {

    }
}
