package ua.com.goit.gojava.alexfurman.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava.alexfurman.kickstarter.entity.User;

public interface UserDAO {
	public List<User> list();
}
