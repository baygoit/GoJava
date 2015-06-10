package edu.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;
import edu.kickstarter.Dao.categoryService.CategoryService;
import edu.kickstarter.Dao.categoryService.DefaultCategoryServiceImpl;
import edu.kickstarter.Dao.quoteService.DefaultQuoteServiceImpl;
import edu.kickstarter.Dao.quoteService.QuoteService;
import edu.kickstarter.databaseDao.DatabaseService;
import edu.kickstarter.entity.Category;

/**
 * Servlet implementation class Categories
 */

@WebServlet("/Categories")
public class Categories extends HttpServlet {

	private DatabaseService databaseService;
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private CategoryService categoryService;
	private QuoteService quoteService;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(5);
		response.setContentType("text/plain");
		out = response.getWriter();
		response.setContentType("text / html;charset=UTF-8");

		out.println("<title>kickstarter.edu</title>");
		// out.println("<header><a href='/'><img src='' alt='Kickstarter logo'></a></header>");
		try {
			out.println(quoteService.getRandomQuote().getQuote());
			out.println("<table border = 1>");
			List<Category> categories = categoryService.getAll();
			for (Category currentCategory : categories) {
				out.println("<tr>");
				out.println("<td>" + currentCategory.getName() + "</td>");
				out.println("</tr >");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

	@Override
	public void init() throws ServletException {
		databaseService = DatabaseService.getInstance();
		categoryService = new DefaultCategoryServiceImpl();
		quoteService = new DefaultQuoteServiceImpl();
		// categoryService=new DBcategoryServiceImpl();
		// quoteService = new DBquoteService();
	}

	@Override
	public void destroy() {
		super.destroy();
		try {
			databaseService.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}