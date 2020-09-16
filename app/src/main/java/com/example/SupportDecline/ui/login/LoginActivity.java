package com.example.SupportDecline.ui.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.SupportDecline.APPData;
import com.example.SupportDecline.Constant;
import com.example.SupportDecline.MainActivity;
import com.example.SupportDecline.R;
import com.example.SupportDecline.SystemMemory;

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
/**
 * 登录页面
 */
public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    EditText passwordEditText;
    EditText usernameEditText;

    /**
     * @param savedInstanceState state
     */
    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        TextView getCode = findViewById(R.id.tx_get_code);

        String availMemory = SystemMemory.getAvailMemory(this);
        //当前总运行内存
        String totalMemory = SystemMemory.getTotalMemory(this);

        Toast.makeText(LoginActivity.this, "当前可用内存" + availMemory + "总内存" + totalMemory, Toast.LENGTH_LONG).show();


        getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取手机号对应验证码
                //Get请求
                String param3 = usernameEditText.getText().toString();
                //获取服务器data数据 为json形式
                String url = "http://" + Constant.IP + ":" + Constant.PORT +
                        "/server/send/sms?phone=" + param3;
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Call call2 = client.newCall(request);
                call2.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
//                        Toast.makeText(LoginActivity.this, "internet error",
//                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result2 = response.body().string();
                        try {

                            JSONObject jsonObject = new JSONObject(result2);
                            String code = jsonObject.getString("randomNumeric");

                            APPData appData = (APPData) getApplicationContext();
                            appData.code = code;

                        } catch (JSONException ex) {

                            Log.e("JSON Error: ", ex.toString());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });
            }
        });

        /**
         * @deprecated date 2020 08 21
         *
         * register api
         *
         * */
//        TextView re = findViewById(R.id.register_re);
//        re.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(i);
//            }
//        });


        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) updateUiWithUser(loginResult.getSuccess());
                setResult(Activity.RESULT_OK);


                //Complete and destroy login activity once successful
                //  finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @SuppressLint("SyntheticAccessor")
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SyntheticAccessor")
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
                String phone = usernameEditText.getText().toString();

                //调用查询id接口

                final String param3 = usernameEditText.getText().toString();

                String url = "http://" + Constant.IP + ":" + Constant.PORT +
                        "/server/serviceUserCourierPoint/findByPhone?phone=" + param3;
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
                        Looper.prepare();
                        Toast.makeText(LoginActivity.this, "internet error",
                                Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                        System.out.println("error login");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result2 = response.body().string();
                        try {

                            //用JSON字符串来初始化一个JSON对象
                            JSONObject jsonObject = new JSONObject(result2);
                            //然后读取result后面的数组([]号里的内容)，用这个内容来初始化一个JSONArray对象
                            JSONObject jsonObject1 = jsonObject.getJSONObject("msg");
                            int id = jsonObject1.getInt("id");

                            APPData appData = (APPData) getApplicationContext();
                            appData.id = id;
                            appData.phoneNumber = param3;

                            initHomeData();
                        } catch (JSONException ex) {

                            Log.e("JSON Error: ", ex.toString());

                        } catch (Exception ignored) {

                        }


                    }

                });

                // call select data api

            }
        });
    }

    /**
     * @since 2020 08 20
     */

    private void initHomeData() {

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
                Toast.makeText(LoginActivity.this, "internet error",
                        Toast.LENGTH_SHORT).show();
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
                        int[] logisticsId = new int[jsonArray.length()];
                        int[] smsCount = new int[jsonArray.length()];
                        String[] logisticsName = new String[jsonArray.length()];
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            id[i] = jsonObject1.getInt("id");
                            logisticsId[i] = jsonObject1.getInt("logisticsId");
                            smsCount[i] = jsonObject1.getInt("smsCount");
                            logisticsName[i] = jsonObject1.getString("logisticsName");


                        }
                        APPData appData = (APPData) getApplicationContext();
                        appData.ids = id;
                        appData.logisticsId = logisticsId;
                        appData.smsCount = smsCount;
                        appData.logisticsName = logisticsName;
                        appData.s_length = jsonArray.length();


                    }
                    String code = passwordEditText.getText().toString();
                    if (code.equals(appData.code)) {
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        String ids = String.valueOf(appData.id);
                        i.putExtra("id", ids);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        String ids = String.valueOf(appData.id);
                        i.putExtra("id", ids);
                        startActivity(i);
                        Looper.prepare();
//                            Toast.makeText(LoginActivity.this, "验证码错误，请重新输入",
//                                    Toast.LENGTH_SHORT).show();
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
     * @param model fragment model
     **/
    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome);// + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    /**
     * @param errorString error
     */
    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}