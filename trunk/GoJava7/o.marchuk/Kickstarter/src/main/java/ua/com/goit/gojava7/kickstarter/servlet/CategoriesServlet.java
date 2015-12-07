package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DaoProvider daoProvider;

	private QuoteDao quoteDao;
	private CategoryDao categoryDao;

	protected WebApplicationContext applicationContext;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		daoProvider = (DaoProvider) applicationContext.getBean("daoProvider");
		daoProvider.open();
		super.init(config);
	}

	@Override
	public void init() throws ServletException {
		quoteDao = daoProvider.getQuoteDao();
		categoryDao = daoProvider.getCategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("quote", quoteDao.getRandomQuote());
		req.setAttribute("categories", categoryDao.getAll());
		req.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		daoProvider.close();
	}

}
