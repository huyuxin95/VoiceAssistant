package com.jju.yuxin.voiceassistant.bean;

import java.util.List;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 2:02.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class DataBean {


    /**
     * singer : 刘德华
     * sourceName : 自产音乐
     * name : 忘情水
     * downloadUrl : http://file.kuyinyun.com/group1/M00/52/54/rBBGdFO10gGAV2YSABeMNNnn7Sc042.mp3
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "DataBean{" +
                "result=" + result +
                '}';
    }
}
