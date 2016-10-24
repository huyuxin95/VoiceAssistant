package com.jju.yuxin.voiceassistant.action;

import android.content.Intent;
import android.net.Uri;

import com.jju.yuxin.voiceassistant.activity.MainActivity;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 6:07.
 * Version   1.0;
 * Describe : 网站查询
 * History:
 * ==============================================================================
 */

public class WebsiteAction {
    public static String startWebsite(String name, String url, MainActivity activity) {
        if (url!=null&&url.length()>0){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            activity.startActivity(intent);
            activity.answer_text.setText("正在打开"+name+"...");
            return "1";
        }
        return "好像出现了点问题,待会再试吧.";
    }
}
