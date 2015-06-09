package web.kickstarter.servlet;

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

import web.kickstarter.Dao.categoryService.CategoryService;
import web.kickstarter.Dao.categoryService.DBcategoryServiceImpl;
import web.kickstarter.Dao.categoryService.DefaultCategoryService;
import web.kickstarter.databaseDao.DatabaseService;
import web.kickstarter.databaseDao.DatabaseServiceImpl;
import web.kickstarter.entity.Category;

/**
 * Servlet implementation class Categories
 */

@WebServlet("/Categories")
public class Categories extends HttpServlet {
	
	private DatabaseService databaseService;
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private CategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(5);
		response.setContentType("text/plain");
		out = response.getWriter();
		out.println("<h2>Button Clicked</h2>");
		try {
			List<Category>categories=categoryService.getAll();
			for(Category category:categories){
				out.println(category.getName());
			}

		} catch (SQLException e) {
			out.println("database exception");
			e.printStackTrace();
		}
		out.close();
	}

	@Override
	public void init() throws ServletException {
		
		databaseService = new DatabaseServiceImpl();
		//categoryService=new DBcategoryServiceImpl(databaseService);
		categoryService=new DefaultCategoryService(databaseService);
		try {
			databaseService.createConnection();
		} catch (Exception e) {
			getServletContext().log("An exception occurred in Categories", e);
			throw new ServletException("An exception occurred in Categories"
					+ e.getMessage());
		}
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