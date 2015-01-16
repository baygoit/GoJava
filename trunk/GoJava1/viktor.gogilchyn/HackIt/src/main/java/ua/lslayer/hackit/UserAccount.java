package ua.lslayer.hackit;

public class UserAccount {
	private String login;
	private String password;
	private boolean loggedIn;
	private Hero hero;

	public static UserAccount registerUserAccount(String login, String password) {
		// TODO make an account creation mechanism
		// Some mess with database to make an account
		return null;
	}
	
	public static UserAccount getAccount (String login, String password) {
		//TODO Here I should find a way to load an account from database
		return null;
	}

	public UserAccount(String login, String password) {
		this.login = login;
		this.password = password;
		this.hero = null;
		this.loggedIn = false;

	}

	public void changePassword() {
		// TODO make an password change mechanism
	}

	public boolean login(String login, String password) {
		this.loggedIn = ((this.login.equals(login)) && 
						 (this.password.equals(password)));
		if (this.loggedIn) this.loadProgress();
		return this.loggedIn;
	}

	public void logOut() {
		this.loggedIn = false;
		this.saveProgress();
	}

	public Hero getHero() {
		return this.hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public boolean loggedIn() {
		return this.loggedIn;
	}

	private void saveProgress() {
		// Here I will save account data to database
	}

	private void loadProgress() {
		// Here I will load account data from database
	}

}
