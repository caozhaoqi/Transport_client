package com.example.transportclient;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.transportclient.ui.login.ParamBean;
import com.google.gson.Gson;

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

public class RegisterActivity extends AppCompatActivity {

    Button re;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        re = findViewById(R.id.register);

        final TextView getCode = findViewById(R.id.code);
        final TextView ph = findViewById(R.id.re_ph);
        final TextView code = findViewById(R.id.tx_get_code_re);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取手机号对应验证码
                //Get请求
                String param3 = ph.getText().toString();
                ParamBean paramBean = new ParamBean();
                //获取服务器data数据 为json形式
                Gson gson = new Gson();
                String url = "http://" + Constant.IP + ":" + Constant.PORT + "/server/send/sms?phone=" + param3;
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
                            JSONObject jsonObject = new JSONObject(result2);
                            //然后读取result后面的数组([]号里的内容)，用这个内容来初始化一个JSONArray对象
                            String code2 = jsonObject.getString("randomNumeric");

                            APPData appData = (APPData) getApplicationContext();
                            appData.code2 = code2;
                        } catch (JSONException ex) {

                            Log.e("JSON Error: ", ex.toString());

                        } catch (Exception e) {

                        }


                    }

                });
            }
        });

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                APPData appData = (APPData) getApplicationContext();
                String code = getCode.getText().toString();
                if (code.equals(appData.code2)) {
                    // Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    //调用登陆接口传递所需数据

                    String createTime = "";
                    String phone = ph.getText().toString();
                    int smsNumber = 0;
                    int id = 0;
                    ParamBean paramBean = new ParamBean(createTime, id, phone, smsNumber);
                    //获取服务器data数据 为json形式
                    Gson gson = new Gson();
                    String url = "http://" + Constant.IP + ":" + Constant.PORT + "/server/serviceUserCourierPoint/add";
                    String json = gson.toJson(paramBean);
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
                                String code = jsonObject.getString("msg");
                                APPData appData1 = (APPData) getApplicationContext();
                                appData1.re_msg = code;
                                //  JSONArray aNews = new JSONArray(jsonObject.getString("data"));

                                // Log.i("the title: ", aNews.getJSONObject(0).getString("image"));


                            } catch (JSONException ex) {

                                Log.e("JSON Error: ", ex.toString());

                            } catch (Exception e) {

                            }


                        }

                    });
                    try {
                        APPData appDat = (APPData) getApplicationContext();
                        if (appDat.re_msg.equals("添加成功")) {
                            startActivity(i);
                        } else if (appDat.re_msg.equals("当前账号已存在")) {
                            Toast.makeText(RegisterActivity.this, "您已注册", Toast.LENGTH_SHORT).show();
                            startActivity(i);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "验证码错误，请重新输入", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}