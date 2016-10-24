package com.jju.yuxin.voiceassistant.parser;

import com.jju.yuxin.voiceassistant.action.ScheduleAction;
import com.jju.yuxin.voiceassistant.action.WebsiteAction;
import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.DateTimeBean;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.parser
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 6:33.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */
public class CreateParser {
    public static String parsersChedule(MainActivity activity, ReturnBean returnBean) {
        String service = returnBean.getService();
        switch (service) {
            case "schedule":
                SemanticBean semantic = returnBean.getSemantic();
                if (semantic!=null){
                    SlotsBean slots = semantic.getSlots();
                    if (slots != null){
                        String name = slots.getName();
                        String content = slots.getContent();
                        DateTimeBean datetime = slots.getDatetime();
                        if (datetime!=null){
                            //return WebsiteAction.startWebsite(slots.getName(), slots.getUrl(), activity);
                           return ScheduleAction.startSchedule(name,content,datetime,activity);
                        }
                        datetime=null;
                    }
                    slots=null;
                }
                semantic =null;
                break;
            default:
                break;
        }

        return "我好像没有明白你要设置的提醒.";
    }
}
