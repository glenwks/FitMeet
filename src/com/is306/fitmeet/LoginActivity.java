package com.is306.fitmeet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	public void loginProcess(View view){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void registerNow(View view){
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
		
	}

}
