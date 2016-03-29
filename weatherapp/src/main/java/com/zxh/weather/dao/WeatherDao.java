package com.zxh.weather.dao;

import com.zxh.weather.R;
import com.zxh.weather.bean.weather.LifeData;
import com.zxh.weather.bean.weather.Weather;
import com.zxh.weather.bean.weather.WeatherBean;
import com.zxh.weather.bean.weather.Wind;
import com.zxh.weather.comm.utils.AppDBUtils;
import com.zxh.weather.comm.utils.AppResTools;
import com.zxh.weather.comm.utils.JsonUtils;
import com.zxh.weather.comm.utils.LogUtil;

import org.xutils.DbManager;


/**
 * Created by xiaohu on 2016/3/26.
 * 处理天气相关的数据
 */
public class WeatherDao {


    private static WeatherDao mInstance;

    private WeatherDao() {
    }

    public static WeatherDao getInstance() {
        if (mInstance == null) {
            mInstance = new WeatherDao();
        }
        return mInstance;
    }


    /***
     * 获取json对应的key
     ***/
    private String getJosnKey4AppResId(int id) {

        return AppResTools.getStr(id);
    }

    /***
     * 判断是否成功获取值
     *
     * @param info
     */
    public boolean isSuccess(String info) {
        //获取返回码
        int error_code = JsonUtils.getInt4Json(getJosnKey4AppResId(R.string.error_code), info);
        //获取返回的信息
        String reason = JsonUtils.getStr4Json(getJosnKey4AppResId(R.string.reason), info);
        if (error_code == 0) {
            return true;
        } else {
            return false;
        }
    }

    /***
     * 返回核心数据的的str
     *
     * @param info
     * @return
     */
    private String getDataJsonStr(String info) {
        String dataJosnStr = null;
        //获取result对应json数据字符
        String result = JsonUtils.getJsonStr4JosnObj(info, AppResTools.getStr(R.string.result));
        //获取data对应的数据
        dataJosnStr = JsonUtils.getJsonStr4JosnObj(result, AppResTools.getStr(R.string.data));
        //ToastUtils.show(dataJosnStr);
        return dataJosnStr;
    }

    /***
     * 获取生活指数的对象
     *
     * @param info
     * @return
     */
    public LifeData getLifeData(String info) {
        //获取生活指数的对象
        LifeData lifeData = null;
        //life对应的json字符串
        String lifejson = JsonUtils.getJsonStr4JosnObj(getDataJsonStr(info), AppResTools.getStr(R.string.life));
        if (lifeData == null) {
            //生成生活指数的对象
            lifeData = JsonUtils.getObjByGson(lifejson, LifeData.class);
        }
        return lifeData;
    }

    /*****
     * 获取天气信息对象
     */
    public WeatherBean getWeatherBean(String info) {
        WeatherBean weatherBean = null;
        /**获取天气json数据格式**/
        String weatherJson = JsonUtils.getJsonStr4JosnObj(getDataJsonStr(info), getJosnKey4AppResId(R.string.realtime));
        LogUtil.e("C", weatherJson);
        weatherBean = JsonUtils.getObjByGson(weatherJson, WeatherBean.class);
        return weatherBean;
    }

    /*****
     * @param info
     * @return
     */
    public boolean insertWeatherBean2DB(String info){
        mDB = AppDBUtils.getDB();
        boolean isCreate=false;
        //如果从数据库中可以查到这些数据那么只做更新操作
        WeatherBean weatherBean = getWeatherBean(info);
        if(AppDBUtils.createTable(weatherBean)){
            isCreate=true;
        }
        //将天气信息存到数据库
        return isCreate;
    }

    private DbManager mDB = null;
    public WeatherBean getWeatherBean4DB(){
        mDB = AppDBUtils.getDB();
      return AppDBUtils.findFirst(WeatherBean.class);
    }
    public Wind getWind4DB(){
        mDB = AppDBUtils.getDB();
        return AppDBUtils.findFirst(Wind.class);
    }
    public Weather getWeather4DB(){
        mDB = AppDBUtils.getDB();
        return AppDBUtils.findFirst(Weather.class);
    }

}
