package com.tiantianapp.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.danikula.videocache.HttpProxyCacheServer;
import com.tiantianapp.photo.util.Awen;
import com.tiantianapp.util.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public class App extends Application {
    public static App app;
    public static Map<String, Activity> map = new HashMap<>();
    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy(Context context) {
        app = getInstanse();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Utils.init(this);
        Awen.init(this);
    }

    public static App getInstanse() {
        return app;
    }

    /**
     * 添加队列
     *
     * @param activity
     * @param activityName
     */
    public static void addDestoryActivity(Activity activity, String activityName) {
        map.put(activityName, activity);
    }

    /**
     * 指定销毁队列
     *
     * @param activity
     * @param activityName
     */
    public static void detoryactivity(Activity activity, String activityName) {
        Set<String> keySet = map.keySet();
        if (keySet.size() > 0) {
            for (String key : keySet) {
                if (activityName.equals(key)) {
                    map.get(key).finish();
                }
            }
        }
    }
}
