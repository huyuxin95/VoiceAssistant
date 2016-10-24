package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 2:28.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class WebPageBean {

    /**
     * header : 为您找到下面的结果
     * url : http://kcbj.openspeech.cn/service/iss?wuuid=b773a2b9fb113d2ae1a05e24c7ce73a6&ver=2.0&method=webPage&uuid=3e8ba219428bcebb66f821a3f4400039query
     */

    private String header;
    private String url;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WebPageBean{" +
                "header='" + header + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
