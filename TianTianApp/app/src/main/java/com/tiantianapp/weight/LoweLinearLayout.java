package com.tiantianapp.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.tiantianapp.R;


public class LoweLinearLayout extends LinearLayout {

    /**
     */
    private float mRatio;

    public LoweLinearLayout(Context context) {
        this(context, null);
    }

    public LoweLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoweLinearLayout(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.LoweImageView);
        mRatio = typedArray.getFloat(R.styleable.LoweImageView_ratio, 0);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize;
        if (widthMode == MeasureSpec.EXACTLY && mRatio > 0) {
            heightSize = (int) (widthSize / mRatio + 0.5f);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,
                    MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setmRatio(float mRatio) {
        this.mRatio = mRatio;
    }
}