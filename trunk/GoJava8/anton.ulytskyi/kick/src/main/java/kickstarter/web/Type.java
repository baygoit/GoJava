package kickstarter.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import kickstarter.manager.Manager;

public class Type extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Manager operator = new Manager();

		String type = req.getQueryString();
		HashMap<Integer, String> projects = operator.getAllProjectsByCategory(type);

		req.setAttribute("type", type);
		req.setAttribute("projects", projects);
		req.getRequestDispatcher("Type.jsp").forward(req, resp);

	}
}