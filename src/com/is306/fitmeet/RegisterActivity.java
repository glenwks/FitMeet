package com.is306.fitmeet;

import java.util.ArrayList;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class RegisterActivity extends Activity {
	
	public int year,month,day;
	public Button btnSelectDOB;
	public int yearSelected,monthSelected,daySelected;
	private int mYear, mMonth, mDay;
	
	final Activity activity = this;
	
	public EditText username, password, confirmPass, profileName, hobbies;
	public RadioGroup genderGroup;
	public RadioButton gender;
	
	public int age;
	
	public String usernameVal , passwordVal, confirmPassVal, profileNameVal, genderVal, dobVal;
	public ArrayList<String> hobbiesVal = new ArrayList<String>();
	
	public RegisterActivity(){	
		final Calendar c = Calendar.getInstance();
	    mYear = c.get(Calendar.YEAR);
	    mMonth = c.get(Calendar.MONTH);
	    mDay = c.get(Calendar.DAY_OF_MONTH);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		// Show the Up button in the action bar.
		setupActionBar();
		
		username = (EditText)findViewById(R.id.register_username);
		password = (EditText)findViewById(R.id.register_password);
		confirmPass =(EditText)findViewById(R.id.register_confirm_password);
		profileName = (EditText)findViewById(R.id.register_profile_name);
		hobbies = (EditText)findViewById(R.id.register_hobbies);
		genderGroup = (RadioGroup)findViewById(R.id.radio_gender);
		btnSelectDOB=(Button)findViewById(R.id.registration_dob_val);
		btnSelectDOB.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
		btnSelectDOB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Display Date Picker Dialog
				Dialog dialog = new DatePickerDialog(activity, mDateSetListener, mYear, mMonth, mDay);
		    	dialog.show();
			}
		});
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener =
	        new DatePickerDialog.OnDateSetListener() {
				// the callback received when the user "sets" the Date in the DatePickerDialog
	            public void onDateSet(DatePicker view, int yearSelected,
	                                  int monthOfYear, int dayOfMonth) {
	               year = yearSelected;
	               month = monthOfYear;
	               day = dayOfMonth;
	               // Set the Selected Date in Select date Button
	               btnSelectDOB.setText(day+"/"+(month+1)+"/"+year);
	            }
	     	};

	
	public void processRegistration(View view){
		
		usernameVal = username.getText().toString();
		passwordVal = password.getText().toString();
		confirmPassVal = confirmPass.getText().toString();
		profileNameVal = profileName.getText().toString();
		int selectedGender = genderGroup.getCheckedRadioButtonId();
		gender = (RadioButton)findViewById(selectedGender);
		genderVal = gender.getText().toString();
		dobVal = btnSelectDOB.getText().toString();
		
		if(usernameVal.trim().length()==0||passwordVal.trim().length()==0||profileNameVal.trim().length()==0||hobbies.getText().toString().trim().length()==0){
			Toast.makeText(RegisterActivity.this, "Please fill up all neccessary fields.", Toast.LENGTH_SHORT).show();
		}else if(year>mYear){
			Toast.makeText(RegisterActivity.this, "Invalid Date of birth.", Toast.LENGTH_SHORT).show();
		}else if(year==mYear){
			if(month>mMonth){
				Toast.makeText(RegisterActivity.this, "Invalid Date of birth.", Toast.LENGTH_SHORT).show();
			}else if(month==mMonth){
				if(day>mDay){
					Toast.makeText(RegisterActivity.this, "Invalid Date of birth.", Toast.LENGTH_SHORT).show();
				}
			}
		}else if(!passwordVal.equals(confirmPassVal)){
			Toast.makeText(RegisterActivity.this, "Password does not match. Re-enter password.", Toast.LENGTH_SHORT).show();
		}else{
			age = mYear - year;
			hobbiesVal.add(hobbies.getText().toString());
			UsersDAO.loginUserPool.add(new User(usernameVal,passwordVal,profileNameVal,genderVal,age,hobbiesVal));
			Toast.makeText(RegisterActivity.this, "Registration Successful! Proceed to login.", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
		}	
	}
	
	public boolean checkUserAvaliable(String username){
		for(int i=0;i<UsersDAO.loginUserPool.size();i++){
			if(UsersDAO.loginUserPool.get(i).equals(username)){
				Toast.makeText(RegisterActivity.this, "Username taken. Please choose another username.", Toast.LENGTH_SHORT).show();
				return true;
			}
		}
		return false;
	}

}
