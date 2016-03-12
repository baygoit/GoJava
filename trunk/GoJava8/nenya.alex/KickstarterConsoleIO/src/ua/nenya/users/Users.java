package ua.nenya.users;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;



public class Users {

	private List<User> users = new ArrayList<>();
	private String fileName = "src/resources/users.txt";

	public List<User> getUsers() {
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		List<User> usersList = new ArrayList<>();
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));) {
			usersList = (List<User>) input.readObject();
			User userZero = new User("a","a","a@a.ua");
			if(usersList.isEmpty()){
				usersList.add(userZero);
			}
			for (User it : usersList) {
				users.add(it);
			}

		} catch (Exception e) {
			return;
		}

	 }
}
