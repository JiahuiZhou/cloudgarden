package com.windowgarden.app.util;

import org.litepal.LitePalApplication;
import android.content.Context;

public class MyApplication extends LitePalApplication {

	private static Context context;
	
	@Override
	public void onCreate() {
		context = getApplicationContext();
	}
	
	public static Context getContext() {
		return context;
	}
}
