package com.box.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.widget.Toast;

/**
 * 放一些功能进去
 * 
 */
public class Utils {
	private static Context mApplcationContent;

	public static void initialize(Application app) {
		mApplcationContent = app.getApplicationContext();
	}

	/**
	 * 取屏幕宽度
	 * @return
	 */
	public static int getScreenWidth() {
		DisplayMetrics dm = mApplcationContent.getResources()
				.getDisplayMetrics();
		return dm.widthPixels;
	}

	/**
	 * 取屏幕高度
	 */
	public static int getScreenHeight() {
		DisplayMetrics dm = mApplcationContent.getResources()
				.getDisplayMetrics();
		return dm.heightPixels;
	}

	/**
	 * 快捷的吐司显示
	 * @param content
	 */
	public static void Toast(String content) {
		Toast.makeText(mApplcationContent, content, Toast.LENGTH_SHORT).show();
	}

	/**
	 * dp转px
	 * 
	 */
	public static int dip2px(float dpValue) {
		final float scale = mApplcationContent.getResources()
				.getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * px转dp
	 */
	public static int px2dip(float pxValue) {
		final float scale = mApplcationContent.getResources()
				.getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 得到SharePreferences文件
	 * 
	 * @return
	 */
	public static SharedPreferences getPreference() {
		return mApplcationContent.getSharedPreferences(Constant.LOCAL_SP,
				Activity.MODE_PRIVATE);
	}

	/**
	 * 时间戳转环
	 * 
	 * @param code
	 * @return
	 */

	public static String getTime(long code) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date(code * 1000L));
		return date;
	}

	/**
	 * 是否有网络
	 * 
	 * @return
	 */
	public static boolean isNetWorkAvilable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) mApplcationContent
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo == null || !activeNetInfo.isAvailable()) {
			return false;
		} else {
			return true;
		}
	}
	
}
