package com.zxh.weather.ui;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zxh.weather.R;
import com.zxh.weather.bean.city.CityInfo;
import com.zxh.weather.comm.adapter.CommonAdapter;
import com.zxh.weather.comm.adapter.ViewHolder;
import com.zxh.weather.comm.base.BaseFragment;
import com.zxh.weather.presenter.SelectCityP;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by zxh on 2016/3/28.
 */
public class SlectCityFragment extends BaseFragment<ISelectCityView,SelectCityP> implements ISelectCityView,
        AdapterView.OnItemClickListener {

  @ViewInject(R.id.lv_city)
  private ListView lv_city;
  //城市选择的adapter
  private CommonAdapter<CityInfo.Result> mCityAdapter=null;
  @Override
  public void initData(Bundle savedInstanceState) {
    mPresenter.fetchCityInfo();
  }
  @Override
  protected SelectCityP createPresenter() {
    return new SelectCityP();
  }

  @Override
  protected int getLayoutId() {
    return R.layout.frg_selectcity;
  }

  @Override
  public void testData(CityInfo cityInfo) {
    //填充适配器
    initLvCityAdapter(cityInfo);
    //添加点击事件
    lv_city.setOnItemClickListener(this);
  }

  private void initLvCityAdapter(CityInfo cityInfo) {
    if(mCityAdapter==null){
      mCityAdapter = new CommonAdapter<CityInfo.Result>(mContext,cityInfo.result,R.layout.adapter_city) {
        @Override
        public void convert(ViewHolder helper, CityInfo.Result item) {
            helper.setText(R.id.tv_city_name,item.name);
        }
      };
    }else{
      //刷新数据
      mCityAdapter.upateData(cityInfo.result);
    }
    //设置适配器
    lv_city.setAdapter(mCityAdapter);
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    //开始

  }
}
