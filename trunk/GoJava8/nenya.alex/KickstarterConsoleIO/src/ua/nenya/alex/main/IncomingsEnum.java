package ua.nenya.alex.main;

import ua.nenya.alex.project.GetNameInterface;

public enum IncomingsEnum implements GetNameInterface{
	GUEST("Guest"), 
	REGISTERED_USER("Registered user"), 
	REGISTRATION("Registration");
	
	private String name;
	
	IncomingsEnum(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
