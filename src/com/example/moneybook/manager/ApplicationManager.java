package com.example.moneybook.manager;

import android.app.Application;
import android.content.Context;

public class ApplicationManager {

	private static final String TAG = ApplicationManager.class.getSimpleName();
	
	private static ApplicationManager instance = null;
	private Context context = null;
	private int versionCode = 0;
	private String versionName = null;
	
	ApplicationManager(){
		
	}
	
	public static ApplicationManager getInstance(){
		if(instance==null){
			instance = new ApplicationManager();
		}
		return instance;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	public int getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
}
