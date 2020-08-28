package com.example.transportclient;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        //home page paint
        //   home();

        ////调用快递公司data
        kdgscx();

    }

    /**
     * 显示并刷新主页数据
     * *
     **/
    public void home() {

        LayoutInflater inflater = getLayoutInflater();

        View root = LayoutInflater.from(getApplicationContext()).inflate(R.layout.fragment_home, null, false);// inflater.inflate(R.layout.fragment_home, container, false);

        final LinearLayout linearLayout = root.findViewById(R.id.addli);
        final APPData appData = (APPData) getApplicationContext();
        Button[] button = new Button[appData.s_length];
        //显示需要显示的按钮
        for (int i = 0; i < appData.s_length; i++) {
            button[i] = new Button(this);
            button[i].setText(appData.logisticsName[i]);
            button[i].setTextSize(24);

            final int index = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, YTActivity.class);
                    intent.putExtra("kdgsc", appData.logisticsName[index]);
                    startActivity(intent);
                }
            });
            linearLayout.addView(button[i]);
        }

        @SuppressLint("CutPasteId") final LinearLayout linearLayout2 = root.findViewById(R.id.addli);
        //显示添加按钮
        final ImageView im = new ImageView(this);


        im.setBackgroundColor(Color.BLUE);

        //快递公司查询 接口 得到数据
        kdgscx();

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Button button = new Button(getApplicationContext());
                final EditText et = new EditText(getApplicationContext());
                new AlertDialog.Builder(getApplicationContext()).setTitle("请输入快递公司名称")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //按下确定键后的事件
                                Toast.makeText(MainActivity.this, et.getText().toString(), Toast.LENGTH_LONG).show();
                                button.setText(et.getText().toString());
                            }
                        }).setNegativeButton("取消", null).show();
                button.setTextSize(24);
                //  im.setVisibility(View.INVISIBLE);
                linearLayout2.addView(button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO other
                        Intent i = new Intent(MainActivity.this, YTActivity.class);
                        i.putExtra("companyName", button.getText().toString());
                        startActivity(i);
                    }
                });
            }
        });
        linearLayout2.addView(im);


    }

    /**
     * select all delver company
     */
    private void kdgscx() {

        String url = "http://" + Constant.IP + ":" + Constant.PORT + "/server/logistics/findAll";
        String json = "";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = FormBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                //    .post(requestBody)
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
                    JSONArray jsonArray = new JSONArray(result2);
                    if (jsonArray.length() == 0) {
                        System.out.println("error");
                    } else {
                        //然后读取result后面的数组([]号里的内容)，用这个内容来初始化一个JSONArray对象

                        int[] id = new int[jsonArray.length()];
                        String[] logisticsName = new String[jsonArray.length()];
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            id[i] = jsonObject1.getInt("id");
                            logisticsName[i] = jsonObject1.getString("logisticsName");
                            //  JSONArray aNews = new JSONArray(jsonObject.getString("data"));
                        }
                        // Log.i("the title: ", aNews.getJSONObject(0).getString("image"));


                        APPData appData = (APPData) getApplicationContext();
                        appData.idss = id;
                        appData.logisticsNames = logisticsName;
                        appData.s_lengths = jsonArray.length();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}