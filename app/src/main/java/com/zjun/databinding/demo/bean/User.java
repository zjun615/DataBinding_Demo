package com.zjun.databinding.demo.bean;

import android.view.View;
import android.widget.Toast;

/**
 * File Name    :
 * Description  :
 * Author       : Ralap
 * Create Date  : 2016/11/8
 * Version      : v1
 */
public class User{
    String name;
    String nickname;
    boolean isMale;
    int age;
    String icon;

    public User(String name, String nickname, boolean isMale, int age) {
        this.name = name;
        this.nickname = nickname;
        this.isMale = isMale;
        this.age = age;
    }

    public User(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void onNameClick(View view) {
        Toast.makeText(view.getContext(), name + " is Clicked", Toast.LENGTH_SHORT).show();
    }

    public boolean onNicknameLongClick(View view) {
        Toast.makeText(view.getContext(), nickname + " is long Clicked", Toast.LENGTH_SHORT).show();
        return true;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return String.format("%s{%s, %s, %d}", name, nickname, isMale ? "male" : "female", age);
    }
}
