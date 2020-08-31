package com.example.transportclient;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class APPData extends Application {
    @Nullable
    public String code;//login_code
    @Nullable
    public String code2;//register_code
    @Nullable
    public String re_msg;//register server return message
    @Nullable
    public String phoneNumber;//login account number

    public int id;//kdy_id serverUserCpID
    @Nullable
    public int[] ids;//login id
    @Nullable
    public int[] logisticsId;
    @Nullable
    public int[] smsCount;
    @Nullable
    public String[] logisticsName;

    public int s_length;
    @Nullable
    public int[] idss;//select id
    @Nullable
    public String[] logisticsNames;

    public int s_lengths;
    @NonNull
    public int[] index = new int[100];//array index logistic id
}
