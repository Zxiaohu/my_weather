package com.zxh.weather.presenter;

import com.google.gson.Gson;
import com.zxh.weather.bean.city.CityInfo;
import com.zxh.weather.comm.base.BasePresenter;
import com.zxh.weather.comm.utils.LogUtil;
import com.zxh.weather.dao.cityinfo.BaseCityInfoDao;
import com.zxh.weather.dao.cityinfo.CityInfoDao;
import com.zxh.weather.ui.ISelectCityView;

/**
 * Created by zxh on 2016/3/28.
 */
public class SelectCityP extends BasePresenter<ISelectCityView> implements BaseCityInfoDao.DataState {


  public void fetchCityInfo(){
    //获取一级的城市信息
    getCityInfo("");
  }
  //获取城市的
  @Override
  public void onDataSuccess(String result) {
    LogUtil.e("test",result);
    CityInfo cityInfo = new Gson().fromJson(result,CityInfo.class);
    //解析数据的对象
    getView().testData(cityInfo);
  }
  @Override
  public void onDataFail(String failinfo) {

  }
  //获取城市信息的通用方法
  private void getCityInfo(String id){
    //获取城市信息
    CityInfoDao.getInsatanse().addParentId(id).addCallBack(this).getCityInfo();
  }
}
