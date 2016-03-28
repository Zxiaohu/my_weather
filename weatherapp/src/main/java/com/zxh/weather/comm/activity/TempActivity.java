package com.zxh.weather.comm.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.zxh.weather.R;
import com.zxh.weather.comm.base.BaseActivity;

/*****
 * TempActivity
 *
 * @author zxh
 *         这个activity是用来承载fragment的activity
 *         根据不同的标记动态的加载fragment
 */
public class TempActivity extends BaseActivity {

    private static Fragment baseFragment;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    public void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        setContentView(R.layout.activity_temp);
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //设置动画效果
        mFragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        if (baseFragment != null) {
            //填充fragment并提交
            mFragmentTransaction.add(R.id.fl_content, baseFragment);
            mFragmentTransaction.commit();
        }
    }

    @Override
    protected void initData() {

    }

    /**
     * 为activity设置fragment
     **/
    public static void setFrg4Ac(Fragment baseFragment) {
        TempActivity.baseFragment = baseFragment;
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }


}
