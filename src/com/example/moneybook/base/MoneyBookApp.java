package com.example.moneybook.base;

import com.example.moneybook.db.DBManager;
import com.example.moneybook.manager.ApplicationManager;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class MoneyBookApp extends Application{

	public static String LOG_TAG = "MoneyBook";
	
	private String appVersionName = null; 
	private int appVersionCode = 0; 

	@Override
	public void onCreate() {
		super.onCreate();
		
		
		PackageManager manager = this.getPackageManager();
		try { 
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			appVersionName = info.versionName; 
			appVersionCode = info.versionCode;
		} catch (NameNotFoundException e) {
			Log.e(LOG_TAG, ""+e);
			e.printStackTrace();
		}
		
		ApplicationManager.getInstance().setContext(getApplicationContext());
		ApplicationManager.getInstance().setVersionCode(appVersionCode);
		ApplicationManager.getInstance().setVersionName(appVersionName);

		DBManager.getInstance();
	}
	
	
}
