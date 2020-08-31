package com.example.transportclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class PayActivity extends AppCompatActivity {

    ImageView wechat_pay;

    public static void wechatPay(@NonNull Activity activity, @NonNull String appId,
                                 @NonNull String partnerId, @NonNull String prepayId,
                                 @NonNull String packageValue, @NonNull String nonceStr,
                                 @NonNull String timeStamp, @NonNull String sign, @NonNull String signType) {

        // 将该app注册到微信
        final IWXAPI wxapi = WXAPIFactory.createWXAPI(activity, appId);

        if (!wxapi.isWXAppInstalled()) {
            Toast.makeText(activity, "您尚未安装微信客户端", Toast.LENGTH_SHORT).show();
            return;
        }

        PayReq request = new PayReq();
        request.appId = appId;
        request.partnerId = partnerId;
        request.prepayId = prepayId;
        request.packageValue = packageValue;
        request.nonceStr = nonceStr;
        request.timeStamp = timeStamp;
        request.sign = sign;
        request.signType = signType;

        wxapi.sendReq(request);
    }

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        wechat_pay = findViewById(R.id.wechat_pay);

        wechat_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wechatPay(PayActivity.this, "", "", "", "", "", "", "", "");
            }
        });
    }
}