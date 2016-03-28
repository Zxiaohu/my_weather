package com.zxh.weather.bean.weather;

/**
 * Created by xiaohu on 2016/3/26.
 */
public class LifeData {
    /***发布的时间***/
    public String date;
    /****生活数据中对应的各种指数***/
    public Info info;
    public class Info {
        /**穿衣指数**/
        public String[] chuanyi;
        /**感冒指数**/
        public String[] ganmao;
        /**空调指数**/
        public String[] kongtiao;
        /**污染指数***/
        public String[] wuran;
        /***洗车指数***/
        public String[] xiche;
        /**运动指数**/
        public String[] yundong;
        /***紫外线指数***/
        public String[] ziwaixian;
    }
}
