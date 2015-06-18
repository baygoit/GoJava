package dao.user;

import java.util.ArrayList;
import java.util.List;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;

public class DefaultUserService implements UserService {
	private User user;
	List<User> users;

	public DefaultUserService() {

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

	@Override
	public User getUserInfo(String login, String password)
			throws KickstarterException {
		if (login.equals(users.get(0).getLogin())
				&& password.equals(users.get(0).getPassword())) {
			return user;
		}
		throw new KickstarterException("user not found");
	}

	@Override
	public List<String> getUsersNamesByListComments(
			List<ProjectComment> comments) throws KickstarterException {
		List<String> userNames = new ArrayList<String>();

		for (ProjectComment currentComment : comments) {
			for (User currentUser : users) {
				if (currentUser.getID() == (currentComment.getUserID())) {
					userNames.add(currentUser.getName());
				}
			}
		}
		if(userNames.size()==0){
			throw new KickstarterException("users not found");
		}
		return userNames;
	}
}
