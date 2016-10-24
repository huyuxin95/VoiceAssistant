package com.jju.yuxin.voiceassistant.parser;

import com.jju.yuxin.voiceassistant.bean.AnswerBean;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.parser
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 1:22.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class AnswerParser {



    /**
     * 智能问答
     *解析Answer
     * @param returnBean
     * @return
     */
    public static Object parserAnswer(ReturnBean returnBean) {
        String service = returnBean.getService();
        AnswerBean answer = null;
        switch (service) {
            case "openQA":
                answer = returnBean.getAnswer();
                break;
            case "datetime":
                answer = returnBean.getAnswer();
                break;
            case "calc":
                answer = returnBean.getAnswer();
                break;
            case "baike":
                answer = returnBean.getAnswer();
                break;
            case "faq":
                answer = returnBean.getAnswer();
                break;
            case "chat":
                answer = returnBean.getAnswer();
                break;
            default:
                break;
        }
        return answer;
    }
}
