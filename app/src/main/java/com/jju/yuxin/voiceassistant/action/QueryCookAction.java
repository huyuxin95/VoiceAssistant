package com.jju.yuxin.voiceassistant.action;

import android.view.View;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;
import com.jju.yuxin.voiceassistant.bean.WebPageBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/23 0023 下午 12:22.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class QueryCookAction {
    public static String startCook(SlotsBean slots, WebPageBean webPage, MainActivity activity) {
        String dishName = slots.getDishName();
        if (dishName!=null){
            if(webPage!=null){
                activity.wb_result.setVisibility(View.VISIBLE);
                activity.wb_result.loadUrl(webPage.getUrl());
            }
            return "下面是"+dishName+"的做法...";
        }
        return "我好像还不会做这道菜.";
    }
}
