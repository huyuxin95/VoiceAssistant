package com.jju.yuxin.voiceassistant.action;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.utils.ContactsUtils;

import java.util.List;

import static com.iflytek.cloud.VerifierResult.TAG;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 1:47.
 * Version   1.0;
 * Describe :  发送短信
 * History:
 * ==============================================================================
 */

public class SendAction {

    public static String startSend(String mPerson, String number,String content, MainActivity mActivity){
        //直接呼叫号码
        if (number != null) {
            //   e(TAG, "startCall" + "拨打:code:" + number);
            mActivity.answer_text.setText("正在发短信给" + number + "说:"+content);
            SmsManager smsManager = SmsManager.getDefault();
            if(content.length() > 70) {
                List<String> contents = smsManager.divideMessage(content);
                for(String sms : contents) {
                    smsManager.sendTextMessage(number, null, sms, null, null);
                    insertDB(number,sms,mActivity);
                }
            } else {
                smsManager.sendTextMessage(number, null, content, null, null);
                insertDB(number,content,mActivity);
            }
            return "正在发短信给" + number + "说:"+content;
            //根据传入的联系人姓名查找号码再拨打
        } else if (mPerson != null) {
            mPerson = mPerson.trim();
            //通过名字查找号码
            number = ContactsUtils.getNumberByName(mPerson, mActivity);
            if (number == null) {
                return "没有在通讯录中找到" + mPerson + "的号码。";
            } else {
                //    e(TAG, "startCall" + "拨打:code:" + number);
                mActivity.answer_text.setText("正在发短信给" + mPerson + "说:"+content);
                SmsManager smsManager = SmsManager.getDefault();
                if(content.length() > 70) {
                    List<String> contents = smsManager.divideMessage(content);
                    for(String sms : contents) {
                        smsManager.sendTextMessage(number, null, sms, null, null);
                        insertDB(number,sms,mActivity);
                    }
                } else {
                    smsManager.sendTextMessage(number, null, content, null, null);
                     insertDB(number, content, mActivity);
                }
                return "正在发短信给" + mPerson + "说:"+content;
            }
        }
        return "您要发短信给谁呢?";
    }

    /**
     * 通过ContentResolver()向短信数据库直接插入信息的方式发送短信,避免了跳转
     * @param number
     * @param content
     * @param activity
     * @return
     */
    private static String insertDB(String number, String content, MainActivity activity){//将发送的短信插入系统数据库中，使其在短信界面显示
        //////////////////////会抛出null的异常---已解决--- mActivity.getContentResolver()才可以
        try{
            ContentValues values = new ContentValues();
            values.put("date", System.currentTimeMillis());
            //阅读状态
            values.put("read", 0);
            //1为收 2为发
            values.put("type", 2);
            //送达号码
            // values.put("status", -1);
            values.put("address",number);
            //送达内容
            values.put("body", content);
            //插入短信库
            // getContentResolver
            Uri insert = activity.getContentResolver().insert(Uri.parse("content://sms/sent"), values);

            return "短信发送成功";
        }catch (Exception e) {
            Log.d(TAG, "插入数据库问题："+e.getMessage());
        }
        return null;
    }
}
