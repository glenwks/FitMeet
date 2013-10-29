package com.is306.fitmeet;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class SearchFriendActivity extends Activity {
	ListView lv;
	TextView tv;
	Activity activity = this;
	
	ArrayList<String> searchList = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_friend);
		// Show the Up button in the action bar.
		setupActionBar();
		// Get the intent, verify the action and get the query
		
	    Intent intent = getIntent();
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	      String query = intent.getStringExtra(SearchManager.QUERY);
	      doMySearch(query);
	    }
	}

	private void doMySearch(String query) {
		// TODO Auto-generated method stub
		UsersDAO.searchFriendList(query);
		searchList = UsersDAO.friendsAsString(UsersDAO.searchUserPool);
		lv = (ListView) findViewById(R.id.search_friends_list);
		tv = (TextView) findViewById(R.id.no_search_results_search);
		if(searchList.size()==0){
			tv.setText("No search results found.");
		}else{
			tv.setText("");
		}
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, searchList);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				UsersDAO.friendChosen = UsersDAO.searchUserPool.get(position);
				Intent newActivity = new Intent(activity, AddFriendProfileActivity.class);     
		        startActivity(newActivity);
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
		getMenuInflater().inflate(R.menu.search_friend, menu);
		// Get the SearchView and set the searchable configuration
	    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
	    SearchView searchView = (SearchView) menu.findItem(R.id.action_search_friends_search).getActionView();
	    // Assumes current activity is the searchable activity
	    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
	    searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
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
