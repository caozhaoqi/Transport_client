package com.example.SupportDecline;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
/**
 * 支付历史页面
 */
public class PayHistoryActivity extends AppCompatActivity {


    TextView send_successful;
    EditText begin;
    EditText end;
    TimePickerView pvTime;
    ListView listView;
    TextView send_fail;
    @BindView(R.id.search)
    Button mSearch;
    @BindView(R.id.lisview_ph)
    ListView mLisviewPh;
    private TextView mDateItemPh;
    private TextView mDatePhDe;
    private TextView mSendSuccessful;
    private TextView mSendFail;


    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_history);


        begin = findViewById(R.id.date_begin);
        end = findViewById(R.id.date_end);
        listView = findViewById(R.id.lisview_ph);
        String[] data = new String[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = "" + i;
        }

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
        SimpleAdapter simp_ada = new SimpleAdapter(this, arr_data, R.layout.list_item_ph, from, to);

        listView.setAdapter(simp_ada);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pvTime.show(begin);
            }
        });
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2013, 0, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2029, 11, 28);
        //时间选择器
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                TextView btn = (TextView) v;
                btn.setText(getTimes(date));
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "", "")
                .isCenterLabel(true)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setDecorView(null)
                .build();


        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pvTime.show(end);
            }
        });

        send_successful = findViewById(R.id.send_successful_ph);

        send_successful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PayHistoryActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });

        send_fail = findViewById(R.id.send_fail_ph);

        send_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PayHistoryActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });
    }

    /**
     * @param date getDate
     */
    private String getTimes(Date date) {//可根据需要自行截取数据显示
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public void initView() {
    }

    @butterknife.OnClick({R.id.send_successful_ph, R.id.send_fail_ph, R.id.date_begin, R.id.date_end, R.id.search, R.id.lisview_ph})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.send_successful_ph:
                break;
            case R.id.send_fail_ph:
                break;
            case R.id.date_begin:
                break;
            case R.id.date_end:
                break;
            case R.id.search:
                break;
            case R.id.lisview_ph:
                break;
        }
    }
}
