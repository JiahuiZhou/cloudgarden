package com.windowgarden.app.util;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class DialogDisplayUtil {

	public static void showAlertDialog(String message) {
		AlertDialog.Builder dialog = new AlertDialog.
				Builder(MyApplication.getContext());
		dialog.setTitle("��ʾ��Ϣ�Ի���");
		dialog.setMessage(message);
		dialog.setCancelable(false);
		dialog.setPositiveButton("֪����", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		dialog.show();
		
		/*
		dialog.setNegativeButton("����", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		*/
	}
}
