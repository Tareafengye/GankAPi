package com.tiantianapp.rxjava;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tiantianapp.app.App;
import com.tiantianapp.util.LogUtil;
import com.tiantianapp.util.NetworkUtils;
import com.tiantianapp.util.Utils;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhpan on 2017/4/1.
 */

public class IdeaApi {
    private Retrofit retrofit;
    private IdeaApiService service;
    private static OkHttpClient mOkHttpClient;

    private IdeaApi() {
        if (retrofit == null) {
            if (null == mOkHttpClient) {
                mOkHttpClient = OkHttp3.getOkHttpClient();
                ClearableCookieJar cookieJar =
                        new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.getInstanse()));
                OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
                File cacheFile = new File(Utils.getContext().getCacheDir(), "cache");
                Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
                httpClientBuilder.cache(cache);
                httpClientBuilder.cookieJar(cookieJar);
//                httpClientBuilder.addInterceptor(LoggingInterceptor);
                httpClientBuilder.addInterceptor(new HttpCacheInterceptor());
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
                retrofit = new Retrofit.Builder()
                        .client(mOkHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(Constant.URL)
                        .build();
                service = retrofit.create(IdeaApiService.class);
            }
        }



    }

    private static final Interceptor LoggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
//            Log.d("requestGank", response.request().url() + "");
//            Logger.t("").i(String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
            return response;
        }
    };

    //  创建单例
    private static class SingletonHolder {
        private static final IdeaApi INSTANCE = new IdeaApi();
    }

    public static IdeaApiService getApiService() {
        return SingletonHolder.INSTANCE.service;
    }

    class HttpCacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetworkUtils.isConnected()) {  //没网强制从缓存读取
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                LogUtil.d("okhttp no network");
            }


            Response originalResponse = chain.proceed(request);
            if (NetworkUtils.isConnected()) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }
}
