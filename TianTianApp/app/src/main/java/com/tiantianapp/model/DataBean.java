package com.tiantianapp.model;

/**
 * Created by zhoukai on 2017/7/3.
 */

public class DataBean {
   public String name;
   public int page;
   public String url;

    public DataBean(String name, int page, String url) {
        this.name = name;
        this.page = page;
        this.url = url;
    }

    @Override
    public String toString() {
        return name;
    }
}
