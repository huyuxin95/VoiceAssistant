package com.jju.yuxin.voiceassistant.parser;

import android.util.Log;

import com.jju.yuxin.voiceassistant.action.CallAction;
import com.jju.yuxin.voiceassistant.action.PlayMusicAction;
import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.parser
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 9:25.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */
public class PlayParser {

    private static final String TAG = PlayParser.class.getSimpleName();

    public static String parsersPlay(MainActivity activity, ReturnBean returnBean) {
        String service = returnBean.getService();
        switch (service) {
            case "music":
                SemanticBean semantic = returnBean.getSemantic();
                if (semantic!=null){
                    SlotsBean slots = semantic.getSlots();
                    if (slots != null){
                        Log.e(TAG, "parsersPlay" + slots.toString());
                        return PlayMusicAction.startPlay(returnBean.getWebPage(),slots.getSong(), slots.getArtist(), activity);
                    }else{

                        //当没有指明歌手和歌名随机播放一首歌曲
                        return PlayMusicAction.startPlay(returnBean.getWebPage(),null, null, activity);
                    }
                }
                semantic =null;
                break;
            default:
                break;
        }
        return "你要播放什么呢?我好像没听明白.";
    }
}
