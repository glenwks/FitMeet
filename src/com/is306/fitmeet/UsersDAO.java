package com.is306.fitmeet;

import java.util.ArrayList;

public class UsersDAO {
	static ArrayList<User> loginUserPool = new ArrayList<User>();
	static ArrayList<User> recommendedUserPool = new ArrayList<User>();
	static ArrayList<User> friendsUserPool = new ArrayList<User>();
	
	ArrayList<String> hobbiesList;
	
	public UsersDAO(){
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Tennis");
		loginUserPool.add(new User("admin", "", "Adminstrator", "Male", 24, hobbiesList));
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Basketball");
		hobbiesList.add("Running");
		hobbiesList.add("Badminton");
		
		loginUserPool.add(new User("alexL","pass1234","Alex Lin", "Male", 27, hobbiesList));
		
		hobbiesList = new ArrayList<String>();
		hobbiesList.add("Basketball");
		loginUserPool.add(new User("jakeL","pass1234","Jake Low", "Male", 27, hobbiesList));
		
	}
	
	
}
