package com.example.transportclient.ui.login;

public class ParamBean {
    String phone;
    String code;
    String createTime;
    int smsNumber = 0;
    int id = 0;

    public ParamBean() {

    }

    public ParamBean(String createTime, int id, String phone, int smsNumber) {
        this.phone = phone;
        this.createTime = createTime;
        this.smsNumber = smsNumber;
        this.id = id;
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
