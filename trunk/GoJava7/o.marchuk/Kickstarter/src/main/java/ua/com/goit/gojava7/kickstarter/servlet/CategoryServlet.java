package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@WebServlet(urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(CategoryServlet.class);

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		log.debug("Starting spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.debug("Ended spring autowiring...");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long categoryId = null;

		try {
			categoryId = Long.valueOf(request.getParameter("id"));
		} catch (NumberFormatException e) {
			log.error("Cannot parse category id {}", request.getParameter("id"));
		}

		Category category = categoryDao.get(categoryId);
		log.debug("Category: {}", category);
		log.debug("Category projects: {}", category.getProjects());

		request.setAttribute("category", category);
		request.getRequestDispatcher("/WEB-INF/jsp/category.jsp").forward(request, response);
	}
}
