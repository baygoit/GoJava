package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

/**
 * Servlet implementation class MainServlet
 */

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Autowired
    private CategoryDatabaseDao categoryStorage;
	@Autowired
    private ProjectDatabaseDao projectStorage;
	@Autowired
    private QuoteDatabaseDao quoteStorage;
	
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = getAction(request);
		
		if(action.startsWith("/categories")){
		    List<Category> categories = categoryStorage.getAll();
		    request.setAttribute("categories", categories);
		    request.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(request, response);
		    
		}else if(action.startsWith("/projects")){
		    response.getWriter().append("projects");
		    
		}else{
		    request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}
	}

	private String getAction(HttpServletRequest request) {
	    String requestURI = request.getRequestURI();
	    String action = requestURI.substring(request.getContextPath().length(),requestURI.length());
	    return action;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
