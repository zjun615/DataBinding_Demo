package com.zjun.databinding.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.zjun.databinding.demo.others.DividerItemDecoration;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rv_content;

    private String[] mTopics = {
            "快速使用+监听事件",
            "include参数传递",
            "List集合显示",
            "ImageView加载图片",
            "ListView",
            "ListView Update更新数据",
            "非static方法加载图片",
            "Fragment中使用",
            "RecyclerView中使用"
    };

    private Class[] clazzes ={
            FastUseActivity.class,
            IncludeParamsPostActivity.class,
            ListShowActivity.class,
            ImageViewActivity.class,
            ListViewActivity.class,
            ListViewUpdateActivity.class,
            NotStaticActivity.class,
            FragmentShowActivity.class,
            RecyclerViewActivity.class,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1 先把原来的标题去掉，或在配置文件中把theme改为Theme.AppCompat.NoActionBar
        // 如果继承的是Activity，应使用requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        initToolBar();

        initView();
        initData();
    }


    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        toolbar = $(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        // ContextCompat.getDrawable()会自动根据系统版本来获取图片资源
        toolbar.setLogo(ContextCompat.getDrawable(this, R.mipmap.home_bg));
        toolbar.setTitle(getResources().getString(R.string.recyclerViewType));

        // 设置为ActionBar方式
        setSupportActionBar(toolbar);

    }

    private void initView() {
        rv_content = $(R.id.rv_content);


        // RecyclerView
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        rv_content.setAdapter(new MainRVAdapter());
        rv_content.setItemAnimator(new DefaultItemAnimator());
        rv_content.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void initData() {

    }


    class MainRVAdapter extends RecyclerView.Adapter<MainRVAdapter.RvHolder>{

        @Override
        public MainRVAdapter.RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(MainActivity.this);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 80);
            textView.setLayoutParams(params);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundResource(R.drawable.selector_rv_item);

            return new RvHolder(textView);
        }

        @Override
        public void onBindViewHolder(MainRVAdapter.RvHolder holder, int position) {
            holder.textView.setText(mTopics[position]);
            final int index = position;
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoActivity(index);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mTopics.length;
        }

        class RvHolder extends RecyclerView.ViewHolder{
            TextView textView;

            RvHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }
        }
    }

    /**
     * 跳转页面
     * @param position 页面位置
     */
    private void gotoActivity(int position) {
        startActivity(new Intent(this, clazzes[position]));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_hor_list_view:
                Toast.makeText(MainActivity.this, "hor_list_view", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_update:  // 版本更新
                checkUpdate();
                return true;
            default:  return super.onOptionsItemSelected(item);
        }

    }

    /**
     * 检查版本更新
     */
    private void checkUpdate() {
        // TODO 从网络上获取

    }

    private <V extends View> V $(int id) {
        return (V) findViewById(id);
    }
}
