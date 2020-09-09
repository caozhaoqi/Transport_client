package com.example.SupportDecline.data;

import org.codehaus.jackson.annotate.JsonProperty;

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
 * 创建时间：2020/9/9 11:04 <p>
 * 描述：
 * @name TranSportClient
 * @class name：com.example.SupportDecline.data
 * @class describe
 * @author Administrator QQ:1150118968
 * @time 2020/9/9 11:04
 * @change
 * @chang time
 * @class describe
 */
public class List {
    @JsonProperty("logisticsId")
    private int logisticsId;
    private String phone;
    @JsonProperty("pickCode")
    private String pickCode;
    @JsonProperty("serviceUserCpId")
    private int serviceUserCpId;


    public List(int logisticsId, String phone, String pickCode, int serviceUserCpId) {
        this.logisticsId = logisticsId;
        this.phone = phone;
        this.pickCode = pickCode;
        this.serviceUserCpId = serviceUserCpId;
    }


    public void setlogisticsId(int logisticsId) {
        this.logisticsId = logisticsId;
    }

    public int getlogisticsId() {
        return logisticsId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setpickCode(String pickCode) {
        this.pickCode = pickCode;
    }

    public String getpickCode() {
        return pickCode;
    }

    public void setserviceUserCpId(int serviceUserCpId) {
        this.serviceUserCpId = serviceUserCpId;
    }

    public int getserviceUserCpId() {
        return serviceUserCpId;
    }

}
