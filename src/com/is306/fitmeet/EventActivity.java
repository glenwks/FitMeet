package com.is306.fitmeet;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class EventActivity extends Activity {
	
	TextView title, location, friends, date, startTime, endTime, notes, remindMe, remindFriends;
	Event event = EventsDAO.currentEvent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		// Show the Up button in the action bar.
		setupActionBar();
		title =(TextView)findViewById(R.id.event_view_title);
		title.setText(event.getTitle());
		location =(TextView)findViewById(R.id.event_view_location);
		location.setText(event.getLocation());
		friends =(TextView)findViewById(R.id.event_view_friend);
		friends.setText(event.getFriends());
		date =(TextView)findViewById(R.id.event_view_date);
		date.setText(event.getDate());
		startTime =(TextView)findViewById(R.id.event_view_start_time);
		startTime.setText(event.getStartTime());
		endTime=(TextView)findViewById(R.id.event_view_end_time);
		endTime.setText(event.getEndTime());
		notes =(TextView)findViewById(R.id.event_view_notes);
		notes.setText(event.getNotes());
		remindMe =(TextView)findViewById(R.id.event_view_remind_me_val);
		if(event.isRemindMe()){
			remindMe.setText("Yes");
		}else{
			remindMe.setText("No");
		}
		remindFriends =(TextView)findViewById(R.id.event_view_remind_friend_val);
		if(event.isRemindFriend()){
			remindFriends.setText("Yes");
		}else{
			remindFriends.setText("No");
		}
		
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
		getMenuInflater().inflate(R.menu.event, menu);
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

}
