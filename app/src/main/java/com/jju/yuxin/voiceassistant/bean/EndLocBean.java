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

public class EndLocBean {

    private String type;
    private String city;
    private String poi;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi;
    }

    @Override
    public String toString() {
        return "EndLocBean{" +
                "city='" + city + '\'' +
                ", type='" + type + '\'' +
                ", poi='" + poi + '\'' +
                '}';
    }
}
