package ua.com.goit.gojava7.kickstarter.model;

public class User {

	private String name;
	private int password;

	public User(String name, int password) {
		this.name = name;
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPassword(int password) {
		this.password = password;
	}
	
	public int getPassword() {
		return password;
	}
}
