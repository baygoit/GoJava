package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;

@WebServlet("/categories")
public class CategoriesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CategoryStorage categoryStorage;
	private DataSource dataSource = DataSource.MEMORY;
	private DaoFactory daoFactory = new DaoFactory(dataSource);
	@Override
	public void init() throws ServletException {
		categoryStorage = daoFactory.getCategoryStorage();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html><head><title>Categories</title></head><body>");
		stringBuilder.append("Categories:<br>");
		categoryStorage.getAll().forEach(category -> {
			stringBuilder.append("<a href=\"category?id=" + category.getCategoryId() + "\">" + category.getCategoryName() + "</a><br/>");
		});
		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);
		response.getWriter().append("Served quoteStorage: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
