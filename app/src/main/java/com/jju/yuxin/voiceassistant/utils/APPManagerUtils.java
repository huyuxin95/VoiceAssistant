package com.jju.yuxin.voiceassistant.utils;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import com.jju.yuxin.voiceassistant.activity.MainActivity;

import java.util.List;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.voiceassistant.utils
 * Created by yuxin.
 * Created time 2016/10/22 0022 下午 2:50.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class APPManagerUtils {

    public static String LuanchAppByName(String mAppName, MainActivity mActivity){
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager pm = mActivity.getPackageManager();
        List<ResolveInfo> installAppList = pm.queryIntentActivities(intent, 0);
        for(ResolveInfo info :installAppList){
            String name = info.loadLabel(pm).toString();
            if(name.equalsIgnoreCase(mAppName)){
                String pkgname=info.activityInfo.packageName;
                if("com.android.contacts".equalsIgnoreCase(pkgname)){
                    Uri uri = Uri.parse("content://contacts/people");
                    Intent i= new Intent("android.intent.action.VIEW", uri);
                    mActivity.startActivity(i);
                }else{
                    intent = pm.getLaunchIntentForPackage(pkgname);
                    intent.addCategory("android.intent.category.LAUNCHER");
                    mActivity.startActivity(intent);
                }
                return "正在打开"+mAppName+"..." ;
            }
        }
        return null;
    }
}
