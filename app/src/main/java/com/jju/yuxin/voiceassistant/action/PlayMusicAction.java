package com.jju.yuxin.voiceassistant.action;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.Music_;
import com.jju.yuxin.voiceassistant.bean.WebPageBean;
import com.jju.yuxin.voiceassistant.utils.MusicUtil;

import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.Random;

import static android.util.Log.e;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 10:45.
 * Version   1.0;
 * Describe :  播放音乐
 * History:
 * ==============================================================================
 */

public class PlayMusicAction {
    private static final String TAG = PlayMusicAction.class.getSimpleName();

    public static String startPlay(WebPageBean webpage,String song, String artist, MainActivity activity) {

        List<Music_> musics = MusicUtil.getMusic(activity);
        String url = null;
        //歌手和歌名都匹配
        if (artist != null && artist.length() > 0 && song != null && song.length() > 0) {
            for (Music_ music : musics) {
                if (music.getAuthor().equals(artist) && music.getName().equals(song)) {
                    url = music.getPath();
                }
            }
            activity.answer_text.setText("在正在试着播放"+artist+"的"+song);
            //只匹配歌名
        } else if (song != null && song.length() > 0) {
            for (Music_ music : musics) {
                if (music.getName().equals(song)) {
                    url = music.getPath();
                }
            }
            activity.answer_text.setText("在正在试着播放"+song);
            //只匹配歌手
        } else if (artist != null && artist.length() > 0) {
            for (Music_ music : musics) {
                if (music.getAuthor().equals(artist)) {
                    url = music.getPath();
                }
            }
            activity.answer_text.setText("在正在试着播放"+artist+"的歌曲.");
            //只说了播放音乐
        }else{
            Random random=new Random();
            Music_ music=musics.get(random.nextInt(musics.size()));
            url = music.getPath();
            activity.answer_text.setText("在正在试着随机播放本地音乐.");
        }
        if (url!=null){
            e(TAG, "startPlay:url:" + url);
            e(TAG, "startPlay:" + Environment.getExternalStorageDirectory());

            Intent it = new Intent(Intent.ACTION_MAIN);
            it.setAction(Intent.ACTION_DEFAULT);
            it.setDataAndType(Uri.parse("file://" + url), "audio/MP3");
            activity.startActivity(it);
            return "1";
        }else{
            webpage.getUrl();
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse(webpage.getUrl()));
//            activity.startActivity(intent);
            activity.wb_result.setVisibility(View.VISIBLE);
            activity.wb_result.loadUrl(webpage.getUrl());
            return "好像没有在本地音乐找到您要的歌曲,我在网上找到了一些匹配的,点击就可以下载了.";
        }

    }
}
