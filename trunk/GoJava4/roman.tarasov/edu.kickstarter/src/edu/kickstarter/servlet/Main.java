package edu.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.kickstarter.DAO.Dao;


/**
 * Servlet implementation class Main
 */

@WebServlet("/Main")
public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("Main.jsp").forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		Dao.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}