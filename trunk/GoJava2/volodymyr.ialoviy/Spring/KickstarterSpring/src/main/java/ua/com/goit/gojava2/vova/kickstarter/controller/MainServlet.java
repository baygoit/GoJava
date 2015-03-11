package ua.com.goit.gojava2.vova.kickstarter.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;

public class MainServlet extends HttpServlet {
	
	@Autowired
	private Categories categoriesDAO;
	
	@Autowired
	private Projects projectsDAO;

	private Map<String, Action> actions;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		actions.put("categories", new CategoriesAction(categoriesDAO));
		actions.put("projects", new ProjectsAction(projectsDAO));
		actions.put("project", new projectAction(projectsDAO));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Action action = getAction(req);
		String jsp = action.doIt(req, resp);
		req.getRequestDispatcher(jsp).forward(req, resp);
	}

	private Action getAction(HttpServletRequest req) {
		return actions.get(getActionString(req));
	}

	private String getActionString(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		return requestURI.substring(req.getContextPath().length(), requestURI.length());
	}
}
