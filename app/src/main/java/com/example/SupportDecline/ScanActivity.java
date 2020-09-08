package com.example.SupportDecline;

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

public class ScanActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SCAN = 123;

    ImageView scan;
    ListView ls;
    Button finish;
    private static final String TAG = "ScanActivity";


    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        //ButterKnife.bind(this);

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
            map.put("qhm", appData.qhm[i5]);
            //往list添加数据
            arr_data.add(map);
        }
//16602629614
        // 新建适配器 ，绑定数据
        String[] from = {"pn", "qhm"};
        int[] to = {R.id.phone_number, R.id.stepper};
        SimpleAdapter simp_ada = new SimpleAdapter(this, arr_data, R.layout.yt_list_item, from, to);


        ls.setAdapter(simp_ada);


        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanActivity.this, ScannerActivity.class);

                startActivity(intent);
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScanActivity.this, YTActivity.class);
                startActivity(i);
            }
        });

    }

}