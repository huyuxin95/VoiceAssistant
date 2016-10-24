package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 2:54.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class AnswerBean {


    /**
     * text : 诶，心情不好，没什么胃口。
     * type : T
     */

    private String text;
    private String type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AnswerBean{" +
                "text='" + text + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
