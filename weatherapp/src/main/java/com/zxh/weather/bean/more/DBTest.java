package com.zxh.weather.bean.more;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by zxh on 2016/3/29.
 */
@Table(name = "DBTest")
public class DBTest {

  @Column(name = "id",isId = true,autoGen = true)
  public int id;
  @Column(name = "name")
  public String name;
  @Column(name = "age")
  public int age;

//  public int getId() {
//    return id;
//  }
//
//  public void setId(int id) {
//    this.id = id;
//  }
//
//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }
//
//  public int getAge() {
//    return age;
//  }
//
//  public void setAge(int age) {
//    this.age = age;
//  }
}
