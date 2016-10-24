package com.jju.yuxin.voiceassistant.action;

import android.view.View;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;
import com.jju.yuxin.voiceassistant.bean.WebPageBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/23 0023 下午 1:47.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class QueryGiftAction {
    public static String startGift(SlotsBean slots, WebPageBean webPage, MainActivity activity) {
        //分类
        String category = slots.getCategory();
        if (category==null){
            category="";
        }
        //礼品名称
        String name = slots.getName();
        if (name==null){
            name="";
        }
        if (webPage != null) {
            activity.wb_result.setVisibility(View.VISIBLE);
            activity.wb_result.loadUrl(webPage.getUrl());
            return "下面是一些"+name+category+"的信息";
        } else {
            return "不好意思,我没能找到你要的内容!";
        }

    }
}
