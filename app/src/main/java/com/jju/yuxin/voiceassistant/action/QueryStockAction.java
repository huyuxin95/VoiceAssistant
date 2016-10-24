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
 * Created time 2016/10/23 0023 下午 1:26.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class QueryStockAction {
    public static String startStock(SlotsBean slots, WebPageBean webPage, MainActivity activity) {
        //名称
        String name = slots.getName();
        //代码
        String code = slots.getCode();

        if (name!=null&&code!=null){
            if(webPage!=null){
                activity.wb_result.setVisibility(View.VISIBLE);
                activity.wb_result.loadUrl(webPage.getUrl());
            }
            return "下面是"+name+"的股票信息,"+name+"的代码是"+code+"";
        }
        return "我好像没明白你要查询什么股票信息.";
    }
}
