package com.zxh.weather.comm.utils;

import com.zxh.weather.ApplicationTest;
import com.zxh.weather.bean.more.DBTest;

import org.junit.Before;
import org.junit.Test;
import org.xutils.DbManager;

/**
 * Created by zxh on 2016/3/29.
 */
public class AppDBUtilsTest extends ApplicationTest {
  DbManager db=null;
  DBTest test=null;
  DBTest first=null;
  @Before
  public void setUp() throws Exception{
    db = AppDBUtils.createDB();
    test= new DBTest();
    test.id=10002;
    test.age=18;
    test.name="xxxxxx";
    db.save(test);
    first= db.findFirst(DBTest.class);

  }
  @Test
  public void testCreateDB() throws Exception {
      AppDBUtils.createDB();
  }

  @Test
  public void testCreateTable() throws Exception {

    LogUtil.e("test",db.getDaoConfig().getDbName());
    LogUtil.e("test",first.name);
    LogUtil.e("test","年后啊啊alkl");
  }
}