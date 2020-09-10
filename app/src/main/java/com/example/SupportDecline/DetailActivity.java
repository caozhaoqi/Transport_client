package com.example.SupportDecline;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.SupportDecline.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private static final int SEND_SMS = 100;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        // tabs.setSelectedTabIndicator(1);
        tabs.setScrollPosition(1, 1, false);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    void requestPermission() {
        //判断Android版本是否大于23
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS);
            } else {
                sendSMSS();
                //已有权限
            }
        }  //API 版本在23以下

    }

    /**
     * 注册权限申请回调
     *
     * @param requestCode  申请码
     * @param permissions  申请的权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == SEND_SMS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSMSS();
            } else {
                // Permission Denied
                Toast.makeText(DetailActivity.this, "CALL_PHONE Denied", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    //发送短信
    @SuppressLint("UnlocalizedSms")
    private void sendSMSS() {
//        String content = edContent.getText().toString().trim();
//        String phone = edPhone.getText().toString().trim();
        //if (!StringUtil.isEmpty(content) && !StringUtil.isEmpty(phone)) {
        SmsManager manager = SmsManager.getDefault();
        ArrayList<String> strings = manager.divideMessage("content");
        for (int i = 0; i < strings.size(); i++) {
            manager.sendTextMessage("1111111", null, "hello ", null, null);
        }
        Toast.makeText(DetailActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
        //   } else {
        //        // Toast.makeText(this, "手机号或内容不能为空", Toast.LENGTH_SHORT).show();
        //        //return;
        //        // }

    }

}