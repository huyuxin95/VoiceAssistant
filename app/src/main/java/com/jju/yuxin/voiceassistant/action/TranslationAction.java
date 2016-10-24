package com.jju.yuxin.voiceassistant.action;

import android.net.Uri;
import android.view.View;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/23 0023 下午 2:23.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class TranslationAction {
    public static String startTranslation(SlotsBean slots, MainActivity activity) {
        //目标语言
        String target = slots.getTarget();
        //原来的语言
        String source = slots.getSource();
        //翻译内容
        String content = slots.getContent();

        if (target==null){
            return "我好像没明白你要翻译成什么语言.";
        }else if(!"en".equals(target)){
            return "不好意思,我只会将中文翻译成英语.";
        }else{
            if (content!=null){
               // http://fanyi.baidu.com/?aldtype=16047&tpltype=sigma#zh/en/%E4%BD%A0%E5%A5%BD
                Uri uri = Uri.parse("http://fanyi.baidu.com/?aldtype=16047&tpltype=sigma#" + source + "/" + target + "/" + content);
                activity.wb_result.setVisibility(View.VISIBLE);
                activity.wb_result.loadUrl(String.valueOf(uri));
                return "下面是\""+content+"\"的翻译结果";
            }
        }

        return "不好意思,我没听清楚你要翻译的内容.";
    }
}
