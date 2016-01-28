package ua.com.goit.gojava7.kickstarter.domain;

public class User {

	private String name = "UNKNOWN";
	private String password = "UNKNOWN";

	public User() {

	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
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
}
