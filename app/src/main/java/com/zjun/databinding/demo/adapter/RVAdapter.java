package com.zjun.databinding.demo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjun.databinding.demo.BR;
import com.zjun.databinding.demo.R;
import com.zjun.databinding.demo.bean.Member;
import com.zjun.databinding.demo.databinding.ItemRecyclerViewBinding;

import java.util.List;

/**
 * File Name    : RVAdapter
 * Description  :
 * Author       : Ralap
 * Create Date  : 2016/11/19
 * Version      : v1
 */

/**
 * 法一：官方的
 */
//public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVHolder> {
//
//    private Context mContext;
//    private List<Member> mDataList;
//
//    public RVAdapter(Context context, List<Member> list) {
//        this.mContext = context;
//        this.mDataList = list;
//    }
//
//    @Override
//
//    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return RVHolder.create(LayoutInflater.from(mContext), parent);
//    }
//
//    @Override
//    public void onBindViewHolder(RVHolder holder, int position) {
//        holder.bindTo(mDataList.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDataList == null ? 0 : mDataList.size();
//    }
//
//    static class RVHolder extends RecyclerView.ViewHolder {
//        // 创建一个静态获取方法
//        static RVHolder create(LayoutInflater inflater, ViewGroup parent) {
//            ItemRecyclerViewBinding binding = ItemRecyclerViewBinding.inflate(inflater, parent, false);
//            return new RVHolder(binding);
//        }
//
//        ItemRecyclerViewBinding mBinding;
//
//        private RVHolder(ItemRecyclerViewBinding binding) {
//            super(binding.getRoot());
//            this.mBinding = binding;
//        }
//
//        void bindTo(Member member) {
//            mBinding.setMember(member);
//            // 它使数据绑定刷新所有挂起的更改。这官方的解释好难懂，其实功能就是让数据立即展示在布局上
//            mBinding.executePendingBindings();
//        }
//    }
//}


/**
 * 法二：通用型
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVHolder> {
    private Context mContext;
    private List<Member> mDataList;
    private int mLayoutId;      // 条目布局文件ID
    private int mVariableId;    // DataBinding变量ID

    public RVAdapter(Context context, List<Member> list, int layoutId, int variableId) {
        this.mContext = context;
        this.mDataList = list;
        this.mLayoutId = layoutId;
        mVariableId = variableId;
    }

    @Override

    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), mLayoutId, parent, false);
        RVHolder holder = new RVHolder(binding.getRoot());
        holder.binding = binding;
        return holder;
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        holder.binding.setVariable(mVariableId, mDataList.get(position));
        // 别忘记这句代码
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 :mDataList.size();
    }

    class RVHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        RVHolder(View view) {
            super(view);
        }
    }
}
