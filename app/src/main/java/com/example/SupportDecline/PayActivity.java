package com.example.SupportDecline;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * The type Pay activity.
 */
public class PayActivity extends AppCompatActivity {

    /**
     * The Wechat pay.
     */
    ImageView wechat_pay;
    /**
     * The M wechat pay.
     */
    @BindView(R.id.wechat_pay)
    ImageView mWechatPay;
    private LinearLayout mTwentyYuan;
    private LinearLayout mFiftyYuan;
    private LinearLayout mOneHundredYuan;
    private LinearLayout mTwoHundredYuan;
    private LinearLayout mForthHundred;
    private LinearLayout mOneThousandYuan;

    /**
     * Wechat pay.
     *
     * @param activity     the activity
     * @param appId        the app id
     * @param partnerId    the partner id
     * @param prepayId     the prepay id
     * @param packageValue the package value
     * @param nonceStr     the nonce str
     * @param timeStamp    the time stamp
     * @param sign         the sign
     * @param signType     the sign type
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initView();
        ButterKnife.bind(this);

        wechat_pay = findViewById(R.id.wechat_pay);

        wechat_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wechatPay(PayActivity.this, "", "", "", "", "", "", "", "");
            }
        });
    }

    /**
     * On click.
     *
     * @param v the v
     */
    @OnClick(R.id.wechat_pay)
    public void onClick(@NonNull View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.wechat_pay:
                break;
        }
    }

    private void initView() {
        mTwentyYuan = findViewById(R.id.twenty_yuan);
        mFiftyYuan = findViewById(R.id.fifty_yuan);
        mOneHundredYuan = findViewById(R.id.one_hundred_yuan);
        mTwoHundredYuan = findViewById(R.id.two_hundred_yuan);
        mForthHundred = findViewById(R.id.forth_hundred);
        mOneThousandYuan = findViewById(R.id.one_thousand_yuan);
        mWechatPay = findViewById(R.id.wechat_pay);
    }
}