package com.example.transportclient;

import android.os.Bundle;
import android.widget.Toast;

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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 */
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

        ////调用快递公司data
        companySelect();

    }

    /**
     * select all delver company
     */

    public void companySelect() {

        String url = "http://" + Constant.IP + ":" + Constant.PORT + "/server/logistics/findAll";
        String json = "";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        //  RequestBody requestBody = FormBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                //    .post(requestBody)
                .build();
        Call call2 = client.newCall(request);
        call2.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this, "internet error", Toast.LENGTH_SHORT).show();
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