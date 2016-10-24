package com.jju.yuxin.voiceassistant.action;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;

import com.jju.yuxin.voiceassistant.activity.MainActivity;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 4:56.
 * Version   1.0;
 * Describe : 网页查询
 * History:
 * ==============================================================================
 */

public class WebSearchAction {


    //https://www.baidu.com/s?wd=%E4%B8%83%E5%A4%95&tn=SE_PSStatistics_p1d9m0nf
    //https://s.taobao.com/search?q=月全食
    //http://cn.bing.com/search?q=今日头条&qs=n&form=QBLH&pq=今日头条&sc=5-4&sp=-1&sk=
    //http://m.sogou.com/web/searchList.jsp?uID=FDGQyv3OI8ahDzP2&v=5&from=index&w=1274&t=1477206817737&s_t=1477206828566&s_from=index&keyword=头条&pg=webSearchList
    public static String startSearch(String channel, String keywords, MainActivity mActivity){
        if (keywords!=null&&keywords.length()>0){
            //淘宝搜索
            if ("taobao".equals(channel)){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://s.taobao.com/search?q="+keywords));
                mActivity.startActivity(intent);
                mActivity.answer_text.setText("正在淘宝搜索"+keywords+"...");
                //baidu搜索
            }else if("baidu".equals(channel)){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com/s?wd="+keywords+"&tn=SE_PSStatistics_p1d9m0nf"));
                mActivity.startActivity(intent);
                mActivity.answer_text.setText("正在百度搜索"+keywords+"...");
                //百度搜索
            }else if("soso".equals(channel)) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://m.sogou.com/web/searchList.jsp?uID=FDGQyv3OI8ahDzP2&v=5&from=index&w=1274&t=1477206817737&s_t=1477206828566&s_from=index&keyword=" + keywords + "&pg=webSearchList"));
                mActivity.startActivity(intent);
                mActivity.answer_text.setText("正在搜狗搜索" + keywords + "...");
                //必应
            }else {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://cn.bing.com/search?q=" + keywords + "&qs=n&form=QBLH&pq=" + keywords + "&sc=5-4&sp=-1&sk="));
                mActivity.startActivity(intent);
                mActivity.answer_text.setText("正在必应搜索" + keywords + "...");

            }
            return "1";
        }
        return "您要搜索什么呢?";
    }
}
