package com.tiantianapp.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.tiantianapp.R;
import com.tiantianapp.itface.PermissionCallBack;
import com.tiantianapp.itface.PermissionUtil;
import com.tiantianapp.rxjava.BaseImpl;
import com.tiantianapp.util.BarUtils;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener,BaseImpl {
    private LinearLayout container;
    private int color;
    private boolean isGestureOpen = true;
    private static final int REQUESTCODE = 1;
    private PermissionCallBack mPermCallBack;//6.0权限
    private String mPermSettingMsg;//权限提示
    private CompositeDisposable disposables2Stop;// 管理Stop取消订阅者者
    private CompositeDisposable disposables2Destroy;// 管理Destroy取消订阅者者
    private ZLoadingDialog mProgressDialog;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        container = new LinearLayout(getApplicationContext());
        container.setOrientation(LinearLayout.VERTICAL);
        if (disposables2Destroy != null) {
            throw new IllegalStateException("onCreate called multiple times");
        }
        disposables2Destroy = new CompositeDisposable();
    }

    public abstract void onClick(View view);


    @Override
    public void finish() {
        // TODO Auto-generated method stub
        super.finish();
    }


    /**
     * 设置barcolor状态栏颜色属性
     *
     * @param activity
     * @param color
     */
    public void setBarColor(Activity activity, int color) {
        BarUtils.setStatusBarAlpha(activity, color);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            LayoutInflater.from(this).inflate(layoutResID, container, true);
            setContentView(container);
        } else {
            super.setContentView(layoutResID);
        }
        smartInject();
    }

    /**
     * 6.0权限使用方法
     *
     * @param perms
     * @param callBack
     * @param settingMsg
     */
    public void baseRequestPermission(String[] perms, PermissionCallBack callBack, String settingMsg) {
        mPermCallBack = callBack;
        mPermSettingMsg = settingMsg;
        if (!PermissionUtil.checkPerm(perms, this)) {
            requestPermissions(perms, REQUESTCODE);
        } else {
            if (callBack != null) {
                callBack.permGrant(perms);
            }
        }
    }

    /**
     * 6.0权限回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        /**
         * 允许的权限
         */
        List<String> permsGranted = new ArrayList<>();
        /**
         * 拒绝的权限
         */
        List<String> permsDenied = new ArrayList<>();
        if (requestCode == REQUESTCODE) {
            /**
             * 添加允许权限和拒绝权限到相应的集合中
             */
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    permsGranted.add(permissions[i]);
                } else {
                    permsDenied.add(permissions[i]);
                }

            }
            /**
             *进行权限回调
             */
            if (permsGranted.size() != 0 && permsDenied.size() == 0) {
                if (mPermCallBack != null) {
                    mPermCallBack.permGrant((String[]) permsGranted.toArray(new String[permsGranted.size()]));
                }
            } else {
                if (mPermCallBack != null) {
                    mPermCallBack.permDeny((String[]) permsDenied.toArray(new String[permsDenied.size()]));
                }
                /**
                 * 点击不再提醒拒绝权限
                 * 提示是否进入设置界面设置权限
                 */
                for (String permDenied : permsDenied) {
                    if (!shouldShowRequestPermissionRationale(permDenied)) {
                        PermissionUtil.gotoSetting(mPermSettingMsg, this);
                        return;
                    }
                }

            }
        }
    }

    /**
     * 使用java反射机制
     * 设置Activity不用findViewbyid
     */
    private void smartInject() {
        try {
            Class<? extends Activity> clz = getClass();

            while (clz != BaseActivity.class) {
                Field[] fs = clz.getDeclaredFields();
                Resources res = getResources();
                String packageName = getPackageName();
                for (Field field : fs) {
                    if (!View.class.isAssignableFrom(field.getType())) {
                        continue;
                    }
                    int viewId = res.getIdentifier(field.getName(), "id", packageName);
                    if (viewId == 0)
                        continue;
                    field.setAccessible(true);
                    try {
                        View v = findViewById(viewId);
                        field.set(this, v);
                        Class<?> c = field.getType();
                        Method m = c.getMethod("setOnClickListener", View.OnClickListener.class);
                        m.invoke(v, this);
                    } catch (Throwable e) {
                    }
                    field.setAccessible(false);

                }
                clz = (Class<? extends Activity>) clz.getSuperclass();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean addRxStop(Disposable disposable) {
        if (disposables2Stop == null) {
            throw new IllegalStateException(
                    "addUtilStop should be called between onStart and onStop");
        }
        disposables2Stop.add(disposable);
        return true;
    }

    @Override
    public boolean addRxDestroy(Disposable disposable) {
        return true;
    }

    @Override
    public void remove(Disposable disposable) {
        if (disposables2Stop == null && disposables2Destroy == null) {
            throw new IllegalStateException("remove should not be called after onDestroy");
        }
        if (disposables2Stop != null) {
            disposables2Stop.remove(disposable);
        }
        if (disposables2Destroy != null) {
            disposables2Destroy.remove(disposable);
        }
    }

    @Override
    public void showProgress(String msg) {
        mProgressDialog = new ZLoadingDialog(this);
        mProgressDialog.setLoadingBuilder(Z_TYPE.DOUBLE_CIRCLE)//设置类型
                .setLoadingColor(getResources().getColor(R.color.colorAccent))//颜色
                .setHintText(msg)
                .setHintTextSize(16) // 设置字体大小 dp
                .setHintTextColor(Color.GRAY)  // 设置字体颜色
                .show();
    }

    @Override
    public void dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (disposables2Stop != null) {
            throw new IllegalStateException("onStart called multiple times");
        }
        disposables2Stop = new CompositeDisposable();
    }
    @Override
    public void onStop() {
        super.onStop();
        if (disposables2Stop == null) {
            throw new IllegalStateException("onStop called multiple times or onStart not called");
        }
        disposables2Stop.dispose();
        disposables2Stop = null;
    }
}
