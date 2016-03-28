package com.zxh.weather.dao;

import com.zxh.weather.comm.utils.LogUtil;

/**
 * Created by zxh on 2016/3/28.
 */
public class CityInfoDao {
  private static CityInfoDao mInsatanse;
  private CityInfoDao(){

  }
  public static CityInfoDao getInsatanse(){
    if(mInsatanse==null){
      mInsatanse = new CityInfoDao();
    }
    return mInsatanse;
  }

  //获取核心的信息
  public String getMainData(String data){
    String citynameJsonStr=data.substring(data.indexOf("("),data.indexOf(")"));
    LogUtil.e("test",citynameJsonStr);
    return citynameJsonStr;
  }
}
