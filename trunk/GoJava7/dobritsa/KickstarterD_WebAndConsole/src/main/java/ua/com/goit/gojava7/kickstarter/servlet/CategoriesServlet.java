package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@WebServlet("/")
public class CategoriesServlet extends HttpServlet {

	private DaoFactory daoFactory;
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;	

	@Override
	public void init(){		
	//public void init(ServletConfig config){		
		//try {
		//	super.init(config);
		//} catch (ServletException e) {			
		//	e.printStackTrace();
		//}
		//ServletContext context = getServletContext();
		//String 	mode = context.getInitParameter("mode");				
		//MyDataSource dataType = MyDataSource.getByKey(mode.toUpperCase());
		//context.setAttribute("mode", dataType);
		//System.out.println("-----------------------------");
		//System.out.println("CategoriesServlet started in  " + dataType + " mode (" + mode + ")");
		//System.out.println("-----------------------------");
		//daoFactory = new DaoFactory(dataType);

		daoFactory = new DaoFactory(MyDataSource.DB);
		quoteDao = daoFactory.getQuoteDAO();
		categoryDao = daoFactory.getCategoryDAO();		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setAttribute("quote", quoteDao.get(1));
		request.setAttribute("categories", categoryDao.getAll());
		request.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(request, response);			
	}

}
