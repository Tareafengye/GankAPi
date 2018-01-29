package com.tiantianapp.itface;

import android.widget.ImageView;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public interface HolderImageLoader {
    /**
     * 需要去复写这个方法来加载图片
     *
     * @param imageView
     * @param path
     */
    void loadImage(ImageView imageView, String path);
}
