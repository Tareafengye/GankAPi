package com.tiantianapp.itface;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public class PermissionUtil {
    /**
     * 进入应用设置界面设置权限
     *
     * @param msg
     */
    public static void gotoSetting(String msg, final Context context) {
        new AlertDialog.Builder(context)
                .setMessage(msg)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent localIntent = new Intent();
                        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
                        context.startActivity(localIntent);
                    }

                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
    /**
     * 权限检查
     */
    public static boolean checkPerm(String[] perms,Context context) {
        for (String perm : perms) {
            if (ContextCompat.checkSelfPermission(context, perm) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;

    }
    /**
     * 6..0权限的使用
     */
    /*private void takePic() {
        String[] perms={Manifest.permission.CAMERA,Manifest.permission.READ_SMS};
        baseRequestPermission(perms, new PermissionCallBack() {

            @Override
            public void permGrant(String[] permsGranted) {
                Toast.makeText(MainActivity.this, "已授权", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void permDeny(String[] permsDenied) {
                Toast.makeText(MainActivity.this, "未授权", Toast.LENGTH_SHORT).show();
            }
        },"调用拍照功能需要获取权限，是否跳转权限设置？");

    }*/
}
