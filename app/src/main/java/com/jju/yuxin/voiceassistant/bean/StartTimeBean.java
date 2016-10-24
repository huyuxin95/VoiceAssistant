package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 2:32.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class StartTimeBean {


    /**
     * date : 2016-10-22
     * type : DT_BASIC
     * dateOrig : 明天
     */
    /**
     * 播放日期/date
     */
    private String date;

    private String type;
    private String dateOrig;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateOrig() {
        return dateOrig;
    }

    public void setDateOrig(String dateOrig) {
        this.dateOrig = dateOrig;
    }

    @Override
    public String toString() {
        return "StartTimeBean{" +
                "date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", dateOrig='" + dateOrig + '\'' +
                '}';
    }
}
