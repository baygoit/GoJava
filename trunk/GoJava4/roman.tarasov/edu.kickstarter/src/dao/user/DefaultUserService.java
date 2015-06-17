package dao.user;

import dao.pool.KickstarterException;

public class DefaultUserService implements UserService {
	private User user;

	public DefaultUserService() {
		user = new User();
		user.setName("mike");
		user.setLogin("user");
		user.setPassword("pass");
	}

	@Override
	public User getUserInfo(String login, String password)throws KickstarterException {
		if (login.equals(user.getLogin())
				&& password.equals(user.getPassword())) {
			return user;
		}
		throw new KickstarterException("user not found");
	}
}
