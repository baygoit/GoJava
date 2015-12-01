package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.model.Category;

/**
 * Servlet implementation class CategoriesServlet
 */
@WebServlet("/categories")
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CategoryDao categoryDao;
    public DaoProvider daoProvider;
    @Override
	public void init() throws ServletException{
		daoProvider = new DaoProvider(DataSource.MEMORY);
		categoryDao = daoProvider.getCategoryDao();
	}
	

    public CategoriesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Categoriese</title></head><body>");
	

		for (Category category : categoryDao.getAll()) {
			stringBuilder.append("<a href=\"category?id=" + category.getCategoryId() + "\">" + category.getCategoryName() + "</a><br/>");

		}

		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
