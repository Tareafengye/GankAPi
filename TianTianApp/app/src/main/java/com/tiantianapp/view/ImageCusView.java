package com.tiantianapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.tiantianapp.model.CustomPoint;
import com.tiantianapp.util.LogUtil;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public class ImageCusView extends View {

    private Context mContext;
    private int screenwidth;
    private int screenheight;
    private int radial = 50;
    private Paint mPaint;

    public ImageCusView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public ImageCusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public ImageCusView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(screenwidth, screenheight / 2, radial, mPaint);
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setColor(Color.RED);//设置颜色
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);//设置样式
        mPaint.setStrokeWidth(20);//设置描边(像素)
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);//获取屏幕的款高度
        Display display = windowManager.getDefaultDisplay();
        screenheight = display.getHeight();
        screenwidth = display.getWidth();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.d("ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.d("ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.d("ACTION_MOVE");

                break;
        }
        return super.onTouchEvent(event);

    }
}
