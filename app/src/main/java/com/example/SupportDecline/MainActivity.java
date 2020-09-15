package com.example.SupportDecline;

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
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 *
 *     Copyright (c) 2020 czq <16602629614@163.com>
 *     Github：https://github.com/1120118968
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *     @author czq
 * 作者：czq
 * 创建时间：2020/9/2 11:39 <p>
 * 描述：
 * @name TranSportClient
 * @class name：PACKAGE_NAME
 * @class describe
 * @author Administrator QQ:1150118968
 * @time 2020/9/2 12:00
 * @change
 * @chang time
 * @class describe
 */
public class MainActivity extends AppCompatActivity {

    /**
     * {@inheritDoc}
     */
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
     * select all transport company data
     */

    public void companySelect() {

        String url = Constant.fog + Constant.IP + ":" + Constant.PORT + "/server/logistics/findAll";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
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

                        System.out.println("data error or account not exists");

                    } else {
                        //然后读取result后面的数组([]号里的内容)，用这个内容来初始化一个JSONArray对象

                        int[] id = new int[jsonArray.length()];
                        String[] logisticsName = new String[jsonArray.length()];
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            id[i] = jsonObject1.getInt("id");
                            logisticsName[i] = jsonObject1.getString("logisticsName");

                        }

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