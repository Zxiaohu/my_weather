package com.zxh.weather.comm.utils;

import android.os.Environment;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.io.File;

/**
 * Created by zxh on 2016/3/29.
 */
public class AppDBUtils {
  /**
   * 数据库的名称
   **/
  private final static String DB_NAME = "zxh_weather_db";
  private static DbManager.DaoConfig DB_CONFIG = null;
  private static DbManager mDB;

  static {
    DB_CONFIG = new DbManager.DaoConfig();
    DB_CONFIG.setDbName(DB_NAME)//数据库名称
            .setDbDir(new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                    "my_db"))
            .setDbVersion(1);
    mDB = x.getDb(DB_CONFIG);
  }

  /***
   * 创建数据库对象
   ***/
  public static DbManager getDB() {
    //配置数据库的对象
    return mDB;
  }

  public static boolean createTable(Object obj) {
    try {
      mDB.saveOrUpdate(obj);
      return true;
    } catch (DbException e) {
      e.printStackTrace();
    }
    return false;
  }

  /***
   * 从数据库中查询第一条
   * @param CLASS
   * @param <T>
   * @return
   */
  public static <T>T findFirst(Class<T> CLASS){
    try {
      return mDB.findFirst(CLASS);
    } catch (DbException e) {
      e.printStackTrace();
    }
    return null;
  }


}