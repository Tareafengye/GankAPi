package com.tiantianapp.weight;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.tiantianapp.R;


/**
 * Created by zhpan on 2017/4/13.
 */

public class CustomProgressDialog extends Dialog {
    private View mDialogView;
    private boolean cancelTouchOutside;
    private static CustomProgressDialog dialog;
    private Context context;

    public CustomProgressDialog(Builder builder) {
        super(builder.context);
        mDialogView = builder.mDialogView;
        cancelTouchOutside = builder.cancelTouchOutside;
    }

    private CustomProgressDialog(Builder builder, int themeResId) {
        super(builder.context, themeResId);
        mDialogView = builder.mDialogView;
        cancelTouchOutside = builder.cancelTouchOutside;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mDialogView);
        setCanceledOnTouchOutside(cancelTouchOutside);
        context = getContext();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus && dialog != null) {
            mDialogView = (ImageView) dialog.findViewById(R.id.ivProgress);
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.dialog_progress_anim);
            mDialogView.startAnimation(animation);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
//        animationDrawable.stop();
    }

    public static final class Builder {
        Context context;
        private int resStyle = -1;
        private View mDialogView;
        private boolean cancelTouchOutside;

        public Builder(Context context) {
            this.context = context;
            mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);
        }

        /**
         * 设置主题
         *
         * @param resStyle style id
         * @return CustomProgressDialog.Builder
         */
        public Builder setTheme(int resStyle) {
            this.resStyle = resStyle;
            return this;
        }

        public Builder setMessage(String message) {
            TextView tvMessage = (TextView) mDialogView.findViewById(R.id.tvText);
            if (tvMessage != null) {
                tvMessage.setText(message);
            }
            return this;
        }

        /**
         * 设置点击dialog外部是否取消dialog
         *
         * @param val 点击外部是否取消dialog
         * @return
         */
        public Builder cancelTouchOutside(boolean val) {
            cancelTouchOutside = val;
            return this;
        }

        public CustomProgressDialog build() {
            if (resStyle != -1) {
                return new CustomProgressDialog(this, resStyle);
            } else {
                return new CustomProgressDialog(this);
            }
        }
    }
}
