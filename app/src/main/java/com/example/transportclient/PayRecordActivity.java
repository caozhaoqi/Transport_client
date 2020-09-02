package com.example.transportclient;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PayRecordActivity extends AppCompatActivity {


    List<String> list;
    private ListView mListView;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_record);

        mListView = findViewById(R.id.listView);
        initListView();

    }

    private void initListView() {
        list = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            list.add(" " + i);
        }
        mListView.setAdapter(new MyAdapter(this, list));

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    //如果垂直滑动，则需要关闭已经打开的layout
                    SwipeLayoutManager.getInstance().closeCurrentLayout();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    public void initView() {
    }
}