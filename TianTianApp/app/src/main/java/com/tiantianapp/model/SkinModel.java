package com.tiantianapp.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/12 0012.
 */

public class SkinModel implements Serializable {
    private Drawable icon;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    private String user_name;

    public boolean is_biaji() {
        return is_biaji;
    }

    public void setIs_biaji(boolean is_biaji) {
        this.is_biaji = is_biaji;
    }

    public boolean is_biaji;
}
