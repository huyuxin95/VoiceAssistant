package com.jju.yuxin.voiceassistant.action;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.utils.ContactsUtils;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/22 0022 上午 10:28.
 * Version   1.0;
 * Describe :打电话操作
 * History:
 * ==============================================================================
 */

public class CallAction {
    /**
     * 打电话
     * @param mPerson
     * @param number
     * @param mActivity
     * @return
     */
    public static String startCall(String mPerson, String number, MainActivity mActivity)
    {
      //  e(TAG, "startCall" + "mPerson:" + mPerson + "number:" + number);
        //直接呼叫号码
        if (number != null) {
         //   e(TAG, "startCall" + "拨打:code:" + number);
            mActivity.answer_text.setText("正在打电话给" + number + "...");
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
            mActivity.startActivity(intent);

            return "1";
            //根据传入的联系人姓名查找号码再拨打
        } else if (mPerson != null) {
            mPerson = mPerson.trim();
            //通过名字查找号码
            number = ContactsUtils.getNumberByName(mPerson, mActivity);
            if (number == null) {
                return "没有在通讯录中找到" + mPerson + "的号码。";
            } else {
            //    e(TAG, "startCall" + "拨打:code:" + number);
                mActivity.answer_text.setText("正在打电话给" + mPerson + "...");
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                mActivity.startActivity(intent);

                return "1";
            }
        }
        return "您要打电话给谁呢?";
    }




}
