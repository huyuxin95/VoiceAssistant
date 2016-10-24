package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 2:48.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class DateTimeBean {


    /**
     * dateOrig : 明天
     * type : DT_BASIC
     * time : 15:00:00
     * timeOrig : 下午3点
     * date : 2016-10-22
     */

    private String dateOrig;
    private String type;
    private String time;
    private String timeOrig;
    private String date;

    public String getDateOrig() {
        return dateOrig;
    }

    public void setDateOrig(String dateOrig) {
        this.dateOrig = dateOrig;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeOrig() {
        return timeOrig;
    }

    public void setTimeOrig(String timeOrig) {
        this.timeOrig = timeOrig;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DateTimeBean{" +
                "date='" + date + '\'' +
                ", dateOrig='" + dateOrig + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", timeOrig='" + timeOrig + '\'' +
                '}';
    }
}
