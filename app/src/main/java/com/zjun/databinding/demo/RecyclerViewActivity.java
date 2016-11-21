package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.zjun.databinding.demo.adapter.RVAdapter;
import com.zjun.databinding.demo.bean.Member;
import com.zjun.databinding.demo.bean.User;
import com.zjun.databinding.demo.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycler_view);

        ActivityRecyclerViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);

        // 模拟数据
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            // 1个网络图片1个本地图片，依次循环
            Member member = new Member("user" + i, (i & 0x01) == 0 ? "http://avatar.csdn.net/4/9/8/1_a10615.jpg" : null);
            list.add(member);
        }

        // 设置布局管理器，及适配器
        binding.setRvLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // 通用型
        binding.setRvAdapter(new RVAdapter(this, list, R.layout.item_recycler_view, BR.member));
        // 官方型
//        binding.setRvAdapter(new RVAdapter(this, list));


    }
}
