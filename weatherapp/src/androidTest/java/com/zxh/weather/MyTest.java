package com.zxh.weather;

import android.test.AndroidTestCase;

import com.zxh.weather.bean.more.DBTest;
import com.zxh.weather.comm.utils.AppDBUtils;
import com.zxh.weather.comm.utils.LogUtil;
import com.zxh.weather.presenter.SelectCityP;

import org.junit.Before;
import org.junit.Test;
import org.xutils.ex.DbException;

/**
 * Created by zxh on 2016/3/28.
 */
public class MyTest extends AndroidTestCase{
  SelectCityP P=null;
  @Before
  public void setUp() throws Exception {
    P =new SelectCityP();
  }
  @Test
  public void testJJJJ(){
    LogUtil.e("test","测试开始");
    //P = new SelectCityP();
    //P.fetchCityInfo();
    DBTest test= new DBTest();
    test.id=10003;
    test.age=18;
    test.name="赵小虎";
    AppDBUtils.createTable(test);
    try {

      DBTest dbTest = AppDBUtils.createDB().findFirst(DBTest.class);
      LogUtil.e("test",dbTest.name);
    } catch (DbException e) {
      e.printStackTrace();
    }
  }
}
