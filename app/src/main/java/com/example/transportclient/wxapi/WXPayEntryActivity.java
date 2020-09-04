package com.example.transportclient.wxapi;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 由第三方App个性化展示支付结果
        setContentView(R.layout.activity_w_x_pay_entry);

        iwxapi = WXAPIFactory.createWXAPI(this, APP_ID, true);
        iwxapi.registerApp(APP_ID);
        iwxapi.handleIntent(getIntent(), this);
    }

    /** {@inheritDoc} */
    @Override
    protected void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        iwxapi.handleIntent(intent, this);
    }

    /** {@inheritDoc} */
    @Override
    public void onReq(@NonNull BaseReq baseReq) {

    }

    /**
     * TODO WeChat pay recall
     */
    @Override
    public void onResp(@NonNull BaseResp baseResp) {

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
