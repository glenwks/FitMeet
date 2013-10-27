package com.is306.fitmeet;

import java.util.ArrayList;

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
    EditText loginid_v,pwd_v;
    ArrayList<String> userNameList = new ArrayList<String>();
    ArrayList<String> hobbiesList;
    
    public LoginActivity(){
    	hobbiesList = new ArrayList<String>();
		hobbiesList.add("Tennis");
		UsersDAO.loginUserPool.add(new User("glenW", "", "Glen Wong", "Male", 24, hobbiesList));
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Basketball");
		hobbiesList.add("Running");
		hobbiesList.add("Badminton");
		UsersDAO.loginUserPool.add(new User("alexL","pass1234","Alex Lin", "Male", 27, hobbiesList));
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Basketball");
		hobbiesList.add("Tennis");
		UsersDAO.loginUserPool.add(new User("jakeL","pass1234","Jake Low", "Male", 24, hobbiesList));
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Running");
		UsersDAO.loginUserPool.add(new User("sHui","pass1234","Chan Si Hui", "Female", 22, hobbiesList));
		UsersDAO.loginUserPool.add(new User("jeanT","pass1234","Jean Tan", "Female", 32, hobbiesList));
		UsersDAO.loginUserPool.add(new User("jK","pass1234","Joel Koh", "Male", 23, hobbiesList));
		UsersDAO.loginUserPool.add(new User("elNg","pass1234","Eileen Ng", "Female", 29, hobbiesList));
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Fighting");
		UsersDAO.loginUserPool.add(new User("fSaid","pass1234","Fariq Bin Said", "Male", 24, hobbiesList));
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Basketball");
		hobbiesList.add("Running");
		UsersDAO.loginUserPool.add(new User("kEngSen","pass1234","Kee Eng Sen", "Male", 23, hobbiesList));

		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Gymming");
		hobbiesList.add("Tennis");
		UsersDAO.loginUserPool.add(new User("edTan","pass1234","Edwin Tan", "Male", 22, hobbiesList));
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Sleeping");
		hobbiesList.add("Walking");
		UsersDAO.loginUserPool.add(new User("kyTan","pass1234","Kelly Tan", "Female", 32, hobbiesList));
		
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		loginBtn = (Button)findViewById(R.id.button_login);
        loginid_v =  (EditText)findViewById(R.id.username);
        pwd_v = (EditText)findViewById(R.id.login_password);
        
        loginBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
            	
            	if(loginProcess(loginid_v.getText().toString(),pwd_v.getText().toString())==true){
            		Intent n = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(n);
            	}else{
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
	
	public boolean loginProcess(String loginid, String pwd){
		for(int i = 0 ; i < UsersDAO.loginUserPool.size(); i++){
			if(UsersDAO.loginUserPool.get(i).getUsername().equals(loginid) && UsersDAO.loginUserPool.get(i).getPassword().equals(pwd) ){				
				UsersDAO.currentUser = UsersDAO.loginUserPool.get(i);
				UsersDAO.recommendedUserList(UsersDAO.currentUser.getUsername());
				Toast.makeText(LoginActivity.this, "Welcome, "+UsersDAO.currentUser.getName()+".".toString(), Toast.LENGTH_LONG).show();	
                return true;
			}
		}
		return false;
	}
	
	public void registerNow(View view){
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
		
	}

}
