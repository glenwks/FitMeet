package com.is306.fitmeet;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
//import android.support.v4.app.NavUtils;
import com.is306.fitmeet.R;

public class AddFriendsActivity extends Activity {
	
	TextView noRecommendation;
	TextView noSearchResults;
	ListView recommendedListView;
	ListView searchResults;
	ArrayAdapter<String> adapterRecommend;
	ArrayAdapter<String> searchRslt;
	
	String[] recommendedFriends = new String[]{
			"test",
			"test1",
			"test2",
			"test3"			
	};
	
	ArrayList<String> searchedResults = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_friends);
		noRecommendation = (TextView)this.findViewById(R.id.no_recommended_results);
		noSearchResults = (TextView)this.findViewById(R.id.no_search_results);
		// Show the Up button in the action bar.
		setupActionBar();
		
		if(recommendedFriends.length==0){
			noRecommendation.setText("No recommendations found");
		}else{
			noRecommendation.setText("");
			recommendedListView = (ListView) this.findViewById(R.id.recommended_list);
			adapterRecommend = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, recommendedFriends);
			recommendedListView.setAdapter(adapterRecommend);
		}
		
		if(searchedResults.size()==0){
			noSearchResults.setText("No results found");
		}else{
			noSearchResults.setText("");
			searchResults = (ListView) this.findViewById(R.id.searched_list);
			searchRslt = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, searchedResults);
			searchResults.setAdapter(searchRslt);
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
		getMenuInflater().inflate(R.menu.add_friends, menu);
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
