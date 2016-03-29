package com.zxh.weather.comm.base;

import org.xutils.x;

/**
 * Created by xiaohu on 2016/3/26.
 */
public class MyApplication extends BaseApplication {
    //保证对象的唯一性
    private static MyApplication mInstanse;

    public static MyApplication getInstanse(){
        if (mInstanse==null){
            mInstanse=new MyApplication();
        }
        return mInstanse;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xutils
        x.Ext.init(this);

    }
}
