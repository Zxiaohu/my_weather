package com.zxh.weather.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.zxh.weather.R;
import com.zxh.weather.bean.weather.WeatherBean;
import com.zxh.weather.comm.activity.TempActivity;
import com.zxh.weather.comm.base.BaseActivity;
import com.zxh.weather.comm.http.MyCallBack;
import com.zxh.weather.comm.http.XutilsHttp;
import com.zxh.weather.comm.utils.AppResTools;
import com.zxh.weather.comm.utils.ToastUtils;
import com.zxh.weather.dao.WeatherDao;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by xiaohu on 2016/3/26.
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

  @ViewInject(R.id.tv_cityname)
  private TextView tv_cityname;//城市名称
  @ViewInject(R.id.tv_date)
  private TextView tv_date;//阳历的日期
  @ViewInject(R.id.tv_moon)
  private TextView tv_moon;//阴历的日期
  @ViewInject(R.id.tv_endtime)
  private TextView tv_endtime;//结束时间
  @ViewInject(R.id.tv_weatherstate)
  private TextView tv_weatherstate;//天气
  @ViewInject(R.id.tv_temperature)
  private TextView tv_temperature;//温度
  @ViewInject(R.id.tv_humidity)
  private TextView tv_humidity;//湿度
  @ViewInject(R.id.tv_wind)
  private TextView tv_wind;//风况

  private String mUrl = "http://op.juhe.cn/onebox/weather/query?key=" + AppResTools.getStr(R.string.appkey);
  @Event(value = R.id.btn_cityname,type =View.OnClickListener.class)
  private void selectCityName(View v){
    TempActivity.setFrg4Ac(new SlectCityFragment());
    startActivity(new Intent(this,TempActivity.class));
  }
  /**
   * 把citynameurl编码后加入地址
   *
   * @param cityname
   * @return
   */
  private String getUrl(String cityname) {
    try {
      //获取天气的地址
      return mUrl + "&cityname=" + URLEncoder.encode(cityname, "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }

  private void fetchWeatherInfo(String cityname) {
    String url = getUrl(cityname);
    if (url == null) return;
    /***发送请求**/
    XutilsHttp.doGet(url, new MyCallBack() {
      @Override
      public void onSuccess(String result) {
        handleWeatherInfo(result);
      }
    });
  }

  private void handleWeatherInfo(String result) {
    //初始化
    WeatherDao weatherDao = WeatherDao.getInstance();
    /**获取生活指数**/
    //LifeData.Info info =  weatherDao.getLifeData(result).info;
    /**获取天气的信息**/
    WeatherBean weatherBean = weatherDao.getWeatherBean(result);
    ToastUtils.show(weatherBean.toString());
    tv_cityname.setText(weatherBean.city_name);
    tv_date.setText(weatherBean.date);
    tv_moon.setText(weatherBean.moon);
    tv_endtime.setText(weatherBean.time);
    tv_weatherstate.setText(weatherBean.weather.info);
    tv_temperature.setText(weatherBean.weather.temperature + "度");
    tv_humidity.setText(weatherBean.weather.humidity + "度");
    tv_wind.setText(weatherBean.wind.direct + "--" + weatherBean.wind.power);
  }
  @Override
  protected void initData() {
    fetchWeatherInfo("襄阳");
  }
}
