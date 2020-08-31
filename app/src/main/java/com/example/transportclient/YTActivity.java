package com.example.transportclient;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
    EditText kd_cm;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_t);

        TextView cm = findViewById(R.id.companyName);

        kd_cm = findViewById(R.id.edt_kd_fs);


        Intent i = getIntent();
        String companyName = i.getStringExtra("companyName");
        assert companyName != null;
        switch (companyName) {
            case "圆通":
                cm.setText("圆通");
                kd_cm.setText("圆通");
                break;
            case "韵达":
                cm.setText("韵达");
                kd_cm.setText("韵达");
                break;
            case "中通":
                cm.setText("中通");
                kd_cm.setText("中通");
                break;
            default:
                cm.setText(companyName);
                kd_cm.setText(companyName);
                break;
        }

        scan = findViewById(R.id.scan_btn_yt);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(YTActivity.this, ScanActivity.class);
                startActivity(i);
            }
        });

        @SuppressLint("InflateParams")
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

        ListView listView = findViewById(R.id.yt_listview);
        listView.setAdapter(simp_ada);


    }


    @Override
    public void onValueChange(@NonNull View view, int value) {

//        if (view.getId() == R.id.stepper) {
//            // tvValue.setText(String.valueOf(value));
//            //            case R.id.stepperCustom:
////                tvValueCustom.setText(String.valueOf(value));
////                break;
//        }
    }
}