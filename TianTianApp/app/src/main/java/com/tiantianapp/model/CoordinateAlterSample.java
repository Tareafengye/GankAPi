package com.tiantianapp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/5 0005.
 */

public class CoordinateAlterSample implements Serializable {
    private double x;
    private double y;
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
