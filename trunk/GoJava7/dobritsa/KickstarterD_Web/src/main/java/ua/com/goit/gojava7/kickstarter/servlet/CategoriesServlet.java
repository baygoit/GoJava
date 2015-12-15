package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDbDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDbDao;

@WebServlet("/")
public class CategoriesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private QuoteDbDao quoteDao;
	
	@Autowired
	private CategoryDbDao categoryDao;	
	
	protected WebApplicationContext applicationContext;

	@Override
	public void init() throws ServletException {			
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {				
		request.setAttribute("quote", quoteDao.get(1));
		request.setAttribute("categories", categoryDao.getAll());
		request.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(request, response);			
	}
}
