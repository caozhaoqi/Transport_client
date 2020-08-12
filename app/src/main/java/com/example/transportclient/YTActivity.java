package com.example.transportclient;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class YTActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_t);


//        ImageButton ib = (ImageButton) findViewById(R.id.fab);
//        int diameter = getResources().getDimensionPixelSize(R.dimen.fab_size);
//        System.out.println("Diameter ["+diameter+"]");
//        Outline outline = new Outline();
//        outline.setOval(0, 0, diameter, diameter);
//        //ib.setOutline(outline);
//
//        ib.setClipToOutline(true);


    }
}