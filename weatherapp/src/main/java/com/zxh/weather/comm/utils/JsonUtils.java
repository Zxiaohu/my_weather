package com.zxh.weather.comm.utils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xiaohu on 2016/3/26.
 */
public class JsonUtils {

    /****
     * 将json转对象
     * @param json json
     * @param tClass javabean
     * @param <T> json对应的javabean
     * @return
     */
    public static <T>T getObjByGson(String json,Class<T> tClass){
        return new Gson().fromJson(json,tClass);
    }
    /*****
     * 根据json字符串的key获取int值
     */
    public static int getInt4Json(String key,String json){
        try {
            return new JSONObject(json).getInt(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /*****
     * 根据json字符串的key获取string值
     */
    public static String getStr4Json(String key,String json){
        try {
            return new JSONObject(json).getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**获取jsonObect**/
    public static JSONObject getJsonObj(String json){
        try {
            return new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***将jsonobect里面的对象通过key转化为json格式String**/
    public static String getJsonStr4JosnObj(String info,String key){
        try {
            return getJsonObj(info).getJSONObject(key).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
