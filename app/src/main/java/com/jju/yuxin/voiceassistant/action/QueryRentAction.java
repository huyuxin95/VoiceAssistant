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
 * Created time 2016/10/23 0023 下午 1:10.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class QueryRentAction {
    public static String startRent(SlotsBean slots, WebPageBean webPage, MainActivity activity) {
        String addrName = slots.getLocation().getCityAddr();

        if (addrName!=null){
            if ("CURRENT_CITY".equals(addrName)){
                addrName="附近";
            }
            if(webPage!=null){
                activity.wb_result.setVisibility(View.VISIBLE);
                activity.wb_result.loadUrl(webPage.getUrl());
            }
            return "下面是"+addrName+"的租房信息...";
        }else{
            addrName="附近";
        }
        return addrName+"好像没有租房信息";
    }
}
