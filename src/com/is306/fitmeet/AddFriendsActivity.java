package com.is306.fitmeet;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.is306.fitmeet.R;

public class AddFriendsActivity extends Activity {
	
	TextView noRecommendation;
	TextView noSearchResults;
	ListView recommendedListView;
	ListView searchResults;
	
	ArrayAdapter<String> adapterRecommend;
	ArrayAdapter<String> searchRslt;
	
	ArrayList<String> recommendedFriends = UsersDAO.friendsAsString(UsersDAO.recommendedUserPool);
	Activity activity = this;
	/*String[] recommendedFriends = new String[]{		
	};*/
	
	ArrayList<String> searchedResults = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_friends);
		noRecommendation = (TextView)this.findViewById(R.id.no_recommended_results);
		noSearchResults = (TextView)this.findViewById(R.id.no_search_results);
		// Show the Up button in the action bar.
		setupActionBar();
		
		if(recommendedFriends.size()==0){
			noRecommendation.setText("No recommendations found");
		}else{
			noRecommendation.setText("");
			recommendedListView = (ListView) this.findViewById(R.id.recommended_list);
			adapterRecommend = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, recommendedFriends);
			recommendedListView.setAdapter(adapterRecommend);
			recommendedListView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					UsersDAO.friendChosen = UsersDAO.recommendedUserPool.get(position);
					Intent newActivity = new Intent(activity, AddFriendProfileActivity.class);     
			        startActivity(newActivity);
				}
			});
		}
		
		if(searchedResults.size()==0){
			noSearchResults.setText("No results found");
		}else{
			noSearchResults.setText("");
			searchResults = (ListView) this.findViewById(R.id.searched_list);
			searchRslt = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, searchedResults);
			searchResults.setAdapter(searchRslt);
			searchResults.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					UsersDAO.friendChosen = UsersDAO.recommendedUserPool.get(position);
					Intent newActivity = new Intent(activity, AddFriendProfileActivity.class);     
			        startActivity(newActivity);
				}
			});
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
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
