package ua.com.goit.gojava7.kickstarter.servlet;

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

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CategoriesServlet.class);
	
	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void init() throws ServletException {
		log.info("Starting Spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended Spring autowiring...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doGet");
		Quote quote = quoteDao.getRandomQuote();
		log.debug("Random quote: {}", quote);
		
		List<Category> categories = categoryDao.getCategories();
		log.debug("Categories: {}", categories);
		
		Category bestCategory = categoryDao.getBestCategory();
		log.debug("bestCategory: {}", bestCategory);
		categories.add(bestCategory);
		
		req.setAttribute("quote", quote);
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(req, resp);
		log.info("Ended doGet");
	}
	
}
