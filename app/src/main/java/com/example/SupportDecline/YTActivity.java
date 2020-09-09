package com.example.SupportDecline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bigkoo.snappingstepper.listener.SnappingStepperValueChangeListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 */
public class YTActivity extends AppCompatActivity implements SnappingStepperValueChangeListener {


    private static final int REQUEST_CODE_SCAN = 123;

    int msg_count;//message count
    CustomFAB scan;
    EditText kd_cm;
    CheckBox get_num;
    TextView txt_get_code;
    String companyName;
    SimpleAdapter simp_ada;
    TextView fsts_txt;

    TextView mMsgBegin;//begin

    EditText mEdtKdFs;//快递公司

    TextView mKdydl;//快递已到达

    EditText mInputAddress;//输入快递地址

    TextView mUseCode;//使用取件码

    EditText mInputGetnum;//输入取件码

    TextView mKdydgh;//输入快递员电话提示信息

    EditText mInputPh;//得到快递员电话

    TextView mYiyuan;//使用一元代取快递
    String msg;//send msg

    Button mSend;
    EditText getnum_edt;
    @BindView(R.id.today_date)
    TextView mTodayDate;
    EditText det_get_num_a;

    /**
     * @param savedInstanceState
     */
    @SuppressLint({"SetTextI18n", "CutPasteId"})
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_t);
        ButterKnife.bind(this);

        mMsgBegin = findViewById(R.id.msg_begin);
        mEdtKdFs = findViewById(R.id.edt_kd_fs);
        mKdydl = findViewById(R.id.kdydl);
        mInputAddress = findViewById(R.id.input_address);
        mUseCode = findViewById(R.id.useCode);
        mInputGetnum = findViewById(R.id.input_getnum);
        mKdydgh = findViewById(R.id.kdydgh);
        mInputPh = findViewById(R.id.input_ph);
        mYiyuan = findViewById(R.id.yiyuan);
        mSend = findViewById(R.id.send);

        TextView cm = findViewById(R.id.companyName);
        kd_cm = findViewById(R.id.edt_kd_fs);
        get_num = findViewById(R.id.get_num);
        get_num.setChecked(true);
        getnum_edt = findViewById(R.id.getNum_edt_num);
        txt_get_code = findViewById(R.id.tx_get_code_yt);
        fsts_txt = findViewById(R.id.fsts_txt);
        det_get_num_a = findViewById(R.id.getNum_edt);
        Intent i = getIntent();


        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String message = simpleDateFormat.format(date);

        mTodayDate.setText(message);
        assert companyName != null;
        companyName = i.getStringExtra("companyName");
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        initData();
        //show
        // 对应的公司短信条数

        @SuppressLint("InflateParams") final View convertView = LayoutInflater.from(this).inflate(R.layout.yt_list_item,
                null);


        final ArrayList<Map<String, Object>> arr_data = new ArrayList<>();
        APPData appData = (APPData) getApplicationContext();
        // 新增数据
        //test
        //appData.i= 1 ;
        //appData.phoneNumber_scan[0] = String.valueOf(1);
        //select qz
        appData.pro = message + det_get_num_a.getText().toString();
        for (int index = 0; index < appData.i; index++) {
            //get取货码
            appData.qhm[index] = appData.i;
        }
        try {
            for (int i5 = 0; i5 < appData.i; i5++) {
                Map map = new HashMap<String, Object>();
                //map放入两个键值对，键名与from对应，
                map.put("pn", appData.phoneNumber_scan[i5]);
                appData.qhm[i5] -= i5;
                map.put("qhm", appData.qhm[i5]);
                //往list添加数据
                arr_data.add(map);
            }
            // String msg = String.valueOf(appData.i);
            getnum_edt.setText(msg);
            //  System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 新建适配器 ，绑定数据
        final String[] from = {"pn", "qhm"};
        final int[] to = {R.id.phone_number, R.id.stepper};

        simp_ada = new SimpleAdapter(this, arr_data, R.layout.yt_list_item, from, to);
        ListView listView = findViewById(R.id.yt_listview);
        listView.setAdapter(simp_ada);

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
                //数据清空
                appData.count += 1;
                startActivity(i);
            }
        });

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YTActivity.this.onClick();
            }
        });

    }

    /**
     * 发送短信页面
     *
     * @param
     */

    public void onClick() {

        APPData appData = (APPData) getApplicationContext();
        if (msg_count <= appData.i) {
            final Context context = this;
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle("提示")
                    .setIcon(android.R.drawable.sym_def_app_icon)
                    .setMessage("您的短信条数不足！")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context, "确认", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context, "取消", Toast.LENGTH_SHORT).show();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
        msg = mMsgBegin.getText().toString() + mEdtKdFs.getText().toString() + mKdydl.getText().toString()
                + mInputAddress.getText().toString() + mUseCode.getText().toString() +
                mInputGetnum.getText().toString() + mKdydgh.getText().toString() +
                mInputPh.getText().toString() + mYiyuan.getText().toString();
        System.out.println(msg);
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
                            msg_count = appData.smsCount_yt[k];
                        }
                    }
                } catch (JSONException ex) {

                    Log.e("JSON Error: ", ex.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void onValueChange(@NonNull View view, int value) {


        APPData appData = (APPData) getApplicationContext();
        appData.i = 2;

    }

    @OnClick(R.id.today_date)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.today_date:

                break;
        }
    }
}