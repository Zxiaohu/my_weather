package com.zxh.weather.ui;
import android.os.Bundle;
import android.widget.TextView;

import com.zxh.weather.R;
import com.zxh.weather.comm.base.BaseFragment;
import com.zxh.weather.presenter.SelectCityP;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by zxh on 2016/3/28.
 */
public class SlectCityFragment extends BaseFragment<ISelectCityView,SelectCityP> implements ISelectCityView{


  @ViewInject(R.id.tv)
  private TextView tv;
  @Override
  public void initData(Bundle savedInstanceState) {
    mPresenter.fetchProvince();
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
  public void testData(String result) {
    tv.setText(result);
  }
}
