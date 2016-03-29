package com.zxh.weather.dao.cityinfo;

import com.zxh.weather.R;
import com.zxh.weather.comm.http.MyCallBack;
import com.zxh.weather.comm.http.XutilsHttp;
import com.zxh.weather.comm.utils.AppResTools;
import com.zxh.weather.comm.utils.LogUtil;

/**
 * 城市信息处理（通过阿凡达数据平台提供的接口）
 * Created by zxh on 2016/3/28.
 */
public class CityInfoDao extends BaseCityInfoDao{

  private static CityInfoDao mInsatanse;
  private CityInfoDao(){
  }
  public static CityInfoDao getInsatanse(){
    if(mInsatanse==null){
      mInsatanse = new CityInfoDao();
    }
    return mInsatanse;
  }
  //父级的id
  private String mParentId=null;
  public CityInfoDao addParentId(String parentId){
    this.mParentId=parentId;
    return this;
  }
  /*****
   * 接口文档的信息
   * <a>http://www.avatardata.cn/Docs/Api/6d39633a-c340-40e2-ad7b-eb81463b21fd</a>
   * 通过parentid获取请求地址
   * @param parentId
   * @return
   */
  private String getUrl(String parentId){
    return AppResTools.getStr(R.string.url_china_area)+"&parentId="+parentId;
  }

  /*****
   * 获取省份信息
   * @param parentId 通过parentid获取请求地址
   */
  public void fetchProvince(String parentId){
    String url = getUrl(parentId);
    LogUtil.e("test",url);
    XutilsHttp.doGet(url, new MyCallBack() {
      @Override
      public void onSuccess(String result) {
        //数据准备成功
        mDataStateCallBack.onDataSuccess(result);
      }
      @Override
      public void onError(Throwable ex, boolean isOnCallback) {
        super.onError(ex, isOnCallback);
        //数据请求失败
        mDataStateCallBack.onDataFail(ex.getMessage());
      }
    });
  }

  @Override
  public void getCityInfo() {
    if(this.mParentId!=null) {
      fetchProvince(this.mParentId);
    }
  }
}
