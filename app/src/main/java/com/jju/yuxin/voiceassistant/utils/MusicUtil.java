package com.jju.yuxin.voiceassistant.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;


import com.jju.yuxin.voiceassistant.bean.Music_;

import java.util.ArrayList;
import java.util.List;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.musicplayer.utils
 * Created by yuxin.
 * Created time 2016/10/16 0016 上午 9:31.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class MusicUtil {
    private static final String TAG = MusicUtil.class.getSimpleName();
    private static ContentResolver contentResolver;
    /**
     * 获取SD卡所有的音乐
     * @param context
     * @return
     */
    public static List<Music_> getMusic(Context context) {
        List<Music_> olist = null;
         int index=0;
        contentResolver = context.getContentResolver();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            olist = new ArrayList<>();
            Cursor cursor = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, null, null, Media.DEFAULT_SORT_ORDER);
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(Media.TITLE));
                String author = cursor.getString(cursor.getColumnIndex(Media.ARTIST));
                String path = cursor.getString(cursor.getColumnIndex(Media.DATA));
                Music_ music = new Music_(index++,name, author, path);
                olist.add(music);
            }

        }
        return olist;
    }

    /**
     * 获取SD卡获取到的第一首歌曲
     * @param context
     * @return
     */
    public static Music_ getFirstMusic(Context context) {
        Music_ music=new Music_();
        contentResolver = context.getContentResolver();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Cursor cursor = contentResolver.query(Media.EXTERNAL_CONTENT_URI, null, null, null, Media.DEFAULT_SORT_ORDER);
            Log.e(TAG, "getFirstMusic" + cursor);
            if (cursor.moveToFirst()) {
                String name = cursor.getString(cursor.getColumnIndex(Media.TITLE));
                String author = cursor.getString(cursor.getColumnIndex(Media.ARTIST));
                String path = cursor.getString(cursor.getColumnIndex(Media.DATA));
                music.setId(0);
                music.setName(name);
                music.setAuthor(author);
                music.setPath(path);
            }

        }

        Log.e(TAG, "getFirstMusic" + music.toString());
        return music;
    }
}
