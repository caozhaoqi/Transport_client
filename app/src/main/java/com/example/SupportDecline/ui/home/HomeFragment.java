package com.example.SupportDecline.ui.home;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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

import com.example.SupportDecline.APPData;
import com.example.SupportDecline.Constant;
import com.example.SupportDecline.R;
import com.example.SupportDecline.YTActivity;
import com.example.SupportDecline.ui.login.ParamBean;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    LinearLayout linearLayout;
    List<String> list = new ArrayList<>();
    APPData appData;

    /**
     * {@inheritDoc}
     */
    @NonNull
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {


        root = inflater.inflate(R.layout.fragment_home, container, false);

        linearLayout = root.findViewById(R.id.addli);

        appData = (APPData) getActivity().getApplicationContext();


        try {
            //显示需要显示的按钮
            assert appData.logisticsName != null;
            list.addAll(Arrays.asList(appData.logisticsName).subList(0, appData.s_length));

            setButton(list);

        } catch (Exception e) {

            e.printStackTrace();
            Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();


        }
        @SuppressLint("CutPasteId")

        final ImageView im = root.findViewById(R.id.img_add);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
     * @param list data list
     * @serialData show select button
     **/

    private void setButton(final List<String> list) {

        if (list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {

                Button btn = new Button(getActivity());
                //btn.setLayoutParams(linearLayout.getLayoutParams());
                btn.setText(list.get(i));
                btn.setBackgroundColor(Color.WHITE);
                btn.setTag(i);
                final int finalI = i;
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getContext(), YTActivity.class);
                        assert appData.logisticsName != null;
                        intent.putExtra("companyName", appData.logisticsName[finalI]);
                        startActivity(intent);
                    }
                });
                linearLayout.addView(btn);

            }
        }
    }


    /**
     * show dialog
     *
     * @param
     * @return null
     */

    public void showSingleAlertDialog() {

        final APPData appData = (APPData) getContext().getApplicationContext();
        final String[] items = appData.logisticsNames;
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
        alertBuilder.setTitle("请选择快递公司");
        alertBuilder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {

                assert items != null;
                Toast.makeText(getContext(), items[position], Toast.LENGTH_SHORT).show();

                final LinearLayout linearLayout = root.findViewById(R.id.addli);
                final Button button = new Button(getContext());

                APPData appData1 = (APPData) getActivity().getApplicationContext();
                appData1.index[position] += 1;

                assert appData.logisticsNames != null;
                String cm = appData.logisticsNames[position];
                for (int i = 0; i < appData1.logisticsName.length; i++) {

                    assert appData1.logisticsId != null;
                    if (appData1.logisticsId[i] != 0) {// 2  3
                        appData1.index[appData1.logisticsId[i] - 1] += 1;
                    }
                }
                if (appData1.index[position] > 1) {

                    Toast.makeText(getContext(), "已经添加", Toast.LENGTH_SHORT).show();

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
                            appData.clickId = position;
                            startActivity(i);

                        }
                    });
                }

            }
        });
        alertBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                /* User clicked Cancel so do some stuff */
                Toast.makeText(getActivity(), "取消", Toast.LENGTH_LONG).show();
            }
        })
                .create();
        alertBuilder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                assert appData.logisticsNames != null;


                assert appData.idss != null;
                int logisticsId = appData.idss[appData.clickId];
                int servicesUserCpId = appData.id;
                int id = 0;
                int smsCount = 0;
                addCompany(id, logisticsId, servicesUserCpId, smsCount);
                Toast.makeText(getActivity(), "确认", Toast.LENGTH_LONG).show();

            }
        }).create();
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