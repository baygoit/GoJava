package ua.com.goit.gojava7.kickstarter.model;

public class User {
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(UserSettings settings) {
		super();
		this.settings = settings;
	}

	private UserSettings settings;

	public UserSettings getSettings() {
		return settings;
	}

	public void setSettings(UserSettings settings) {
		this.settings = settings;
	}

}
