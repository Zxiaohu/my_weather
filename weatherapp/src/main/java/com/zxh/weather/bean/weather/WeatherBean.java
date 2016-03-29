package com.zxh.weather.bean.weather;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 *
 */
@Table(name = "t_weather_bean")
public class WeatherBean {
    /***w_b   ====  weather_bean**/
    @Column(name = "w_b_id",isId=true,property = "1",autoGen = false)
    public int id;
    /**
     * 城市代码
     **/
    @Column(name = "w_b_city_code")
    public long city_code;
    /**
     * 城市名称
     **/
    @Column(name ="w_b_city_name")
    public String city_name;
    /**
     * 阳历
     **/
    @Column(name = "w_b_date")
    public String date;
    /**
     * 农历
     **/
    @Column(name = "w_b_moon")
    public String moon;
    /**
     * 时间
     **/
    @Column(name = "w_b_time")
    public String time;
    /**
     * 天气信息
     ***/
    public Weather weather;
    /**
     * 星期
     **/
    public String week;
    /**
     * 风况
     **/
    public Wind wind;

    @Override
    public String toString() {
        return "WeatherBean{" +
                "city_code=" + city_code +
                ", city_name='" + city_name + '\'' +
                ", date='" + date + '\'' +
                ", moom='" + moon + '\'' +
                ", time='" + time + '\'' +
                ", weather=" + weather +
                ", week=" + week +
                ", wind=" + wind +
                '}';
    }
}
