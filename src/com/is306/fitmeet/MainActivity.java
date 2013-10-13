package com.is306.fitmeet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import com.is306.fitmeet.R;
 
public class MainActivity extends FragmentActivity {
    TabHost tHost;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        tHost = (TabHost) findViewById(android.R.id.tabhost);
        tHost.setup();
 
        /** Defining Tab Change Listener event. This is invoked when tab is changed */
        TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
 
            @Override
            public void onTabChanged(String tabId) {
                android.support.v4.app.FragmentManager fm =   getSupportFragmentManager();
                CalendarFragment calendarFragment = (CalendarFragment) fm.findFragmentByTag("calendar");
                PlanFragment planFragment = (PlanFragment) fm.findFragmentByTag("plan");
                FacilitiesFragment facilitiesFragment = (FacilitiesFragment) fm.findFragmentByTag("facilities");
                FriendsFragment friendsFragment = (FriendsFragment) fm.findFragmentByTag("friends");
                SettingsFragment settingsFragment = (SettingsFragment) fm.findFragmentByTag("settings");
                
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
 
                /** Detaches the calendarFragment if exists */
                if(calendarFragment!=null)
                    ft.detach(calendarFragment);
 
                /** Detaches the planFragment if exists */
                if(planFragment!=null)
                    ft.detach(planFragment);
                
                /** Detaches the facilitiesFragment if exists */
                if(facilitiesFragment!=null)
                    ft.detach(facilitiesFragment);
                
                /** Detaches the friendsFragment if exists */
                if(friendsFragment!=null)
                    ft.detach(friendsFragment);
                
                /** Detaches the planFragment if exists */
                if(settingsFragment!=null)
                    ft.detach(settingsFragment);
 
                /** If current tab is calendar */
                if(tabId.equalsIgnoreCase("calendar")){
                	setTitle("Calendar");
                    if(calendarFragment==null){
                        /** Create CalendarFragment and adding to fragmenttransaction */
                        ft.add(R.id.realtabcontent,new CalendarFragment(), "calendar");
                    }else{
                        /** Bring to the front, if already exists in the fragmenttransaction */
                        ft.attach(calendarFragment);
                    }
                    
                }else if(tabId.equalsIgnoreCase("plan")){
                	setTitle("Plan");
                	if(planFragment==null){
                        /** Create PlanFragment and adding to fragmenttransaction */
                        ft.add(R.id.realtabcontent,new PlanFragment(), "plan");
                    }else{
                        /** Bring to the front, if already exists in the fragmenttransaction */
                        ft.attach(planFragment);
                    }
                	
                }else if(tabId.equalsIgnoreCase("facilities")){
                	setTitle("Facilities");
                	if(facilitiesFragment==null){
                        /** Create FacilitiesFragment and adding to fragmenttransaction */
                        ft.add(R.id.realtabcontent,new FacilitiesFragment(), "facilities");
                    }else{
                        /** Bring to the front, if already exists in the fragmenttransaction */
                        ft.attach(facilitiesFragment);
                    }
                	
                }else if(tabId.equalsIgnoreCase("friends")){
                	setTitle("Friends");
                	if(friendsFragment==null){
                        /** Create FriendsFragment and adding to fragmenttransaction */
                        ft.add(R.id.realtabcontent,new FriendsFragment(), "friends");
                    }else{
                        /** Bring to the front, if already exists in the fragmenttransaction */
                        ft.attach(friendsFragment);
                    }
                	
                }else if(tabId.equalsIgnoreCase("settings")){    /** If current tab is apple */
                	setTitle("Settings");
                    if(settingsFragment==null){
                        /** Create SettingsFragment and adding to fragmenttransaction */
                        ft.add(R.id.realtabcontent,new SettingsFragment(), "settings");
                     }else{
                        /** Bring to the front, if already exists in the fragmenttransaction */
                        ft.attach(settingsFragment);
                    }
                }else{
                	setTitle("Fit Meet");
                }
                ft.commit();
            }
        };
 
        /** Setting tabchangelistener for the tab */
        tHost.setOnTabChangedListener(tabChangeListener);
 
        /** Defining tab builder for Calendar tab */
        TabHost.TabSpec tSpecCalendar = tHost.newTabSpec("calendar");
        tSpecCalendar.setIndicator("",getResources().getDrawable(R.drawable.icon_calendar));
        tSpecCalendar.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecCalendar);
 
        /** Defining tab builder for Plan tab */
        TabHost.TabSpec tSpecPlan = tHost.newTabSpec("plan");
        tSpecPlan.setIndicator("",getResources().getDrawable(R.drawable.icon_plan));
        tSpecPlan.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecPlan);
        
        /** Defining tab builder for Facilities tab */
        TabHost.TabSpec tSpecFacilities = tHost.newTabSpec("facilities");
        tSpecFacilities.setIndicator("",getResources().getDrawable(R.drawable.icon_facilities));
        tSpecFacilities.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecFacilities);
        
        /** Defining tab builder for Friends tab */
        TabHost.TabSpec tSpecFriends = tHost.newTabSpec("friends");
        tSpecFriends.setIndicator("",getResources().getDrawable(R.drawable.icon_friends));
        tSpecFriends.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecFriends);
        
        /** Defining tab builder for Settings tab */
        TabHost.TabSpec tSpecSettings = tHost.newTabSpec("settings");
        tSpecSettings.setIndicator("",getResources().getDrawable(R.drawable.icon_settings));
        tSpecSettings.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecSettings);
 
    }
    
	@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        MenuInflater inflater = getMenuInflater();
        int currentTab = tHost.getCurrentTab();
        if (currentTab == 0){
            menu.clear();
            inflater.inflate(R.menu.calendar, menu);
        }
        else if(currentTab == 1){
            menu.clear();
            inflater.inflate(R.menu.plan, menu);}
        else if(currentTab == 2){
        	menu.clear();
        	inflater.inflate(R.menu.facilities, menu);}
        else if(currentTab == 3){
        	menu.clear();
        	inflater.inflate(R.menu.friends, menu);}
        else{
        	menu.clear();
        	inflater.inflate(R.menu.settings, menu);}
        return super.onPrepareOptionsMenu(menu);
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_add_event:
	        	//setContentView(R.layout.activity_create_event);
	        	startActivity(new Intent(getApplicationContext(), CreateEventActivity.class));
	        	return true;
	        case R.id.action_add_friends:
	        	startActivity(new Intent(getApplicationContext(), AddFriendsActivity.class));
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	

	public void faqPage(View view){
		Intent intent = new Intent(this, FAQActivity.class);
		startActivity(intent);
	}
	
	public void aboutPage(View view){
		Intent intent = new Intent(this, AboutActivity.class);
		startActivity(intent);
	}
	
	public void profileSettings(View view){
		
	}
	
	public void logoutProcess(View view){
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		
	}
}
