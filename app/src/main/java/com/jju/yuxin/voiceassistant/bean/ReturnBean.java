package com.jju.yuxin.voiceassistant.bean;

import android.support.v4.view.PagerTitleStrip;

import org.json.JSONObject;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 12:44.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class ReturnBean {


    /**
     * slots : {"content":"我明天去找你"}
     */

    private SemanticBean semantic;

    private DataBean data;

    private WebPageBean webPage;
    /**
     * semantic : {"slots":{"content":"我明天去找你"}}
     * rc : 0
     * operation : SEND
     * service : message
     * text : 发留言给张三内容是我明天去找你
     */

    private int rc;
    private String operation;
    private String service;
    private String text;

    private AnswerBean answer;

    public SemanticBean getSemantic() {
        return semantic;
    }

    public void setSemantic(SemanticBean semantic) {
        this.semantic = semantic;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AnswerBean getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerBean answer) {
        this.answer = answer;
    }


    public WebPageBean getWebPage() {
        return webPage;
    }

    public void setWebPage(WebPageBean webPage) {
        this.webPage = webPage;
    }

    @Override
    public String toString() {
        return "ReturnBean{" +
                "answer=" + answer +
                ", semantic=" + semantic +
                ", data=" + data +
                ", webPage=" + webPage +
                ", rc=" + rc +
                ", operation='" + operation + '\'' +
                ", service='" + service + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
