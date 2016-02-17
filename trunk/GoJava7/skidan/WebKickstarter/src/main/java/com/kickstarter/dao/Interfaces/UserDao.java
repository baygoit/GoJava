package com.kickstarter.dao.Interfaces;

import java.util.List;

import com.kickstarter.model.User;

public interface UserDao {

	public void addUser(User user);
	public void editUser(User user);
	public void deleteUser(int userId);
	public User getUser(int userId);
	public User getUserByName(String userName);
	public List<User> getUserList();


	
	
}
