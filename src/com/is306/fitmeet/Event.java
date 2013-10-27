package com.is306.fitmeet;

public class Event {
	private String title;
	private String location;
	private String friends;
	
	private String date;
	private String startTime;
	private String endTime;
	
	private boolean remindMe;
	private boolean remindFriend;

	private String notes;
	
	public Event(){
		
	}
	
	public Event(String title, String location, String friends, String date, String startTime, String endTime, boolean remindMe, boolean remindFriend, String notes){
		this.title = title;
		this.location=location;
		this.friends= friends;
		this.date =date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.remindMe =remindMe;
		this.remindFriend=remindFriend;
		this.notes=notes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public boolean isRemindMe() {
		return remindMe;
	}

	public void setRemindMe(boolean remindMe) {
		this.remindMe = remindMe;
	}

	public boolean isRemindFriend() {
		return remindFriend;
	}

	public void setRemindFriend(boolean remindFriend) {
		this.remindFriend = remindFriend;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
}
