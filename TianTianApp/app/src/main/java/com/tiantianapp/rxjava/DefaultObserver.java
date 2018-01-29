package com.tiantianapp.rxjava;

import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.tiantianapp.R;
import com.tiantianapp.app.App;
import com.tiantianapp.util.ByAlert;
import com.tiantianapp.util.LogUtil;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.tiantianapp.rxjava.DefaultObserver.ExceptionReason.CONNECT_ERROR;
import static com.tiantianapp.rxjava.DefaultObserver.ExceptionReason.CONNECT_TIMEOUT;
import static com.tiantianapp.rxjava.DefaultObserver.ExceptionReason.PARSE_ERROR;
import static com.tiantianapp.rxjava.DefaultObserver.ExceptionReason.UNKNOWN_ERROR;


/**
 * Created by zhpan on 2017/4/18.
 */

public abstract class DefaultObserver<T extends BasicResponse> implements Observer<T> {
    private BaseImpl mBaseImpl;
    //  Activity 是否在执行onStop()时取消订阅
    private boolean isAddInStop = false;

    public DefaultObserver(BaseImpl baseImpl) {
        mBaseImpl = baseImpl;
    }

    public DefaultObserver(BaseImpl baseImpl, boolean isShowLoading) {
        mBaseImpl = baseImpl;
        if (isShowLoading) {
            mBaseImpl.showProgress("正在加载...");
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (isAddInStop) {    //  在onStop中取消订阅
            mBaseImpl.addRxStop(d);
        } else { //  在onDestroy中取消订阅
            mBaseImpl.addRxDestroy(d);
        }
    }

    @Override
    public void onNext(T response) {
        LogUtil.d("responseresponse" + response.getCode());
        mBaseImpl.dismissProgress();
        if (response.getCode() == 0 || response.getCode() == 1) {
            mBaseImpl.dismissProgress();
            onSuccess(response);
        } else if (response.getCode() == 2001) {
//            RxToast.error("账号信息过期,请重新登录");
            ByAlert.alert("未知错误");
        } else {
            onFail(response);
        }

    }

    @Override
    public void onError(Throwable e) {
        LogUtil.d("ThrewableName" + e.toString());
        System.out.print("dismissProgressName:\t" + e.toString());
        mBaseImpl.dismissProgress();
        if (e instanceof HttpException) {     //   HTTP错误
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {   //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {   //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //  解析错误
            onException(PARSE_ERROR);
        } else {
            onException(UNKNOWN_ERROR);
        }
    }

    @Override
    public void onComplete() {
    }

    /**
     * 请求成功
     *
     * @param response 服务器返回的数据
     */
    abstract public void onSuccess(T response);

    /**
     * 服务器返回数据，但响应码不为200
     *
     * @param response 服务器返回的数据
     */
    public void onFail(T response) {
        LogUtil.d("responseresponsename" + response);
        String message = response.getMessage();
        if (!TextUtils.isEmpty(message)) {
            ByAlert.alert(message);
        } else {
            ByAlert.alert(App.getInstanse().getString(R.string.response_return_error));
        }
    }

    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ByAlert.alert(App.getInstanse().getString(R.string.connect_error));
                break;

            case CONNECT_TIMEOUT:
                ByAlert.alert(App.getInstanse().getString(R.string.connect_timeout));
                break;

            case BAD_NETWORK:
                ByAlert.alert(App.getInstanse().getString(R.string.bad_network));
                break;

            case PARSE_ERROR:
                ByAlert.alert(App.getInstanse().getString(R.string.response_return_error));
                break;

            case UNKNOWN_ERROR:
            default:
                ByAlert.alert(App.getInstanse().getString(R.string.unknown_error));
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }
}
