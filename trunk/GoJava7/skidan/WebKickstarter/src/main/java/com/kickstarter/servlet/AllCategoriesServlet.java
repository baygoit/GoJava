package com.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kickstarter.dao.interfaces.DbCategoryDaoImpl;
import com.kickstarter.dao.interfaces.DbQuoteImpl;
import com.kickstarter.model.Category;
import com.kickstarter.model.Quote;

@WebServlet("/AllCategoriesServlet")
public class AllCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	DbCategoryDaoImpl categoryDao;
	
	
	DbQuoteImpl quoteDao;

	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		quoteDao = (DbQuoteImpl) context.getBean("DbQuoteImpl");
		categoryDao = (DbCategoryDaoImpl) context.getBean("DbCategoryDaoImpl");
		
		//		quoteDao = new DbQuoteImpl();
//		categoryDao = new DbCategoryDaoImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Quote quote = quoteDao.get();
		List<Category> categoryList = categoryDao.getAll();

		request.setAttribute("quote", quote);
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher("/WEB-INF/AllCategories.jsp").forward(request, response);

		// StringBuilder stringBuilder = new
		// StringBuilder("<html><head><title>Categories</title></head><body>");
		// stringBuilder.append("<b>" + quote.getQuoteText() + " (c) " +
		// quote.getAuthor()+ "</b>" + "<br>");
		//
		// for (Category category : categoryList) {
		// stringBuilder.append("<a href=
		// \"SelectedCategoryProjectsServlet?categoryTitle=" +
		// category.getTitle() + "\">" + category.getTitle() + "</a><br/>");
		//// http://localhost:8080/KickstarterWeb/
		//// <a href="http://www.w3schools.com">This is a link</a>
		// }
		// stringBuilder.append("</body> </html>");
		// response.getWriter().append(stringBuilder);
	}

}
