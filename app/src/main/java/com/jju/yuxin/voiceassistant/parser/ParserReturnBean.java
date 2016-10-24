package com.jju.yuxin.voiceassistant.parser;


import android.drm.DrmStore;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.AnswerBean;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.utils.SpealUtils;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.utils
 * Created by yuxin.
 * Created time 2016/10/21 0021 下午 3:35.
 * Version   1.0;
 * Describe : 解析返回的对象
 * History:
 * ==============================================================================
 */

public class ParserReturnBean {
    private static final String TAG = ParserReturnBean.class.getSimpleName();

    private static AnswerBean answer;

    /**
     * 解析语义场景和开放语义
     * @param activity
     * @param returnBean
     */
    public static void parserOsp(MainActivity activity, ReturnBean returnBean) {
        String operation = returnBean.getOperation();
        switch (operation) {
            /**
             * 智能问答
             */
            case "ANSWER":
                answer = (AnswerBean) AnswerParser.parserAnswer(returnBean);
               SpealUtils.speakText(activity,answer.getText(),returnBean.getText());
                break;
            /**
             *呼叫
             */
            case "CALL":
                String speakcall = CallParser.parserCALL(activity, returnBean);
                SpealUtils.speakText(activity,speakcall,returnBean.getText());
                break;
            /**
             * 发送
             */
            case "SEND":
                String speaksend = SendParser.parserSend(activity, returnBean);
                SpealUtils.speakText(activity,speaksend,returnBean.getText());
                break;
            /**
             * 启动程序
             */
            case "LAUNCH":
                String speaklaunch = LaunchParser.parserLaunch(activity, returnBean);
                SpealUtils.speakText(activity,speaklaunch,returnBean.getText());
                break;
            /**
             * 搜索操作
             */
            case "QUERY":
                String speakquery = QueryParser.parserQuery(activity, returnBean);
                SpealUtils.speakText(activity,speakquery,returnBean.getText());
                break;
            /**
             *打开操作
             */
            case "OPEN":
                String speakopen = OpenParser.parserOpen(activity, returnBean);
                SpealUtils.speakText(activity,speakopen,returnBean.getText());
                break;
            /**
             * 创建操作
             */
            case "CREATE":
                String speakCreate = CreateParser.parsersChedule(activity, returnBean);
                SpealUtils.speakText(activity,speakCreate,returnBean.getText());
                break;
            /**
             * 播放操作
             */
            case "PLAY":
                String speakplay = PlayParser.parsersPlay(activity, returnBean);
                SpealUtils.speakText(activity,speakplay,returnBean.getText());
                break;
            /**
             * 翻译操作
             */
            case "TRANSLATION":
                String speakplayTranslation = TranslationParser.parsersTranslation(activity, returnBean);
                SpealUtils.speakText(activity,speakplayTranslation,returnBean.getText());
                break;
            default:
                SpealUtils.speakText(activity,"2",returnBean.getText());
                break;
        }
    }
}
