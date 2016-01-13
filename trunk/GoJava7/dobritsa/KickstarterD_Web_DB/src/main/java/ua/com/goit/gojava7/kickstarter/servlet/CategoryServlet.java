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
import ua.com.goit.gojava7.kickstarter.models.Category;

@WebServlet("/projectsOld")
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CategoryServlet.class);

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		log.info("Starting spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended spring autowiring...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.info("doGet()...");
		
		Long categoryId = Long.parseLong(request.getParameter("id"));

		Category category = categoryDao.get(categoryId);

		request.setAttribute("categoryName", category.getName());
		request.setAttribute("projects", categoryDao.getProjects(categoryId));
		request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);
	}
}
