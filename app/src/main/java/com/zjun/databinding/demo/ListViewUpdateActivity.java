package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zjun.databinding.demo.adapter.CommonAdapter;
import com.zjun.databinding.demo.bean.Member;
import com.zjun.databinding.demo.bean.User;
import com.zjun.databinding.demo.databinding.ActivityListViewBinding;
import com.zjun.databinding.demo.databinding.ActivityListViewUpdateBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * ListView条目更新
 */
public class ListViewUpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityListViewUpdateBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_view_update);

        List<Member> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            // 3个网络图片1个本地图片，依次循环
            Member member = new Member("user" + i, (i & 0x03) < 3 ? "http://avatar.csdn.net/4/9/8/1_a10615.jpg" : null);
            list.add(member);
        }

        // 创建Adapter。BR类似与R文件，存储变量名称
        CommonAdapter adapter = new CommonAdapter<>(this, list, R.layout.item_list_view_update, BR.member);
        binding.setLvAdapter(adapter);
    }
}
