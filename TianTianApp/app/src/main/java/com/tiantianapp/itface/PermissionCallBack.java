package com.tiantianapp.itface;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public /**
 * 权限请求结果回调
 */
interface PermissionCallBack {
    /**
     * 允许权限
     */
    void permGrant(String[] permsGranted);

    /**
     * 拒绝权限
     */
    void permDeny(String[] permsDenied);
}
