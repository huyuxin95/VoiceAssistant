package com.jju.yuxin.voiceassistant.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.utils
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 1:46.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class ContactsUtils {

    /**
     * 通过名字在通讯录中查找对应的电话号码
     *
     * @param name
     * @param context
     * @return
     */
    public static String getNumberByName(String name, Context context) {
        Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, name);
        ContentResolver resolver = context.getContentResolver();

        Cursor cursor = resolver.query(uri, new String[]{ContactsContract.Contacts._ID}, null, null, null);

        if ((cursor != null) && (cursor.moveToFirst())) {
            int idCoulmn = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            long id = cursor.getLong(idCoulmn);
            cursor.close();
            cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = ?", new String[]{Long.toString(id)}, null);
            if ((cursor != null) && (cursor.moveToFirst())) {
                //获取电话号码
                int m = cursor.getColumnIndex("data1");
                String num = cursor.getString(m);
                cursor.close();
                return num;
            }
        }
        return null;
    }
}
