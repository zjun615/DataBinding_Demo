package com.zjun.databinding.demo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjun.databinding.demo.databinding.FragmentShowBinding;


public class ShowFragment extends Fragment {

    private FragmentShowBinding mBinding;

    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show, container, false);
        // 或，在这里获取DataBinding
//        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_show, container, false);
//        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 绑定View
        mBinding = DataBindingUtil.bind(view);
        mBinding.setProvince("浙江");
        mBinding.setCity("宁波");

        // 或，获取父类ViewDataBinding，然后通过设置变量的方法
//        ViewDataBinding binding = DataBindingUtil.bind(view);
//        binding.setVariable(BR.province, "江西");
//        binding.setVariable(BR.city, "赣州");
//
    }
}
