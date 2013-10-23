package com.is306.fitmeet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class FriendsFragment extends ListFragment{
	
	ListView listView;
	EditText inputSearch;
	ArrayAdapter<String> adapter;
	private boolean haveFriends = true;
	
	String friendsList[] = new String[]{
	        "John Tan",
	        "Sue May",
	        "KES",
	        "Fariq",
	        "Kellie",
	        "Roger",
	        "Tim",
	        "Yous",
	        "Sihui",
	        "Lucas",
	        "Rachel"
	    };
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
			setHasOptionsMenu(true);
			
			if(friendsList.length == 0){
				haveFriends=false;
				return inflater.inflate(R.layout.fragment_no_friends, container, false);
			}else{
				haveFriends=true;
			}
        	// Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_friends, container, false);
	}
	
	@Override
    public void onStart() {
        super.onStart();
 
        /** Setting the multiselect choice mode for the listview */
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		
		super.onActivityCreated(savedInstanceState);
		
		if(haveFriends==true){
			listView = (ListView)getActivity().findViewById(android.R.id.list);
			/** Creating array adapter to set data in listview */
	    	adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, friendsList);
	    	inputSearch = (EditText) getActivity().findViewById(R.id.inputSearch);
	    	
	    	/** Setting the array adapter to the listview */
	        listView.setAdapter(adapter);
	        
			inputSearch.addTextChangedListener(new TextWatcher() {
	            
	            @Override
	            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
	                // When user changed the Text
	                FriendsFragment.this.adapter.getFilter().filter(cs);  
	            }
	             
	            @Override
	            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
	                    int arg3) {
	                // TODO Auto-generated method stub
	                 
	            }
	             
	            @Override
	            public void afterTextChanged(Editable arg0) {
	                // TODO Auto-generated method stub                         
	            }
	        });
		}
		
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// do something with the data
		Intent newActivity = new Intent(getActivity(), FriendProfileActivity.class);     
        startActivity(newActivity);
		/*switch( position )
	    	{
		       case 0:  
		    	   newActivity = new Intent(getActivity(), FriendProfileActivity.class);     
		           startActivity(newActivity);
		           break;
		       case 1:  
		    	   newActivity = new Intent(getActivity(), FriendProfileActivity.class);     
	               startActivity(newActivity);
	               break;
		       case 2:  
		    	   newActivity = new Intent(getActivity(), FriendProfileActivity.class);     
		           startActivity(newActivity);
		           break;
		       case 3: 
		    	   newActivity = new Intent(getActivity(), FriendProfileActivity.class);     
		           startActivity(newActivity);
		           break;
		       case 4:  
		    	   newActivity = new Intent(getActivity(), FriendProfileActivity.class);     
		           startActivity(newActivity);
		           break;
		    }*/
	}


}