package com.jju.yuxin.voiceassistant.action;

import android.view.View;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;
import com.jju.yuxin.voiceassistant.bean.WebPageBean;

import java.util.IllegalFormatCodePointException;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/23 0023 下午 1:38.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class QueryFlowerAction {
    public static String startFlower(SlotsBean slots, WebPageBean webPage, MainActivity activity) {
        String category = slots.getCategory();
        if (category == null) {
            category = "鲜花";
        }

        if (webPage != null) {
            activity.wb_result.setVisibility(View.VISIBLE);
            activity.wb_result.loadUrl(webPage.getUrl());
            return "下面是一些"+category+"的信息";
        } else {
            return "不好意思,我没能找到你要的内容!";
        }
    }
}
