package com.jju.yuxin.voiceassistant.parser;

import com.jju.yuxin.voiceassistant.action.QueryCookAction;
import com.jju.yuxin.voiceassistant.action.QueryFlowerAction;
import com.jju.yuxin.voiceassistant.action.QueryGiftAction;
import com.jju.yuxin.voiceassistant.action.QueryRentAction;
import com.jju.yuxin.voiceassistant.action.QueryStockAction;
import com.jju.yuxin.voiceassistant.action.QueryWeatherAction;
import com.jju.yuxin.voiceassistant.action.WebSearchAction;
import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.DataBean;
import com.jju.yuxin.voiceassistant.bean.ReturnBean;
import com.jju.yuxin.voiceassistant.bean.SemanticBean;
import com.jju.yuxin.voiceassistant.bean.SlotsBean;
import com.jju.yuxin.voiceassistant.bean.WebPageBean;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.parser
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 4:51.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class QueryParser {

    public static String parserQuery(MainActivity activity, ReturnBean returnBean) {
        String service = returnBean.getService();
        switch (service) {
            /**
             * 网页搜索
             */
            case "websearch":
                SemanticBean semantic = returnBean.getSemantic();
                if (semantic != null) {
                    SlotsBean slots = semantic.getSlots();
                    if (slots != null) {
                        return WebSearchAction.startSearch(slots.getChannel(), slots.getKeywords(), activity);
                    }
                    slots = null;
                }
                semantic = null;
                break;
            /**
             *天气查询
             */
            case "weather":
                SemanticBean weathersb = returnBean.getSemantic();
                if (weathersb != null) {
                    WebPageBean webPage = returnBean.getWebPage();
                    DataBean data = returnBean.getData();
                    return QueryWeatherAction.startQuery(webPage, weathersb, data, activity);
                }
                weathersb = null;
                break;
            /**
             * 菜谱查询
             */
            case "cookbook":
                SemanticBean cooksb = returnBean.getSemantic();
                if (cooksb != null) {
                    SlotsBean slots = cooksb.getSlots();
                    if (slots != null) {
                        WebPageBean webPage = returnBean.getWebPage();
                        return QueryCookAction.startCook(slots, webPage, activity);
                    }
                    slots = null;
                }
                cooksb = null;
                break;
            /**
             * 短期房屋出租
             */
            case "shortRent":
                SemanticBean rentsb = returnBean.getSemantic();
                if (rentsb != null) {
                    SlotsBean slots = rentsb.getSlots();
                    if (slots != null) {
                        WebPageBean webPage = returnBean.getWebPage();
                        return QueryRentAction.startRent(slots, webPage, activity);
                    }
                    slots = null;
                }
                cooksb = null;
                break;
            /**
             * 股票查询
             */
            case "stock":
                SemanticBean stocksb = returnBean.getSemantic();
                if (stocksb != null) {
                    SlotsBean slots = stocksb.getSlots();
                    if (slots != null) {
                        WebPageBean webPage = returnBean.getWebPage();
                        return QueryStockAction.startStock(slots, webPage, activity);
                    }
                    slots = null;
                }
                cooksb = null;
                break;
            /**
             * 鲜花查询
             */
            case "flower":
                SemanticBean flowersb = returnBean.getSemantic();
                if (flowersb != null) {
                    SlotsBean slots = flowersb.getSlots();
                    if (slots != null) {
                        WebPageBean webPage = returnBean.getWebPage();
                        return QueryFlowerAction.startFlower(slots, webPage, activity);
                    }
                    slots = null;
                }
                cooksb = null;
                break;
            /**
             * 礼品查询
             */
            case "gift":
                SemanticBean giftsb = returnBean.getSemantic();
                if (giftsb != null) {
                    SlotsBean slots = giftsb.getSlots();
                    if (slots != null) {
                        WebPageBean webPage = returnBean.getWebPage();
                        return QueryGiftAction.startGift(slots, webPage, activity);
                    }
                    slots = null;
                }
                cooksb = null;

                break;
            default:
                break;
        }

        return "2";
    }
}
