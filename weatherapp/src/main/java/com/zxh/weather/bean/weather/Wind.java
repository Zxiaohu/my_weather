package com.zxh.weather.bean.weather;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by zxh on 2016/3/29.
 */
@Table(name = "t_wind")
public class Wind {
  @Column(name = "wind_id",isId = true,property = "1",autoGen = false)
  public int id;
  /**
   * 风向
   **/
  @Column(name = "wind_direct")
  public String direct;
  /**
   * 风力
   **/
  @Column(name = "wind_power")
  public String power;
}
