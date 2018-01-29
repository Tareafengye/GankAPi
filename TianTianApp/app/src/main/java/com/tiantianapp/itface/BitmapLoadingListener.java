package com.tiantianapp.itface;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public interface BitmapLoadingListener {
    void onSuccess(Bitmap b);

    void onError();
}
