package com.tiantianapp.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by Administrator on 2018/1/4 0004.
 */

public class MyGradview extends GridView {
    public MyGradview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGradview(Context context) {
        super(context);
    }

    public MyGradview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST));
    }
}
