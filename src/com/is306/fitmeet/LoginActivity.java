package com.is306.fitmeet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	Button loginBtn;
    String loginid="";
    String pwd="";
    EditText loginid_v,pwd_v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		loginBtn = (Button)findViewById(R.id.button_login);
        loginid_v =  (EditText)findViewById(R.id.username);
        pwd_v = (EditText)findViewById(R.id.login_password);
        
        loginBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                if(loginid_v.getText().toString().equals(loginid) && pwd_v.getText().toString().equals(pwd))
                {
                    Toast.makeText(LoginActivity.this, "Welcome, "+loginid_v.getText()+".".toString(), Toast.LENGTH_LONG).show();

                    Intent n = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(n);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                }
            }

        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
	        moveTaskToBack(true);
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	//public void loginProcess(View view){
		//Intent intent = new Intent(this, MainActivity.class);
		//startActivity(intent);
	//}
	
	public void registerNow(View view){
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
		
	}

}
