package com.jju.yuxin.voiceassistant.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;

import java.lang.reflect.Type;

import static android.util.Log.e;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant
 * Created by yuxin.
 * Created time 2016/10/21 0021 上午 12:21.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class JsonParser {

    private static final String TAG = JsonParser.class.getSimpleName();
    private static ReturnBean returnBean;

    /**
     * 返回当前说话的内容
     * @param json
     * @return
     */
    public static ReturnBean parseIatResult(String json) {
        returnBean = new ReturnBean();
        try {
//            JSONTokener tokener = new JSONTokener(json);
//            JSONObject joResult = new JSONObject(tokener);

            Type type = new TypeToken<ReturnBean>() {
            }.getType();

            returnBean = new Gson().fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnBean;
    }

}