package com.jju.yuxin.voiceassistant.utils;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.jju.yuxin.voiceassistant.activity.MainActivity;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.utils
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 1:23.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class SpealUtils {

    /**
     * 传入activity,和要说话的内容
     * 将设置返回的文本信息并将其读出
     * @param activity
     * @param speak
     * @param text
     */
    public static void speakText(MainActivity activity, String speak ,String text) {
        //1表示操作处理成功,已设置完answer_text的值,但是不读出来
        if ("1".equals(speak)){


       //2表示要执行的操作没有理解,直接跳转网页搜索
        }else if ("2".equals(speak)){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://cn.bing.com/search?q="+text+"&qs=n&form=QBLH&pq="+text+"&sc=5-4&sp=-1&sk="));
            activity.startActivity(intent);
            activity.answer_text.setText("正在必应搜索"+text+"...");
         //   speakText(activity,"正在必应搜索"+text+"...",text);
        }else{
            activity.answer_text.setText(speak);
            //将返回内容读出来
            int code = activity.mTts.startSpeaking(speak, activity.mTtsListener);
            //出现异常
            if (code != ErrorCode.SUCCESS) {
                Toast.makeText(activity, "语音合成失败,错误码: " + code, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
