package com.zxh.weather.dao.cityinfo;

/**
 * Created by zxh on 2016/3/29.
 */
public abstract class BaseCityInfoDao {
  /***获取城市信息***/
  abstract public void getCityInfo();

  protected DataState mDataStateCallBack=null;
  //设置数据回调
  public BaseCityInfoDao addCallBack(DataState dataStateCallBack){
    this.mDataStateCallBack=dataStateCallBack;
    return this;
  }

  /****
   * 数据状态回调
   * ***/
  public interface DataState{
    void onDataSuccess(String result);
    void onDataFail(String failinfo);
  }

}
