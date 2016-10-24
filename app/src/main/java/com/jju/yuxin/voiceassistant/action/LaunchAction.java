package com.jju.yuxin.voiceassistant.action;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.utils.APPManagerUtils;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 2:41.
 * Version   1.0;
 * Describe : 启动应用
 * History:
 * ==============================================================================
 */

public class LaunchAction {

    public static String startLaunch(String appname, MainActivity mActivity){
            String speaktext=null;
        //判断分析的appname是否为空
        if((appname!=null)&&(appname.length()>0)){
            //修复不能启动京东的bug
            if ("京东".equals(appname)){
                appname="手机京东";
            }
            speaktext = APPManagerUtils.LuanchAppByName(appname, mActivity);
        }
        //启动成功
        if (speaktext!=null){
            mActivity.answer_text.setText(speaktext);
            return "1";
        }else{
            //启动失败
        return "好像没有找到你说的应用程序";
        }
    }
}
