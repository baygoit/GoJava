package ua.goit.web.model.dao;

import java.util.ArrayList;
import java.util.List;


public class MemoryUserDao  {
	private User user;
	List<User> users;

	public MemoryUserDao() {

		users = new ArrayList<User>();

		user = new User();
		user.setID(9);
		user.setName("Mike");
		user.setLogin("user");
		user.setPassword("pass");
		users.add(user);

		user = new User();
		user.setID(5);
		user.setName("Anonymous");
		user.setLogin("user");
		user.setPassword("guest");
		users.add(user);
	}

	public User getUserInfo(String login, String password)
			throws KickstarterException {
		if (login.equals(users.get(0).getLogin())
				&& password.equals(users.get(0).getPassword())) {
			return user;
		}
		throw new KickstarterException("user not found");
	}

	public List<String> getUsersNamesByListComments(
			List<Comment> comments) throws KickstarterException {
		List<String> userNames = new ArrayList<String>();
		if (comments == null) {
			return null;
		}
		for (Comment currentComment : comments) {
			for (User currentUser : users) {
				if (currentUser.getID() == (currentComment.getUserID())) {
					userNames.add(currentUser.getName());
				}
			}
		}
		if (userNames.size() == 0) {
			throw new KickstarterException("users not found");
		}
		return userNames;
	}
}
