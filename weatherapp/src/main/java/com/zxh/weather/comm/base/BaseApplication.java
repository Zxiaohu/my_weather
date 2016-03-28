package com.zxh.weather.comm.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zxh.weather.comm.utils.CrashHandler;

import org.xutils.x;

/**
 * Created by xiaohu on 2016/3/26.
 */
public class BaseApplication extends Application {

    protected static Context applictionContext;
    public static Context getContext(){
        return applictionContext;
    }
    public static SharedPreferences getSharedPf(){
        return PreferenceManager.getDefaultSharedPreferences(applictionContext);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        if(null==applictionContext){
            applictionContext=getBaseContext();
        }
        //初始化异常扑捉
        CrashHandler.getInstance().init(applictionContext);
    }
}
