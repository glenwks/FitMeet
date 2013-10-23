package com.is306.fitmeet;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.is306.fitmeet.R;


public class FacilitiesFragment extends Fragment implements OnClickListener{
	
	public  int year,month,day;
	private int mYear, mMonth, mDay;
	Button btnSelectDate, searchFacilities;
	public  int yearSelected,monthSelected,daySelected;
	Spinner facilitiesType;
	Spinner location;
	
	public FacilitiesFragment(){
		final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	        return inflater.inflate(R.layout.fragment_facilities, container, false);
	 }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		btnSelectDate=(Button)getView().findViewById(R.id.facilities_button_date);
		btnSelectDate.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
		
		btnSelectDate.setOnClickListener(this);
		
		facilitiesType = (Spinner)getView().findViewById(R.id.facilities_type);
		location = (Spinner)getView().findViewById(R.id.facilities_location);

		
		searchFacilities=(Button) getView().findViewById(R.id.facilities_search);
		searchFacilities.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				FacilitiesSearchActivity.facilityTypeVal = 	facilitiesType.getSelectedItem().toString();
				FacilitiesSearchActivity.locationVal = 	location.getSelectedItem().toString();
				FacilitiesSearchActivity.dateVal = btnSelectDate.getText().toString();
				
				Intent intent = new Intent(getActivity(),FacilitiesSearchActivity.class);
				startActivity(intent);
			}
		});
			 
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
	               btnSelectDate.setText(+day+"/"+(month+1)+"/"+year);
	            }
	     	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Dialog dialog = new DatePickerDialog(getActivity(),mDateSetListener, mYear, mMonth, mDay);
    	dialog.show();
	}	
	
}
