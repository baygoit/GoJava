package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.db.CategoryDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.ProjectDatabaseDao;
import ua.com.goit.gojava7.kickstarter.dao.db.QuoteDatabaseDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

/**
 * Servlet implementation class MainServlet
 */

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(MainServlet.class); 
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
        LOGGER.log(Level.INFO,"Kickstarter Servlet init");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = getAction(request);
		
		if(action.startsWith("/categories")){ // All categories
		    List<Category> categories = categoryStorage.getAll();
		  
		    request.setAttribute("categories", categories);
		    request.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(request, response);
		    
		}else if(action.startsWith("/category")){ // All projects in specific category
            int categoryId = Integer.parseInt(request.getParameter("id"));
            List<Project> projects = projectStorage.getAll().stream().filter( p -> p.getProjectCategoryId() == categoryId).collect(Collectors.toList());
            request.setAttribute("projects", projects);
            request.setAttribute("categoryName", categoryStorage.getCategoryById(categoryId).getCategoryName());
            request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);
        }
		else if(action.startsWith("/project")){
		    String projectName = request.getParameter("name");
		    Project project = null;
		    try{
		        project = projectStorage.getProjectByName(projectName);
		    }catch(NoSuchElementException e){
              LOGGER.info("Didn't find project",e);
          }
		    if(project != null){
		    request.setAttribute("project", project);
		    }else{
		        request.setAttribute("notfound",true);
		    }
		    request.getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);
		}
		else if(action.startsWith("/projects")){
		    List<Project> projects = projectStorage.getAll();
		    request.setAttribute("projects", projects);
		    request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);
		    
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
