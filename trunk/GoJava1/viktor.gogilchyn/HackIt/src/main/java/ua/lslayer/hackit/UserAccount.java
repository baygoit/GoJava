package ua.lslayer.hackit;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement (name = "user_account")
public class UserAccount {
	private String login;
	private String password;
	@XmlTransient
	private boolean loggedIn;
	private Hero hero;
	
	public UserAccount() {
		
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Your new login is " + login + ", password is " + password;
	}

	@XmlTransient
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	

}
