package com.zxh.weather.comm.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.zxh.weather.comm.utils.ActivityUtils;

import org.xutils.common.util.LogUtil;
import org.xutils.x;

/**
 * Created by xiaohu on 2016/3/26.
 */
public abstract class BaseActivity extends FragmentActivity {

    //是否创建
    private boolean isCreate=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加activity
        LogUtil.d(this.getClass().getSimpleName() + "被加载");
        ActivityUtils.addActivity(this);
        x.view().inject(this);
        //表示以创建
        isCreate=true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (isCreate){
            isCreate=false;
            //初始化数据
            initData();
        }
    }

    /**初始化数据**/
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除activity
        ActivityUtils.removeActivity(this);
        LogUtil.e(this.getClass().getSimpleName() + "销毁被");
    }
}
