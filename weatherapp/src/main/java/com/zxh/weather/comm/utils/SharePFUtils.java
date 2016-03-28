package com.zxh.weather.comm.utils;

import com.zxh.weather.comm.base.BaseApplication;
import com.zxh.weather.comm.base.MyApplication;

/***
 * @author zxh
 */
public class SharePFUtils {

    //插入数组数据到缓�?
    /***
     * @param key
     * @param value
     */
    public static void insertData(String key, String value) {
        //获取我写好的
        MyApplication.getInstanse().getSharedPf().edit().putString(key, value).commit();
    }

    /**
     * 获取value
     *
     * @param key
     * @return
     */
    public static String getData(String key) {
        //不存在默认返回null
        return MyApplication.getInstanse().getSharedPf().getString(key, null);

    }
}
