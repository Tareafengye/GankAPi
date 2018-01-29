package com.tiantianapp.weight;

import android.app.Dialog;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiantianapp.R;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public class MyDialog extends Dialog {
    private Context context;
    private static MyDialog dialog;
    private ImageView ivProgress;
    public MyDialog(Context context) {
        super(context);
        this.context = context;
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;

    }
    //显示dialog的方法
    public static MyDialog showDialog(Context context){
        dialog = new MyDialog(context, R.style.dialog);//dialog样式
        dialog.setContentView(R.layout.dialog_layout);//dialog布局文件
        dialog.setCanceledOnTouchOutside(false);//点击外部不允许关闭dialog
        return dialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus && dialog != null){
            ivProgress = (ImageView) dialog.findViewById(R.id.ivProgress);
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.dialog_progress_anim);
            ivProgress.startAnimation(animation);
        }
    }

}
