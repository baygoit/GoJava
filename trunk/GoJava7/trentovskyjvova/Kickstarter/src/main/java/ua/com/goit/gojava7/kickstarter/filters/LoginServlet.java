package ua.com.goit.gojava7.kickstarter.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.goit.gojava7.kickstarter.domain.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Map<String, User> users = getUsers();

	private static Map<String, User> getUsers() {
		Map<String, User> users = new HashMap();

		User userOne = new User("one", "one");
		User userTwo = new User("two", "TWO");

		users.put(userOne.getName(), userOne);
		users.put(userTwo.getName(), userTwo);

		return users;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd;
		String name = req.getParameter("name");
		String password = req.getParameter("password");

		User user = validateLogin(name, password);

		if (user == null) {
			rd = req.getRequestDispatcher("/WEB-INF/jsp/loginError.jsp");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			rd = req.getRequestDispatcher("/WEB-INF/jsp/successLogin.jsp");
		}

		rd.forward(req, res);
	}

	private User validateLogin(String name, String password) {

		if (name == null || password == null) {
			return null;
		}

		User user = users.get(name);

		if (user == null) {
			return null;
		}

		if (!user.getPassword().equals(password.trim())) {
			return null;
		}

		return user;
	}
}