package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 2:45.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class StartLocBean {

    private String cityAddr;
    private String city;
    private String type;

    public String getCityAddr() {
        return cityAddr;
    }

    public void setCityAddr(String cityAddr) {
        this.cityAddr = cityAddr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "StartLocBean{" +
                "city='" + city + '\'' +
                ", cityAddr='" + cityAddr + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
