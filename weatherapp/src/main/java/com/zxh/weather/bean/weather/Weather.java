package com.zxh.weather.bean.weather;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by zxh on 2016/3/29.
 * 天气详情表
 */
@Table(name = "t_weather")
public class Weather {
  //w
  @Column(name ="w_id",isId = true,property = "1",autoGen = false)
  public int id;
  /**
   * 温度
   **/
  @Column(name = "w_temperature")
  public String temperature;
  /**
   * 湿度
   */
  @Column(name = "w_humidity")
  public String humidity;
  /**
   * 详细情况
   */
  @Column(name="w_info")
  public String info;
}
