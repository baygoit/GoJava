package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.comments.ProjectComment;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.user.DBUserService;
import dao.user.DefaultUserService;
import dao.user.User;
import dao.user.UserService;

public class UserImpl implements Model {

	private Object parameter;
	private List<String> usersNames;

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		if (name.equals("userName")) {
			User user = (User) parameter;
			user = getUserService().getUserInfo(user.getLogin(),
					user.getPassword());
			return user;
		}
		if (name.equals("listUsersNames")) {
			UserService userService = getUserService();
			@SuppressWarnings("unchecked")
			List<ProjectComment> comments = (List<ProjectComment>) parameter;
			usersNames = userService.getUsersNamesByListComments(comments);
			return usersNames;
		}
		return null;
	}

	private UserService getUserService() throws KickstarterException {
		UserService userService;
		if (parameter == null) {
			throw new KickstarterException("attribute parameter  has null");
		}
		if (connected()) {
			userService = new DBUserService();
		} else {
			userService = new DefaultUserService();
		}
		return userService;
	}
	boolean connected() {
		boolean connected = false;
		try {
			Connection conn = Pool.getInstance().getConnection();
			conn.close();
			connected = true;
		} catch (KickstarterException | SQLException e) {
			
		}
		return connected;
	}
	@Override
	public void setParameters(Object parameter) {
		this.parameter = parameter;
	}

}
