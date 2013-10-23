package com.is306.fitmeet;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
//import android.support.v4.app.NavUtils;
import android.widget.TextView;

public class FacilitiesSearchActivity extends Activity {
	
	static String facilityTypeVal = "";
	static String locationVal = "";
	static String dateVal = "";
	
	TextView facilityType, location, date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facilities_search);
		// Show the Up button in the action bar.
		setupActionBar();
		
		facilityType = (TextView)this.findViewById(R.id.facilities_search_type_value);
		facilityType.setText(facilityTypeVal);
		
		location = (TextView)this.findViewById(R.id.facilities_search_location_value);
		location.setText(locationVal);
		
		date = (TextView)this.findViewById(R.id.facilities_search_date_value);
		date.setText(dateVal);
		
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
		getMenuInflater().inflate(R.menu.facilities_search, menu);
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
			//NavUtils.navigateUpFromSameTask(this);
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
