package com.example.transportclient.ui.login;

import androidx.annotation.NonNull;

public class ParamBean {
    private String phone;
    private String code;
    private String createTime;
    private int smsNumber;
    private int id;
    private int logisticsId;
    private int serviceUserCpId;
    private int smsCount;

    public ParamBean(int id, int logisticsId, int serviceUserCpId, int smsCount) {
        this.id = id;
        this.logisticsId = logisticsId;
        this.serviceUserCpId = serviceUserCpId;
        this.smsCount = smsCount;
    }

    public ParamBean(int logisticsId, int serviceUserCpId) {
        this.logisticsId = logisticsId;
        this.serviceUserCpId = serviceUserCpId;
    }

    public ParamBean(@NonNull String createTime, int id, @NonNull String phone, int smsNumber) {
        this.phone = phone;
        this.createTime = createTime;
        this.smsNumber = smsNumber;
        this.id = id;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public ParamBean() {

    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public int getlogisticsId() {
        return logisticsId;
    }

    public void setlogisticsId(int logisticsId) {
        this.logisticsId = logisticsId;
    }

    public int getserviceUserCpId() {
        return serviceUserCpId;
    }

    public void setserviceUserCpId(int serviceUserCpId) {
        this.serviceUserCpId = serviceUserCpId;
    }

    public ParamBean(String code) {
        this.code = code;
    }

    public ParamBean(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(int smsNumber) {
        this.smsNumber = smsNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
