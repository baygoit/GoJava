package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pool.KickstarterException;
import dao.user.User;
import model.Model;
import model.UserImpl;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Model getUserName = new UserImpl();
		User modelOfUser = new User();
		User user = null;
		modelOfUser.setLogin(request.getParameter("login"));
		modelOfUser.setPassword(request.getParameter("pwd"));
		getUserName.setParameters(modelOfUser);
		try {
			user = (User) getUserName.getAttribute("userName");
		} catch (KickstarterException e) {
			request.getSession().setAttribute("userName", null);
			response.sendRedirect("/edu.kickstarter/DetailedProject");
			return;
		}
		request.getSession().setAttribute("userName", user.getName());
		response.sendRedirect("/edu.kickstarter/DetailedProject");
	}
}
