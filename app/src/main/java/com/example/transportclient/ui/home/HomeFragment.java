package com.example.transportclient.ui.home;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.transportclient.APPData;
import com.example.transportclient.Constant;
import com.example.transportclient.R;
import com.example.transportclient.YTActivity;
import com.example.transportclient.ui.login.ParamBean;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeFragment extends Fragment {

    View root;

    @NonNull
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);


        final LinearLayout linearLayout = root.findViewById(R.id.addli);
        final APPData appData = (APPData) getActivity().getApplicationContext();
        Button[] button = new Button[appData.s_length];

        //显示需要显示的按钮
        for (int i = 0; i < appData.s_length; i++) {
            button[i] = new Button(getContext());
            button[i].setText(appData.logisticsName[i]);
            button[i].setTextSize(24);
            //   button[i].setBackgroundColor(Color.BLUE);

            final int index = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), YTActivity.class);
                    intent.putExtra("companyName", appData.logisticsName[index]);
                    startActivity(intent);
                }
            });
            linearLayout.addView(button[i]);
        }
        @SuppressLint("CutPasteId")

        final ImageView im = root.findViewById(R.id.img_add);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] index = new int[100];//record click add company count
                try {
                    showSingleAlertDialog();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        return root;
    }

    /**
     * show dialog
     *
     * @param
     * @return null
     */

    public void showSingleAlertDialog() throws Exception {

        final APPData appData = (APPData) getContext().getApplicationContext();
        final String[] items = appData.logisticsNames;
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
        alertBuilder.setTitle("请选择快递公司");
        alertBuilder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getContext(), items[i], Toast.LENGTH_SHORT).show();

                final LinearLayout linearLayout = root.findViewById(R.id.addli);
                final Button button = new Button(getContext());
                String cm = appData.logisticsNames[i];

                int logisticsId = appData.id;
                int servicesUserCpId = appData.idss[i];
                APPData appData1 = (APPData) getActivity().getApplicationContext();
                appData1.index[i] += 1;
                int id = 0;
                int smsCount = 0;
                addCompany(id, logisticsId, servicesUserCpId, smsCount);

                if (appData1.index[i] > 1) {

                    Toast.makeText(getContext(), "已经添加", Toast.LENGTH_SHORT).show();
                    //  button.setVisibility(View.INVISIBL
                    if (getActivity().isFinishing()) {
                        System.exit(0);
                    }

                } else {

                    //第一次添加
                    button.setText(cm);
                    linearLayout.addView(button);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            // TODO other
                            Intent i = new Intent(getContext(), YTActivity.class);
                            i.putExtra("companyName", button.getText().toString());
                            startActivity(i);

                        }
                    });
                }

            }
        });

        alertBuilder.show();

    }

    /**
     * *
     *
     * @param id
     * @param logisticsId
     * @param servicesUserCpId
     * @param smsCount
     * @return null
     */

    void addCompany(int id, int logisticsId, int servicesUserCpId, int smsCount) {
        String url2 = "http://" + Constant.IP + ":" + Constant.PORT + "" +
                "/server/serviceUserLogistics";

        ParamBean paramBean = new ParamBean(id, logisticsId, servicesUserCpId, smsCount);
        OkHttpClient client2 = new OkHttpClient();
        Gson gson = new Gson();
        String json = gson.toJson(paramBean);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = FormBody.create(mediaType, json);
        Request request2 = new Request.Builder()
                .url(url2)
                .post(requestBody)
                .build();
        Call call = client2.newCall(request2);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //  Toast.makeText(getActivity(),"internet error",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result2 = response.body().string();
                if (result2.equals("1")) {
                    System.out.println("successful");
                    Looper.prepare();
                    Toast.makeText(getActivity(), "successful", Toast.LENGTH_SHORT).show();
                } else {
                    try {


                        //用JSON字符串来初始化一个JSON对象
                        JSONArray jsonArray = new JSONArray(result2);
                        if (jsonArray.length() == 0) {
                            System.out.println("error");
                        } else {
                            //然后读取result后面的数组([]号里的内容)，用这个内容来初始化一个JSONArray对象
                            System.out.println("successful");

                        }

                    } catch (JSONException ex) {

                        Log.e("JSON Error: ", ex.toString());

                    } catch (Exception ignored) {

                    }

                }
            }

        });
    }


}