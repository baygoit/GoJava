package site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOProject;

import java.io.IOException;
import java.util.List;

public class Categories extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			DAOProject base = new DAOProject();

			List<String> categories = base.getCategories();

			req.setAttribute("categories", categories);
			req.getRequestDispatcher("Categories.jsp").forward(req, resp);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}