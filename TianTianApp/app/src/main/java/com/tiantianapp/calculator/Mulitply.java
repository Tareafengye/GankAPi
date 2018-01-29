package com.tiantianapp.calculator;

import com.tiantianapp.itface.Calculate;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public class Mulitply implements Calculate {

    public float calculate(double x, double y) {
        return (float) (x*y);
    }
}
