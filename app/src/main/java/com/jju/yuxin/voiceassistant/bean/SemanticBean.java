package com.jju.yuxin.voiceassistant.bean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.bean
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 12:46.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class SemanticBean {

    /**
     * content : 我明天去找你
     */

    private SlotsBean slots;

    private StartTimeBean startTime;

    public SlotsBean getSlots() {
        return slots;
    }

    public StartTimeBean getStartTime() {
        return startTime;
    }

    public void setStartTime(StartTimeBean startTime) {
        this.startTime = startTime;
    }

    public void setSlots(SlotsBean slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "SemanticBean{" +
                "slots=" + slots +
                ", startTime=" + startTime+
                '}';
    }
}
