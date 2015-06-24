package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.user.DBUserService;
import dao.user.DefaultUserService;
import dao.user.User;
import dao.user.UserService;

public class LoginDao implements iModel {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		UserService userService = null;

		if (connected()) {
			userService = new DBUserService();
		} else {
			userService = new DefaultUserService();
		}

		User modelOfUser = new User();
		User user = null;

		modelOfUser.setLogin(request.getParameter("login"));
		modelOfUser.setPassword(request.getParameter("pwd"));

		try {
			user = userService.getUserInfo(modelOfUser.getLogin(),
					modelOfUser.getPassword());
			request.getSession().setAttribute("userName", user.getName());
			request.getSession().setAttribute("user", user);
		} catch (KickstarterException e) {
			request.getSession().setAttribute("userName", null);
			request.getSession().setAttribute("user", null);

		}

		try {
			response.sendRedirect("DetailedProject");
		} catch (IOException e) {
		}
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
}
