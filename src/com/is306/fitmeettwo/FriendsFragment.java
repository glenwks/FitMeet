package com.is306.fitmeettwo;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FriendsFragment extends ListFragment{
	
	String friendsList[] = new String[]{
	        "John Tan",
	        "Sue May",
	        "KES",
	        "Fariq",
	        "Kellie",
	        "Ben",
	        "Me",
	        "Roger",
	        "Tim",
	        "Yous",
	        "Sihui",
	        "Gan",
	        "Lucas",
	        "Rachel",
	        "Some",
	        "One"
	    };
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
			setHasOptionsMenu(true);
			/** Creating array adapter to set data in listview */
        	ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, friendsList);
        	/** Setting the array adapter to the listview */
            setListAdapter(adapter);
        	// Inflate the layout for this fragment
            return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
    public void onStart() {
        super.onStart();
 
        /** Setting the multiselect choice mode for the listview */
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }


}