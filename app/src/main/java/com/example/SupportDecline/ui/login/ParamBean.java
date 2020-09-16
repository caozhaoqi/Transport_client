package com.example.SupportDecline.ui.login;

import androidx.annotation.NonNull;
/**
 * okhttp 发送所需参数
 */

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

    /**
     * Constructs a new ParamBean.
     */
    public ParamBean() {

    }

    /**
     * Getter for property 'smsCount'.
     *
     * @return Value for property 'smsCount'.
     */
    public int getSmsCount() {
        return smsCount;
    }

    /**
     * Setter for property 'smsCount'.
     *
     * @param smsCount Value to set for property 'smsCount'.
     */
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

    public ParamBean(@NonNull String code) {
        this.code = code;
    }

    public ParamBean(@NonNull String phone, @NonNull String code) {
        this.phone = phone;
        this.code = code;
    }

    /**
     * Getter for property 'createTime'.
     *
     * @return Value for property 'createTime'.
     */
    @NonNull
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Setter for property 'createTime'.
     *
     * @param createTime Value to set for property 'createTime'.
     */
    public void setCreateTime(@NonNull String createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter for property 'smsNumber'.
     *
     * @return Value for property 'smsNumber'.
     */
    public int getSmsNumber() {
        return smsNumber;
    }

    /**
     * Setter for property 'smsNumber'.
     *
     * @param smsNumber Value to set for property 'smsNumber'.
     */
    public void setSmsNumber(int smsNumber) {
        this.smsNumber = smsNumber;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for property 'phone'.
     *
     * @return Value for property 'phone'.
     */
    @NonNull
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for property 'phone'.
     *
     * @param phone Value to set for property 'phone'.
     */
    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    /**
     * Getter for property 'code'.
     *
     * @return Value for property 'code'.
     */
    @NonNull
    public String getCode() {
        return code;
    }

    /**
     * Setter for property 'code'.
     *
     * @param code Value to set for property 'code'.
     */
    public void setCode(@NonNull String code) {
        this.code = code;
    }
}
