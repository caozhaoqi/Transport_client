package com.example.transportclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PayRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_record);

        ListView mlistView = (ListView) findViewById(R.id.listView);
        String[] films = new String[0];
        final TitleAdapter titleAdapter = new TitleAdapter(LayoutInflater.from(this), films);
        mlistView.setAdapter(titleAdapter);

    }
}