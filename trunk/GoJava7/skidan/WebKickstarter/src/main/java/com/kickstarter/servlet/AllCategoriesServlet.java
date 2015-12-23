package com.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.kickstarter.dao.interfaces.DbCategoryDaoImpl;
import com.kickstarter.dao.interfaces.DbQuoteImpl;
import com.kickstarter.model.Category;
import com.kickstarter.model.Quote;

@WebServlet("/AllCategoriesServlet")
public class AllCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	DbCategoryDaoImpl categoryDao;

	@Autowired
	DbQuoteImpl quoteDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("ApplicationContext.xml");
		// quoteDao = (DbQuoteImpl) context.getBean("DbQuoteImpl");
		// categoryDao = (DbCategoryDaoImpl)
		// context.getBean("DbCategoryDaoImpl");

		// quoteDao = new DbQuoteImpl();
		// categoryDao = new DbCategoryDaoImpl();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Quote quote = quoteDao.get();
		List<Category> categoryList = categoryDao.getAll();

		request.setAttribute("quote", quote);
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/WEB-INF/AllCategories.jsp").forward(request, response);

		
	}

}
