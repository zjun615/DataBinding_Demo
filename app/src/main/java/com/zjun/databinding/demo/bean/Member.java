package com.zjun.databinding.demo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

/**
 * File Name    :
 * Description  :
 * Author       : Ralap
 * Create Date  : 2016/11/8
 * Version      : v1
 */
// 1、继承BaseObservable
public class Member extends BaseObservable{
    private String name;
    private String icon;

    public Member(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    // 2、在属性值的Getter上添加@Bindable注解
    @Bindable
    public String getName() {
        return name;
    }

    // 3、在更新的地方添加属性更新通知方法：notifyPropertyChanged(filedId);
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.zjun.databinding.demo.BR.name);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void onItemClick(View view) {
        setName(name + "【已更新】");
    }
}
