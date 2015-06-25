package beans;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pool.KickstarterException;
import dao.user.DBUserService;
import dao.user.DefaultUserService;
import dao.user.User;
import dao.user.UserService;

public class Login extends DatabaseConnectionChecker implements iBean {

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

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		// TODO Auto-generated method stub

	}
}
