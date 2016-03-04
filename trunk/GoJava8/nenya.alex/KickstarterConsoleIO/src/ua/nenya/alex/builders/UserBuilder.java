package ua.nenya.alex.builders;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import ua.nenya.alex.users.User;

public class UserBuilder {
	User user;

	
	public User getUser() {
		return user;
	}

	public UserBuilder() {
		this.user = new User();
	}

	@SuppressWarnings("unchecked")
	public void createAll(String fileName) {
		List<User> usersList = new ArrayList<>();
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));) {
			usersList = (List<User>) input.readObject();
			User userZero = new User("a","a","a@a.ua");
			if(usersList.isEmpty()){
				usersList.add(userZero);
			}
			for (User it : usersList) {
				user.getUsersList().add(it);
			}

		} catch (Exception e) {
			return;
		}

	}

}
