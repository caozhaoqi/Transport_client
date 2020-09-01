package com.example.transportclient;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bigkoo.snappingstepper.SnappingStepper;
import com.bigkoo.snappingstepper.listener.SnappingStepperValueChangeListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YTActivity extends AppCompatActivity implements SnappingStepperValueChangeListener {


    private static final int REQUEST_CODE_SCAN = 123;
    TextView tvValue;
    CustomFAB scan;
    EditText kd_cm;
    CheckBox get_num;
    TextView txt_get_code;
    String companyName;
    SimpleAdapter simp_ada;
    TextView fsts_txt;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_t);

        TextView cm = findViewById(R.id.companyName);
        kd_cm = findViewById(R.id.edt_kd_fs);
        get_num = findViewById(R.id.get_num);
        get_num.setChecked(true);
        txt_get_code = findViewById(R.id.tx_get_code_yt);
        fsts_txt = findViewById(R.id.fsts_txt);
        Intent i = getIntent();
        assert companyName != null;
        companyName = i.getStringExtra("companyName");

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


        initData();
        //show
        // 对应的公司短信条数

        @SuppressLint("InflateParams") final View convertView = LayoutInflater.from(this).inflate(R.layout.yt_list_item,
                null);


        final ArrayList<Map<String, Object>> arr_data = new ArrayList<>();
        // 新增数据
        for (int i5 = 0; i5 < 1; i5++) {
            Map map = new HashMap<String, Object>();
            //map放入两个键值对，键名与from对应，
            map.put("pn", "13131313" + i5);

            //往list添加数据
            arr_data.add(map);
        }

        // 新建适配器 ，绑定数据
        final String[] from = {"pn"};
        final int[] to = {R.id.phone_number};

        simp_ada = new SimpleAdapter(this, arr_data, R.layout.yt_list_item, from, to);
        ListView listView = findViewById(R.id.yt_listview);
        listView.setAdapter(simp_ada);
        final SnappingStepper stepper = convertView.findViewById(R.id.stepper);

        stepper.setOnValueChangeListener(this);
        get_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                simp_ada = new SimpleAdapter(YTActivity.this, arr_data, R.layout.nyt_list_item, from, to);
                //   stepper.setVisibility(View.GONE);
                txt_get_code.setVisibility(View.GONE);
                ListView listView = findViewById(R.id.yt_listview);
                listView.setAdapter(simp_ada);
            }
        });


        scan = findViewById(R.id.scan_btn_yt);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(YTActivity.this, ScanActivity.class);
                startActivity(i);
            }
        });


    }

    /**
     * 初始化页面数据
     * 1.短信条数 调用借口
     * get
     */
    private void initData() {
        APPData appData = (APPData) getApplicationContext();

        String serviceUserId = String.valueOf(appData.id);
        System.out.println(serviceUserId);
        String url2 = "http://" + Constant.IP + ":" + Constant.PORT + "" +
                "/server/serviceUserLogistics/findByServiceUserId?serviceUserId=" + serviceUserId;

        OkHttpClient client2 = new OkHttpClient();
        //
        Request request2 = new Request.Builder()
                .url(url2)
                //    .post(requestBody)
                .build();
        Call call = client2.newCall(request2);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Toast.makeText(LoginActivity.this, "internet error", Toast.LENGTH_SHORT).show();
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result2 = response.body().string();
                try {

                    //用JSON字符串来初始化一个JSON对象
                    JSONArray jsonArray = new JSONArray(result2);

                    int[] smsCount = new int[jsonArray.length()];
                    String[] logisticsName = new String[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        smsCount[i] = jsonObject1.getInt("smsCount");
                        logisticsName[i] = jsonObject1.getString("logisticsName");

                    }


                    APPData appData = (APPData) getApplicationContext();
                    appData.smsCount_yt = smsCount;
                    appData.logisticName_yt = logisticsName;

                    for (int k = 0; k < appData.logisticName_yt.length; k++) {
                        if (appData.logisticName_yt[k].equals(companyName)) {
                            fsts_txt.setText(appData.smsCount_yt[k] + "条");
                        }
                    }
                } catch (JSONException ex) {

                    Log.e("JSON Error: ", ex.toString());

                } catch (Exception e) {

                }

            }

        });
    }


    @Override
    public void onValueChange(@NonNull View view, int value) {


    }
}