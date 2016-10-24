package com.jju.yuxin.voiceassistant.parser;

import com.jju.yuxin.voiceassistant.action.CallAction;
import com.jju.yuxin.voiceassistant.action.TranslationAction;
import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.parser
 * Created by yuxin.
 * Created time 2016/10/23 0023 下午 2:17.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */
public class TranslationParser {
    public static String parsersTranslation(MainActivity activity, ReturnBean returnBean) {
        String service = returnBean.getService();
        switch (service) {
            case "translation":
                SemanticBean semantic = returnBean.getSemantic();
                if (semantic!=null){
                    SlotsBean slots = semantic.getSlots();
                    if (slots != null){
                        return TranslationAction.startTranslation(slots, activity);
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
