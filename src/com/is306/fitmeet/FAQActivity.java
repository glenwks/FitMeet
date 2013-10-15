package com.is306.fitmeet;

import java.util.ArrayList;
import android.os.Bundle;
//import android.app.Activity;
import android.app.ExpandableListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;
//import android.support.v4.app.NavUtils;


public class FAQActivity extends ExpandableListActivity {
	
	private ArrayList<String> parentItems = new ArrayList<String>();
	private ArrayList<Object> childItems = new ArrayList<Object>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faq);
		// Show the Up button in the action bar.
		setupActionBar();
		ExpandableListView expandableList = getExpandableListView();
		
		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);	 
		setGroupParents();
		setChildData();
			 
		MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);
		
		adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
		expandableList.setAdapter(adapter);
		expandableList.setOnChildClickListener(this);
		
		
	}
	
	public void setGroupParents() {
		parentItems.add("How do I use this app?");
		parentItems.add("What is this app for?");
		parentItems.add("How do I add friends?");
		parentItems.add("How do I create an event?");
		
	}
	
	public void setChildData() {
		ArrayList<String> child = new ArrayList<String>();
		child.add("Just use it as you like =D!");
		childItems.add(child);
		child = new ArrayList<String>();
		child.add("Is for you to schedule meetings and find friends to play with.");
		childItems.add(child);
		child = new ArrayList<String>();
		child.add("Go to friends and click on the icon in the action bar to add.");
		childItems.add(child);
		child = new ArrayList<String>();
		child.add("In calendar, go to the action bar and click the create event icon.");
		childItems.add(child);
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
		getMenuInflater().inflate(R.menu.faq, menu);
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

}
