package com.jju.yuxin.voiceassistant.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.utils
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 7:28.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class DateUtils {


    /**
     * 获取当前时间在一周中的第几天
     * @param sdate
     * @return
     */
    public static int getWeek(String sdate) {
        // 再转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int days=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return days;
    }

    /**
     * 根据字符串,换算成日期
     * @param sdate
     * @return
     */
    private static Date strToDate(String sdate) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ParsePosition pos = new ParsePosition(0);
            Date strtodate = formatter.parse(sdate, pos);
            return strtodate;

    }
}
