package com.tiantianapp.rxjava;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;


import com.tiantianapp.app.App;
import com.tiantianapp.util.NetworkUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/12 0012.
 */

public class OkHttp3 {
    private static OkHttpClient mOkHttpClient;
    private static String TAG = "OkHttp3UtilsTokens";

    //设置缓存目录
    private static File cacheDirectory = new File(App.getInstanse().getApplicationContext().getCacheDir().getAbsolutePath(), "MyCache");
    private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);


    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    public static OkHttpClient getOkHttpClient() {
        Log.d(TAG, "OkHttpClient1" + "执行了");
        if (null == mOkHttpClient) {

            //同样okhttp3后也使用build设计模式
            mOkHttpClient = new OkHttpClient.Builder()
                    //设置一个自动管理cookies的管理器
                    // .cookieJar(new CookiesManager())
                    //添加拦截器
                    .addInterceptor(new OkHttp3.MyIntercepter())
                    //添加网络连接器
//                    .addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                    //设置请求读写的超时时间
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .cache(new Cache(new File(App.getInstanse().getExternalCacheDir(), "okhttpcache"), 10 * 1024 * 1024))
//                    .cache(cache)
                    .build();
        }
        return mOkHttpClient;
    }

    /**
     * 拦截器
     */
    private static class MyIntercepter implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Log.d(TAG, "Responsess");
            Request oldRequest = chain.request();
            HttpUrl.Builder authorizedUrlBuilder = null;
            //ysl-----start----------------以下代码为添加一些公共参数使用--------------------------
//
            // 添加新的参数
            authorizedUrlBuilder = oldRequest.url()
                    .newBuilder()
                    .scheme(oldRequest.url().scheme())
                    .host(oldRequest.url().host());
//                    .addQueryParameter("key", Constant.APP_KEY + "");
//                    .addQueryParameter("token", token + "")
//                    .addQueryParameter("sign", sign + "");

            // 构建新的请求
            Request newRequest = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(authorizedUrlBuilder.build())
                    .build();
            //ysl-----end
            if (!NetworkUtils.isConnected()) {
                Toast.makeText(App.getInstanse().getApplicationContext(), "暂无网络", Toast.LENGTH_SHORT).show();
                newRequest = newRequest.newBuilder()

                        .cacheControl(CacheControl.FORCE_CACHE)//无网络时只从缓存中读取
                        .build();
            }

            Response response = chain.proceed(newRequest);

            if (NetworkUtils.isConnected()) {
                int maxAge = 60 * 60; // 有网络时 设置缓存超时时间1个小时
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            //***************打印Log*****************************
            String requestUrl = newRequest.url().toString(); // 获取请求url地址
            String methodStr = newRequest.header("Content-Type"); // 获取请求方式
            RequestBody body = newRequest.body(); // 获取请求body
            String bodyStr = (body == null ? "" : body.toString());
            // 打印Request数据
            Log.i("requestUrl", "requestUrl=====>" + requestUrl);
            Log.i("methodStr", "requestMethod=====>" + methodStr);
            Log.i("ysl", "requestBody=====>" + response);
            return response;
        }
    }


}
