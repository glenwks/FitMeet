package com.is306.fitmeet;

import java.util.ArrayList;

public class User {
	
	private String username;
	private String password;
	private String name;
	private String gender;
	private int age;
	private ArrayList<String> hobbies;
	
	public User(){}
	
	public User(String username, String password, String name,  String gender, int age, ArrayList<String> hobbies){
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.hobbies = hobbies;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getHobbiesAsString(){
		
		String hobbiesAsString="";
		for(int i=0; i<hobbies.size();i++){
			if(i==0){
				hobbiesAsString = hobbies.get(i);
			}else{
				hobbiesAsString = hobbiesAsString+", "+ hobbies.get(i);
			}
		}
		return hobbiesAsString;
	}

}
