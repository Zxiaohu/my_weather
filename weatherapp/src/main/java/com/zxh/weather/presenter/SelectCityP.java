package com.zxh.weather.presenter;

import com.zxh.weather.comm.base.BasePresenter;
import com.zxh.weather.comm.http.MyCallBack;
import com.zxh.weather.comm.http.XutilsHttp;
import com.zxh.weather.comm.utils.LogUtil;
import com.zxh.weather.dao.CityInfoDao;
import com.zxh.weather.ui.ISelectCityView;

/**
 * Created by zxh on 2016/3/28.
 */
public class SelectCityP extends BasePresenter<ISelectCityView>{

    //请求地址
    private static final String url="http://api.dangqian.com/apidiqu2/api.asp?";



  //获取请求地址
    private String getUrl(String id){
      return url+"id="+id;
    }

    //获取全国的省级的名称
    public void fetchProvince(){
      String url = getUrl("000000000000");
      LogUtil.e("test",url);
      XutilsHttp.doGet(url, new MyCallBack() {
        @Override
        public void onSuccess(String result) {
          //显数据
          getView().testData(CityInfoDao.getInsatanse().getMainData(result));
        }
      });
    }
}
