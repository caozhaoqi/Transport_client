package com.example.transportclient;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bigkoo.snappingstepper.SnappingStepper;
import com.bigkoo.snappingstepper.listener.SnappingStepperValueChangeListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YTActivity extends AppCompatActivity implements SnappingStepperValueChangeListener {


    private static final int REQUEST_CODE_SCAN = 123;
    TextView tvValue;
    CustomFAB scan;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_t);

        scan = findViewById(R.id.scan_btn_yt);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(YTActivity.this, ScanActivity.class);
                startActivity(i);
            }
        });

        View convertView = LayoutInflater.from(this).inflate(R.layout.yt_list_item,
                null);

        SnappingStepper stepper = convertView.findViewById(R.id.stepper);

        stepper.setOnValueChangeListener(this);

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

        ListView listView = (ListView) findViewById(R.id.yt_listview);
        listView.setAdapter(simp_ada);


    }


    @Override
    public void onValueChange(View view, int value) {

        switch (view.getId()) {
            case R.id.stepper:
                // tvValue.setText(String.valueOf(value));
                break;
//            case R.id.stepperCustom:
//                tvValueCustom.setText(String.valueOf(value));
//                break;
        }
    }
}