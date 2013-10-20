package com.is306.fitmeet;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.is306.fitmeet.R;


public class CalendarFragment extends Fragment{
	
	ListView lv;
	ArrayList<String> eventsList2 = new ArrayList<String>();
	String[] eventsList = new String[]{
			"17/10/2013 Basketball @ 7:00pm",
	        "23/10/2013 Badminton @ 9:00pm",
	        "27/10/2013 Futsal @ 8:00pm",
	        "30/10/2013 Tennis @ 6:00pm",
	        "10/11/2013 Squash @ 10:00pm",
	        "test test"
	};
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
			setHasOptionsMenu(true);
	        return inflater.inflate(R.layout.fragment_calendar, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		lv = (ListView) getView().findViewById(R.id.events_list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, eventsList);
	    lv.setAdapter(adapter);
		
	}
	
	
	
}
