package com.example.transportclient;

import android.app.Application;

import androidx.annotation.NonNull;

public class APPData extends Application {
    @NonNull
    public String code;//login_code
    @NonNull
    public String code2;//register_code
    @NonNull
    public String re_msg;//register server return message
    @NonNull
    public String phoneNumber;//login account number
    @NonNull
    public int id;//kdy_id serverUserCpID
    @NonNull
    public int[] ids;
    @NonNull
    public int[] logisticsId;
    @NonNull
    public int[] smsCount;
    @NonNull
    public String[] logisticsName;
    @NonNull
    public int s_length;
   @NonNull
   public int[] idss;
   @NonNull
   public String[] logisticsNames;
   @NonNull
   public int s_lengths;
}
