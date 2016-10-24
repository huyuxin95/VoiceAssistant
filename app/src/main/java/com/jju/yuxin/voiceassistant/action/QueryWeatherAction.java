package com.jju.yuxin.voiceassistant.action;

import android.view.View;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.DataBean;
import com.jju.yuxin.voiceassistant.bean.DateTimeBean;
import com.jju.yuxin.voiceassistant.bean.LocationBean;
import com.jju.yuxin.voiceassistant.bean.ResultBean;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;
import com.jju.yuxin.voiceassistant.bean.WebPageBean;

import java.util.List;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/23 0023 上午 9:57.
 * Version   1.0;
 * Describe : 查询天气
 * History:
 * ==============================================================================
 */

public class QueryWeatherAction {


    public static String startQuery(WebPageBean webPage, SemanticBean weathersb, DataBean data, MainActivity activity) {
        String cityAddr = null;
        String date = null;
        String dateOrig = null;
        String url = null;
        ResultBean resultdata = null;
        SlotsBean slots = weathersb.getSlots();

        String starttr="";
        String endtr="";

        //解析SlotsBean
        if (slots != null) {
            DateTimeBean datetime = slots.getDatetime();
            LocationBean location = slots.getLocation();
            if (location != null) {
                //返回地址
                cityAddr = location.getCityAddr();
                if (cityAddr == null) {
                    cityAddr = location.getCity();
                    if (cityAddr==null){
                        cityAddr=location.getAreaAddr();
                    }
                }
            }
            if (datetime != null) {
                //格式化的时间
                date = datetime.getDate();
                //用户说的时间
                dateOrig = datetime.getDateOrig();
                //r如果没有指定时间,默认为今天
                if (dateOrig==null){
                    dateOrig="今天";
                }
            }
        }

        //解析WebPageBean
        if (webPage != null) {
            //要显示的网页信息
            url = webPage.getUrl();
        }

        if (data != null) {
            List<ResultBean> results = data.getResult();
            //查询到你要查询日期的天气
            if (results != null) {
                for (ResultBean result : results) {
                    if (date.equals(result.getDate())) {
                        resultdata = result;
                    }
                }
                if (resultdata==null){
                    resultdata=results.get(0);
                }
            }
        }
        if (resultdata != null) {
            //~
            String[] split = resultdata.getTempRange().replace("℃", "").split("~");
            activity.wb_result.setVisibility(View.VISIBLE);
            activity.wb_result.loadUrl(url);
            if ("CURRENT_CITY".equals(cityAddr)){
                cityAddr="";
            }
            if (split[0]!=null){
                starttr=split[0];
            }
            if (split.length>1){
                endtr=split[1];
            }
            if (endtr!=null&&!endtr.equals("")){
            return dateOrig + cityAddr + resultdata.getWeather() + ",温度" + starttr + "至" + endtr + "度," + resultdata.getWind() + ",下面是" + cityAddr + "近期的天气情况:";
            }else{
                return dateOrig + cityAddr + resultdata.getWeather() + ",温度" + starttr + "度," + resultdata.getWind() + ",下面是" + cityAddr + "近期的天气情况:";
            }
        }
        return "好像出现了点问题,没有查询到天气!";
    }
}
