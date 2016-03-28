package com.zxh.weather.comm.base;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.xutils.x;

/**
 * Created by zxh on 2016/3/28.
 */
public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
  /**
   * 根布局
   **/
  protected View mRootView = null;
  /***
   * 上下文
   **/
  protected Context mContext = null;
  /***
   * presenter
   **/
  protected T mPresenter = null;

  /**
   * 初始化数据
   *
   * @param savedInstanceState
   **/
  abstract public void initData(Bundle savedInstanceState);

  @Override
  public void onAttach(Context context) {
    // TODO Auto-generated method stub
    super.onAttach(context);
    mContext = context;
    mPresenter = createPresenter();
    if (mPresenter != null) {
      mPresenter.attachView((V) this);
    }
  }

  protected abstract T createPresenter();

  protected abstract int getLayoutId();

  @Override
  public View onCreateView(LayoutInflater inflater,
                           @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    mRootView = inflater.inflate(getLayoutId(), null);
    x.view().inject(this, mRootView);
    return mRootView;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onActivityCreated(savedInstanceState);
    initData(savedInstanceState);
  }


  @Override
  public void onDetach() {
    // TODO Auto-generated method stub
    /**解绑**/
    if (mContext != null) {
      mContext = null;
    }
    if (mPresenter != null) {
      mPresenter.detachView();
    }
    super.onDetach();
  }
}
