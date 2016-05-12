package kickstarter.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import kickstarter.manager.Manager;

public class Categories extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Manager operator = new Manager();

		List<String> categories = operator.getAllCategories();

		req.setAttribute("categories", categories);
		req.getRequestDispatcher("Categories.jsp").forward(req, resp);

	}

}