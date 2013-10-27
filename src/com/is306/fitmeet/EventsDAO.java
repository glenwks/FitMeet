package com.is306.fitmeet;

import java.util.ArrayList;

public class EventsDAO {
	static ArrayList<Event> eventPool = new ArrayList<Event>();
	
	static Event currentEvent = new Event();
	
	public static ArrayList<String> eventAsString(){
		ArrayList<String> eventConvertString = new ArrayList<String>();
		String value="";
		Event event = new Event();
		for(int i=0; i<eventPool.size(); i++){
			event = eventPool.get(i); 
			value = event.getDate() + " " +event.getTitle()+ " @ "+event.getStartTime();
			eventConvertString.add(value);
		}
		
		return eventConvertString;
	}
}
