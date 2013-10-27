package com.is306.fitmeet;

import java.util.ArrayList;

public class UsersDAO {
	static ArrayList<User> loginUserPool = new ArrayList<User>();
	static ArrayList<User> recommendedUserPool = new ArrayList<User>();
	static ArrayList<User> friendsUserPool = new ArrayList<User>();
	
	static User currentUser;
	static User friendChosen;
	
	public UsersDAO(){
		
		
	}
	
	public static ArrayList<String> friendsAsString(ArrayList<User> friendsList){
		ArrayList<String> friendsConvertString = new ArrayList<String>();
		String name = "";
		for(int i = 0; i<friendsList.size();i++){
			name = friendsList.get(i).getName() + " ( "+ friendsList.get(i).getUsername()+" )";
			friendsConvertString.add(name);
		}
		return friendsConvertString;
	}
	
	public static void recommendedUserList(String username){
		for(int i = 0; i<loginUserPool.size();i++){
			if(!loginUserPool.get(i).getUsername().equals(username)){
				recommendedUserPool.add(loginUserPool.get(i));
			}
		}
	}
	
	public static void addFriendToList(User user){
		for(int i = 0; i<recommendedUserPool.size();i++){
			if(recommendedUserPool.get(i).getUsername().equals(user.getUsername())){
				recommendedUserPool.remove(i);
				friendsUserPool.add(user);
			}
		}
	}
	
}
