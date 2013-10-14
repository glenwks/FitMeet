package com.is306.fitmeet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.is306.fitmeet.R;


public class CalendarFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
			setHasOptionsMenu(true);
	        return inflater.inflate(R.layout.fragment_calendar, container, false);
	}
	
}
