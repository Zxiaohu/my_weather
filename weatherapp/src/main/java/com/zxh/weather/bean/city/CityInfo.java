package com.zxh.weather.bean.city;

import java.util.List;

/**
 * Created by zxh on 2016/3/29.
 */
public class CityInfo {
  /**
   * 错误码
   **/
  public int error_code;
  /**
   * 错误码的描述
   **/
  public String reason;
  /***
   * 城市结果信息集合
   ***/
  public List<Result> result;

  /****
   * 结果信息对象
   ****/
  public class Result {
    /*
    *  "area_id": "467c34d4-a3a6-4d16-8c78-65814e3a53c3",
       "level": 1,
        "name": "北京市",
        "seq": 0
    *
    * */
    /**区域id**/
    public String area_id;
    /**区域等级***/
    public int level;
    /**区域名称**/
    public String name;
    /***当前区域在整个数据列表中的位置***/
    public int seq;
  }
}
