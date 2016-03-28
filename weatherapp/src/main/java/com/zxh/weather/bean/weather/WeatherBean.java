package com.zxh.weather.bean.weather;

/**
 *
 */
public class WeatherBean {
    /**
     * 城市代码
     **/
    public long city_code;
    /**
     * 城市名称
     **/
    public String city_name;
    /**
     * 阳历
     **/
    public String date;
    /**
     * 农历
     **/
    public String moon;
    /**
     * 时间
     **/
    public String time;
    /**
     * 天气信息
     ***/
    public Weather weather;

    public class Weather {
        /**
         * 温度
         **/
        public String temperature;
        /**
         * 湿度
         */
        public String humidity;
        /**
         * 详细情况
         */
        public String info;
    }

    /**
     * 星期
     **/
    public String week;
    /**
     * 风况
     **/
    public Wind wind;

    public class Wind {
        /**
         * 风向
         **/
        public String direct;
        /**
         * 风力
         **/
        public String power;
    }

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
