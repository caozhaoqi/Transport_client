package com.example.transportclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScanActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SCAN = 123;

    ImageView scan;
    ListView ls;
    Button finish;
    private static final String TAG = "ScanActivity";
    @BindView(R.id.scan)
    ImageView mScan;
    @BindView(R.id.ls_sc)
    ListView mLsSc;
    @BindView(R.id.finish)
    Button mFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        ButterKnife.bind(this);

        APPData appData = (APPData) getApplicationContext();

        scan = findViewById(R.id.scan);
        ls = findViewById(R.id.ls_sc);
        finish = findViewById(R.id.finish);

        ArrayList<Map<String, Object>> arr_data = new ArrayList<>();
        // 新增数据
        for (int i5 = 0; i5 < appData.i; i5++) {
            Map map = new HashMap<String, Object>();
            //map放入两个键值对，键名与from对应，
            map.put("pn", appData.phoneNumber_scan[i5]);
            //往list添加数据
            arr_data.add(map);
        }

        // 新建适配器 ，绑定数据
        String[] from = {"pn"};
        int[] to = {R.id.phone_number};
        SimpleAdapter simp_ada = new SimpleAdapter(this, arr_data, R.layout.yt_list_item, from, to);


        ls.setAdapter(simp_ada);
//
//
//
//     16602629614


        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanActivity.this, ScannerActivity.class);

                startActivity(intent);
//                ZxingConfig config = new ZxingConfig();
//                config.setShowbottomLayout(true);//底部布局（包括闪光灯和相册）
//                config.setPlayBeep(true);//是否播放提示音
//                config.setShake(true);//是否震动
//                config.setShowAlbum(true);//是否显示相册
//                config.setShowFlashLight(true);//是否显示闪光灯
//                intent.putExtra(com.yzq.zxinglibrary.common.Constant.INTENT_ZXING_CONFIG, config);
//                startActivityForResult(intent, REQUEST_CODE_SCAN);

            }
        });
        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScanActivity.this, YTActivity.class);
                startActivity(i);
            }
        });

    }

    @OnClick({R.id.scan, R.id.ls_sc, R.id.finish})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.scan:
                break;
            case R.id.ls_sc:
                break;
            case R.id.finish:
                break;
        }
    }
}