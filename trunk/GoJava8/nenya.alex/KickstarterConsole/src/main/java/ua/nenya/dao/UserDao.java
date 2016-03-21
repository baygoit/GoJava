package ua.nenya.dao;

import java.util.List;

import ua.nenya.project.User;

public interface UserDao {

	void initUsers();

	List<User> getUsers();

}
