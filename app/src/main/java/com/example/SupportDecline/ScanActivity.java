package com.example.SupportDecline;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SupportDecline.data.JsonRootBean;
import com.example.SupportDecline.data.List;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ScanActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SCAN = 123;

    ImageView scan;
    ListView ls;
    Button finish;
    private static final String TAG = "ScanActivity";
    String[] pn;
    int[] ahm;


    /**
     * {@inheritDocqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq@Params Bundle}
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
        //data

        pn = appData.phoneNumber_scan;
        ahm = appData.qhm;

        if (appData.count > 1) {
            pn = null;
            ahm = null;
        }
        ArrayList<Map<String, Object>> arr_data = new ArrayList<>();
        // 新增数据
        for (int i5 = 0; i5 < appData.i; i5++) {
            Map<String, Object> map = new HashMap<String, Object>();
            //map放入两个键值对，键名与from对应，
            map.put("pn", pn[i5]);
            map.put("qhm", ahm[i5]);
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
                //send scan data
                sendScanData();
                startActivity(i);
            }
        });

    }

    /**
     *
     */

    private void sendScanData() {

        ////define temp variable

        APPData appData = (APPData) getApplicationContext();
        java.util.List list = new ArrayList<>();
        for (int i = 0; i < appData.i; i++) {

            List list1 = new List(appData.id, appData.phoneNumber_scan[i],
                    appData.pro + appData.qhm[i], appData.clickId);

            list.add(list1);

        }
        JsonRootBean jsonRootBean = new JsonRootBean();
        jsonRootBean.setList(list);

        Gson gson = new Gson();
        String url = "http://" + Constant.IP + ":" + Constant.PORT + "/server/smsedit/insert";
        String json = gson.toJson(jsonRootBean);
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = FormBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call2 = client.newCall(request);
        call2.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result2 = response.body().string();
                try {

                    //用JSON字符串来初始化一个JSON对象
                    JSONObject jsonObject = new JSONObject(result2);
                    //然后读取result后面的数组([]号里的内容)，用这个内容来初始化一个JSONArray对象
                    String code = jsonObject.getString("code");
                    if (code.equals("200")) {
                        System.out.println("add data successful");
                    }

                } catch (JSONException ex) {

                    Log.e("JSON Error: ", ex.toString());

                } catch (Exception e) {

                }


            }

        });

    }

}