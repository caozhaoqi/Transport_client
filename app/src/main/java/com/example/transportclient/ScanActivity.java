package com.example.transportclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScanActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SCAN = 123;

    ImageView scan;
    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        scan = findViewById(R.id.scan);
        ls = findViewById(R.id.ls_sc);

        ArrayList<Map<String, Object>> arr_data = new ArrayList<>();
        // 新增数据
        for (int i5 = 0; i5 < 20; i5++) {
            Map map = new HashMap<String, Object>();
            //map放入两个键值对，键名与from对应，
            map.put("pn", "13131313" + i5);

            //往list添加数据
            arr_data.add(map);
        }

        // 新建适配器 ，绑定数据
        String[] from = {"pn"};
        int[] to = {R.id.phone_number};
        SimpleAdapter simp_ada = new SimpleAdapter(this, arr_data, R.layout.yt_list_item, from, to);


        ls.setAdapter(simp_ada);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanActivity.this, CaptureActivity.class);

                ZxingConfig config = new ZxingConfig();
                config.setShowbottomLayout(true);//底部布局（包括闪光灯和相册）
                config.setPlayBeep(true);//是否播放提示音
                config.setShake(true);//是否震动
                config.setShowAlbum(true);//是否显示相册
                config.setShowFlashLight(true);//是否显示闪光灯
                intent.putExtra(com.yzq.zxinglibrary.common.Constant.INTENT_ZXING_CONFIG, config);
                startActivityForResult(intent, REQUEST_CODE_SCAN);

            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent

            data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
//                edt_scan_number.setText(String.format("%s", content));
//                scan_result = content;
//                kdgspd(scan_result);
            }
        }
    }
}