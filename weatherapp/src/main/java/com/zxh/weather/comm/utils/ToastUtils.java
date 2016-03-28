package com.zxh.weather.comm.utils;

import android.widget.Toast;

import com.zxh.weather.comm.base.BaseApplication;
import com.zxh.weather.comm.base.MyApplication;

/**
 * Created by xiaohu on 2016/3/26.
 */
public class ToastUtils {

    /***
     * toast提示
     * @param info
     */
    public static void show(String info){
        //提示
        Toast.makeText(MyApplication.getInstanse().getContext(),info,Toast.LENGTH_SHORT).show();
    }
}
