package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;

@WebServlet("/top10")
public class Top10Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Top10Categories.class);

	@Autowired
	private CategoryDao categoryDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet");

		List<Object[]> top10Categories = categoryDao.getTop10Categories();
		log.info("Top 10 categories : " + top10Categories);

		List<Category> categories = categoryDao.getAll();
		log.info("All categories : " + categories);

		request.setAttribute("top10Categories", top10Categories);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("WEB-INF/pages/top10categories.jsp").forward(request, response);
	}
}
