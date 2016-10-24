package com.jju.yuxin.voiceassistant.parser;

import com.jju.yuxin.voiceassistant.action.CallAction;
import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.parser
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 1:21.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class CallParser {

    /**
     * 解析CALL
     *
     * @param returnBean
     */
    public static String parserCALL(MainActivity activity, ReturnBean returnBean) {
        String service = returnBean.getService();
        switch (service) {
            /**
             * 打电话
             */
            case "telephone":
                SemanticBean semantic = returnBean.getSemantic();
                if (semantic!=null){
                    SlotsBean slots = semantic.getSlots();
                    if (slots != null){
                        return CallAction.startCall(slots.getName(), slots.getCode(), activity);
                    }
                    slots=null;
                }
                semantic =null;
                break;
            default:
                break;
        }
        return "2";
    }
}
