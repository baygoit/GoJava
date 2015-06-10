package edu.kickstarter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kickstarter.Dao.categoryService.CategoryService;
import edu.kickstarter.Dao.quoteService.Dao;
import edu.kickstarter.Dao.quoteService.Dao;

/**
 * Servlet implementation class Projects
 */
@WebServlet("/Projects")
public class Projects extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private CategoryService categoryService;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Projects() {
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
		request.getRequestDispatcher("ProjectsByCategory.jsp").forward(request,
				response);

		/*
		 * response.setContentType("text/plain"); out = response.getWriter();
		 * response.setContentType("text / html;charset=UTF-8");
		 * out.println("<title>kickstarter.edu</title>");
		 * out.println(request.getRequestURL().toString());
		 */
	}

	@Override
	public void init() throws ServletException {
		 Dao.getInstance();
	}
}
