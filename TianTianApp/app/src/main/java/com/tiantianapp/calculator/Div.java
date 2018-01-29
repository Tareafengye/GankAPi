package com.tiantianapp.calculator;

import com.tiantianapp.itface.Calculate;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public class Div implements Calculate {

    public float calculate(double x, double y) {
        if(y==0){
            try {
                throw new Exception("被除数不能为0");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
        return (float) (x/y);
    }
}
