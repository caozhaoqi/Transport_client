package com.example.transportclient.wxapi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.transportclient.R;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    private static final String APP_ID = "您应用的app_Id";
    private IWXAPI iwxapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 由第三方App个性化展示支付结果
        setContentView(R.layout.activity_w_x_pay_entry);

        iwxapi = WXAPIFactory.createWXAPI(this, APP_ID, true);
        iwxapi.registerApp(APP_ID);
        iwxapi.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        iwxapi.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    /**
     * TODO 微信支付回调
     */
    @Override
    public void onResp(BaseResp baseResp) {

        int errCode = baseResp.errCode;

        if (errCode == 0) {
            // 成功

        } else if (errCode == -1) {
            // 失败

        } else if (errCode == -2) {
            // 取消

        }
    }
}
