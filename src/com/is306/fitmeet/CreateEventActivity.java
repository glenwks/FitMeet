package com.is306.fitmeet;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.is306.fitmeet.R;


public class CreateEventActivity extends Activity {
	
	Button btnSelectStartDate, btnSelectStartTime, btnSelectEndTime;
	static final int START_DATE_DIALOG_ID = 0;
	static final int START_TIME_DIALOG_ID= 1;
	static final int END_TIME_DIALOG_ID= 2;
	
	public  int year,month,day,hour;
	public String minute;  
	public  int yearSelected,monthSelected,daySelected,hourSelected,minuteSelected;
	private int mYear, mMonth, mDay, mHour, mMinute; 
	
	public CreateEventActivity(){
		final Calendar c = Calendar.getInstance();
	    mYear = c.get(Calendar.YEAR);
	    mMonth = c.get(Calendar.MONTH);
	    mDay = c.get(Calendar.DAY_OF_MONTH);
	    mHour = c.get(Calendar.HOUR_OF_DAY);
	    mMinute = c.get(Calendar.MINUTE);
	    
	}	   
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event);
		// Show the Up button in the action bar.
		setupActionBar();
		
		btnSelectStartDate=(Button)findViewById(R.id.button_start_date);
        btnSelectStartTime=(Button)findViewById(R.id.button_start_time);
        btnSelectEndTime = (Button)findViewById(R.id.button_end_time);
        
        // Set ClickListener on btnSelectDate
        btnSelectStartDate.setOnClickListener(new View.OnClickListener() {
           
            @SuppressWarnings("deprecation")
			public void onClick(View v) {
                // Show the DatePickerDialog
                 showDialog(START_DATE_DIALOG_ID);
            }
        });
        
       
        // Set ClickListener on btnSelectTime
        btnSelectStartTime.setOnClickListener(new View.OnClickListener() {
           
            @SuppressWarnings("deprecation")
			public void onClick(View v) {
                // Show the TimePickerDialog
                 showDialog(START_TIME_DIALOG_ID);
            }
        });
        
        btnSelectEndTime.setOnClickListener(new View.OnClickListener() {
            
            @SuppressWarnings("deprecation")
			public void onClick(View v) {
                // Show the TimePickerDialog
                 showDialog(END_TIME_DIALOG_ID);
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
		getMenuInflater().inflate(R.menu.create_event, menu);
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
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private DatePickerDialog.OnDateSetListener mStartDateSetListener =
        new DatePickerDialog.OnDateSetListener() {
			// the callback received when the user "sets" the Date in the DatePickerDialog
            public void onDateSet(DatePicker view, int yearSelected,
                                  int monthOfYear, int dayOfMonth) {
               year = yearSelected;
               month = monthOfYear;
               day = dayOfMonth;
               // Set the Selected Date in Select date Button
               btnSelectStartDate.setText(+day+"/"+month+"/"+year);
            }
     	};
          

         	// Register  TimePickerDialog listener                
 	private TimePickerDialog.OnTimeSetListener mStartTimeSetListener =
	    new TimePickerDialog.OnTimeSetListener() {
	 		// the callback received when the user "sets" the TimePickerDialog in the dialog
	        public void onTimeSet(TimePicker view, int hourOfDay, int min) {
	            String amPM = "AM";
	            if(hourOfDay>12){
	            	hour = hourOfDay - 12;
	            	amPM ="PM";
	            }else if(hourOfDay==12){
	            	hour = hourOfDay;
	            	amPM = "PM";
	            }else{
	            	hour = hourOfDay;
	            }
	        	
	            if(min<10){
	            	minute="0"+Integer.toString(min);
	            }else{
	            	minute=Integer.toString(min);
	            }
	            
	            // Set the Selected Date in Select date Button
	            btnSelectStartTime.setText(hour+":"+minute+" "+ amPM);
	          }
	    };
    
    private TimePickerDialog.OnTimeSetListener mEndTimeSetListener =
	    new TimePickerDialog.OnTimeSetListener() {
	 		// the callback received when the user "sets" the TimePickerDialog in the dialog
	        public void onTimeSet(TimePicker view, int hourOfDay, int min) {
	            
	            String amPM = "AM";
	            if(hourOfDay>12){
	            	hour = hourOfDay - 12;
	            	amPM ="PM";
	            }else if(hourOfDay==12){
	            	hour = hourOfDay;
	            	amPM = "PM";
	            }else{
	            	hour = hourOfDay;
	            }
	        	
	            if(min<10){
	            	minute="0"+Integer.toString(min);
	            }else{
	            	minute=Integer.toString(min);
	            }
	            
	            // Set the Selected Date in Select date Button
	            btnSelectEndTime.setText(hour+":"+minute+" "+ amPM);
	          }
	    };


    // Method automatically gets Called when you call showDialog()  method
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case START_DATE_DIALOG_ID:
        	// create a new DatePickerDialog with values you want to show
            return new DatePickerDialog(this,
                        mStartDateSetListener, mYear, mMonth, mDay);
            // create a new TimePickerDialog with values you want to show
        case START_TIME_DIALOG_ID:
            return new TimePickerDialog(this,
                    mStartTimeSetListener, mHour, mMinute, false);
            
        case END_TIME_DIALOG_ID:
            return new TimePickerDialog(this,
                    mEndTimeSetListener, mHour, mMinute, false);
        }
        return null;
    }

}
