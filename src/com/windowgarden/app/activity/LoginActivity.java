package com.windowgarden.app.activity;

import com.windowgarden.app.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener{

	private Button login;
	
	private Button register;
	
	private EditText account;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		login = (Button) findViewById(R.id.login);
		register = (Button) findViewById(R.id.register);
		account = (EditText) findViewById(R.id.account);
		login.setOnClickListener(this);
		register.setOnClickListener(this);
		
		//�жϣ��������˼�ס���롢�Զ���¼��������intent��
		//����ʵ�ּ�ס����
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login:
			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			intent.putExtra("id", account.getText().toString());
			startActivity(intent);
			finish();
			break;
		case R.id.register:
			Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
			startActivity(registerIntent);
			break;	
		default:
			break;
		}
	}
}
