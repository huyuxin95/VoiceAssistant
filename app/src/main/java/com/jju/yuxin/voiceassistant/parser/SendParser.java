package com.jju.yuxin.voiceassistant.parser;

import android.util.Log;

import com.jju.yuxin.voiceassistant.action.CallAction;
import com.jju.yuxin.voiceassistant.action.SendAction;
import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.parser
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 1:27.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class SendParser {
    private static final String TAG = SendParser.class.getSimpleName();

    /**
     * 解析发送操作
     *
     * @param activity
     * @param returnBean
     * @return
     */
    public static String parserSend(MainActivity activity, ReturnBean returnBean) {
        String service = returnBean.getService();
        switch (service) {
            /**
             * 发送短信
             */
            case "message":
                //Log.e(TAG, "parserSend:" + returnBean.getSemantic().getSlots().toString());
                SemanticBean semantic = returnBean.getSemantic();
                if (semantic!=null){
                    SlotsBean slots = semantic.getSlots();
                    if (slots != null){
                        return SendAction.startSend(slots.getName(),slots.getCode(),slots.getContent(),activity);
                    }
                    slots=null;
                }
                semantic =null;
                break;
            default:
                break;
        }

         return "您要发送什么呢?";
    }
}
