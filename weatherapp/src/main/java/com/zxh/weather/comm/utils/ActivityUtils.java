package com.zxh.weather.comm.utils;

import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * activity管理者
 *
 */
public class ActivityUtils {

	public static List<FragmentActivity> activities = new ArrayList<FragmentActivity>();

	public static void  addActivity(FragmentActivity activity){
		activities.add(activity);
	}
	public static void removeActivity(FragmentActivity activity){
		activities.remove(activity);
	}
	/**结束所有的activity**/
	public static void finshAll(){
		for (FragmentActivity activity : activities) {
			if(!activity.isFinishing()){
				activity.finish();}
			
		}
	}

	/**
	 * 移除所有的除了（activityclass）这个activity
	 * @param activityclass
     */
	public static void backToMain(Class activityclass){
		for (FragmentActivity activity : activities) {
			if(activity.getClass().getName().equals(activityclass.getName()))
				continue;
			if(!activity.isFinishing()){
				activity.finish();}
			
		}
	}
}
