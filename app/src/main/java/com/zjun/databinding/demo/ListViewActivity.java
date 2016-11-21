package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zjun.databinding.demo.adapter.CommonAdapter;
import com.zjun.databinding.demo.bean.User;
import com.zjun.databinding.demo.databinding.ActivityListViewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * ListView展示
 */
public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_view);

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            // 3个网络图片1个本地图片，依次循环
            User user = new User("user" + i, (i & 0x03) < 3 ? "http://avatar.csdn.net/4/9/8/1_a10615.jpg" : null);
            list.add(user);
        }

        // 创建Adapter。BR类似与R文件，存储变量名称
        CommonAdapter adapter = new CommonAdapter<>(this, list, R.layout.item_list_view, BR.user);
        binding.setLvAdapter(adapter);
    }
}
