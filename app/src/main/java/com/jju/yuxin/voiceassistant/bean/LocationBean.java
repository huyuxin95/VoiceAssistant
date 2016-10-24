package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 2:37.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class LocationBean {


    /**
     * cityAddr : 北京
     * city : 北京市
     * type : LOC_BASIC
     */

    private String cityAddr;
    private String city;
    private String type;


    /**
     * poi : 上海城隍庙
     */

    private String poi;
    /**
     * areaAddr : 广丰
     * area : 广丰区
     */

    private String areaAddr;
    private String area;

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

    public String getPoi() {
        return poi;
    }

    public void setPoi(String poi) {
        this.poi = poi;
    }


    public String getAreaAddr() {
        return areaAddr;
    }

    public void setAreaAddr(String areaAddr) {
        this.areaAddr = areaAddr;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "LocationBean{" +
                "area='" + area + '\'' +
                ", cityAddr='" + cityAddr + '\'' +
                ", city='" + city + '\'' +
                ", type='" + type + '\'' +
                ", poi='" + poi + '\'' +
                ", areaAddr='" + areaAddr + '\'' +
                '}';
    }
}
