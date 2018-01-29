package com.tiantianapp.rxjava;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public interface BaseImpl {
    boolean addRxStop(Disposable disposable);

    boolean addRxDestroy(Disposable disposable);

    void remove(Disposable disposable);

    /**
     * 显示ProgressDialog
     */
    void showProgress(String msg);

    /**
     * 取消ProgressDialog
     */
    void dismissProgress();
}
