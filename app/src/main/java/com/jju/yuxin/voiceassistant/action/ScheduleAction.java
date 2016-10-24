package com.jju.yuxin.voiceassistant.action;

import android.content.Intent;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.util.Log;

import com.jju.yuxin.voiceassistant.activity.MainActivity;
import com.jju.yuxin.voiceassistant.bean.DateTimeBean;
import com.jju.yuxin.voiceassistant.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.util.Log.e;
import static com.iflytek.cloud.VerifierResult.TAG;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.action
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 6:50.
 * Version   1.0;
 * Describe : 闹钟提醒
 * History:
 * ==============================================================================
 */

public class ScheduleAction {
    private static final String TAG = ScheduleAction.class.getSimpleName();

    public static String startSchedule(String name, String content, DateTimeBean datetime, MainActivity activity) {
        switch (name) {
            //日程提醒
            case "reminder":
                try {
                    //将字符串转换为Calendar对象
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date  = sdf.parse(datetime.getDate() +" "+ datetime.getTime());

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    e(TAG, "startSchedule" + calendar.getTime());
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, content);
                    intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calendar);
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "已经跳转到了日程提醒界面,需要您自己设置下时间.";
            //闹钟提醒
            case "clock":
                //切割时:分:秒
                String[] split = datetime.getTime().split(":");

                e(TAG, "startSchedule:content:" + content + "date:" + DateUtils.getWeek(datetime.getDate()) + "time:" + split[0] + ":" + split[1] + ":" + split[2]);

                Intent clockintent = new Intent(AlarmClock.ACTION_SET_ALARM);
                //设置小时
                clockintent.putExtra(AlarmClock.EXTRA_HOUR, split[0]);
                //设置分钟
                clockintent.putExtra(AlarmClock.EXTRA_MINUTES, split[1]);
                //设置周几
                clockintent.putExtra(AlarmClock.EXTRA_DAYS, DateUtils.getWeek(datetime.getDate()));
                //设置闹钟内容
                clockintent.putExtra(AlarmClock.EXTRA_MESSAGE, content);
                activity.startActivity(clockintent);
                return "已经跳转到了闹钟界面,需要您自己设置下时间.";
            default:
                break;
        }

        return "不好意思,我好像没明白,您要设置什么提醒.";
    }
}
