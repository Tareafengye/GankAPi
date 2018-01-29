package com.tiantianapp.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tiantianapp.util.ByAlert;
import com.tiantianapp.util.LogUtil;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI api;
    private int code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, "wx36e746007a0b0a38", true);
        api.handleIntent(getIntent(), this);
        SendAuth.Resp resp = new SendAuth.Resp(getIntent().getExtras());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);

    }

    @Override
    public void onReq(BaseReq baseReq) {
        WXEntryActivity.this.finish();
    }

    @Override
    public void onResp(BaseResp resp) {
        code = resp.errCode;
        LogUtil.d("BaseResp" + code);
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                WXEntryActivity.this.finish();
                overridePendingTransition(0, 0);
                ByAlert.alert("成功");
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                WXEntryActivity.this.finish();
                ByAlert.alert("取消分享");
                overridePendingTransition(0, 0);
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                WXEntryActivity.this.finish();
                ByAlert.alert("分享失败");
                overridePendingTransition(0, 0);
                break;
            default:
                WXEntryActivity.this.finish();
                break;
        }

        // Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
