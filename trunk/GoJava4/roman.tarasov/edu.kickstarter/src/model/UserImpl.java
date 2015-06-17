package model;

import java.sql.Connection;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.user.DBUserService;
import dao.user.DefaultUserService;
import dao.user.User;
import dao.user.UserService;

public class UserImpl implements Model {
	private User user;

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		if (name.equals("userName")) {
			UserService userService;
			try {
				Connection conn = Pool.getInstance().getConnection();
				userService = new DBUserService(conn);
			} catch (KickstarterException e1) {
				userService = new DefaultUserService();
			}
			if (user == null) {
				throw new KickstarterException(
						"attribute parameter for user has null");
			}
			user = userService.getUserInfo(user.getLogin(), user.getPassword());
			return user;
		}
		return null;
	}

	@Override
	public void setParameters(Object parameter) {
		user = (User) parameter;
	}
}
