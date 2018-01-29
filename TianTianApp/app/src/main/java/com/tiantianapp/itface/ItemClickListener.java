package com.tiantianapp.itface;

import android.view.View;

/**
 * Created by weijinran ，Email 994425089@qq.com，on 2017/10/23.
 * Describe: 点击事件监听接口
 * PS: Not easy to write code, please indicate.
 */

public interface ItemClickListener {
    void onItemClick(View v, int position);

    boolean onItemLongClick(View v, int position);
}
