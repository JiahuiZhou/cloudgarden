package com.windowgarden.app.database;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import com.windowgarden.app.model.PlantInfo;
import com.windowgarden.app.util.MyApplication;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

/**
 * ��װһЩ���õ����ݿ����
 * 
 * @author pigyu
 *
 */

public class PlantDatabase {

	private static PlantDatabase plantDatabase;
	
	@SuppressWarnings("unused")
	private SQLiteDatabase db;
	
	public PlantInfo myPlantInfo;
	
	/**
	 * ���췽��˽�л�
	 */
	private PlantDatabase() {
		db = Connector.getDatabase();
	}
	
	/**
	 * ��ȡPlantDatabase��ʵ����������
	 */
	public synchronized static PlantDatabase getInstance() {
		if(plantDatabase == null) {
			plantDatabase = new PlantDatabase();
		}
		return plantDatabase;
	}

	public void savePlantInfo(PlantInfo plantInfo) {
		// TODO Auto-generated method stub
		plantInfo.save();
	}
	
	public void saveToSharedPrefs(String id) {
		// TODO Auto-generated method stub
		SharedPreferences.Editor editor = MyApplication.getContext().
				getSharedPreferences("myPlantInfo" + id, 0).edit();
		if(!TextUtils.isEmpty(id)) {
			 long longId = Long.parseLong(id);
			 myPlantInfo = DataSupport.find(PlantInfo.class, longId);
		}
		editor.clear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��M��d��", Locale.CHINA);
		editor.putLong("myId", myPlantInfo.getId());
		editor.putFloat("myWaterLevel", myPlantInfo.getWaterLevel());
		editor.putFloat("myLightLevel", myPlantInfo.getLightLevel());
		editor.putString("update_date", sdf.format(new Date()));
		editor.putBoolean("is_saved", true);
		editor.commit();
	}
	
}
