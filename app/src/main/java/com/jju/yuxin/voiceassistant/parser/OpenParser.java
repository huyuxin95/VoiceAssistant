package com.jju.yuxin.voiceassistant.parser;

import com.jju.yuxin.voiceassistant.action.WebSearchAction;
import com.jju.yuxin.voiceassistant.action.WebsiteAction;
import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.parser
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 6:03.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class OpenParser {

    public static String parserOpen(MainActivity activity, ReturnBean returnBean){
        String service = returnBean.getService();
        switch (service) {
            case "website":
                SemanticBean semantic = returnBean.getSemantic();
                if (semantic!=null){
                    SlotsBean slots = semantic.getSlots();
                    if (slots != null){
                        return WebsiteAction.startWebsite(slots.getName(), slots.getUrl(), activity);
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
