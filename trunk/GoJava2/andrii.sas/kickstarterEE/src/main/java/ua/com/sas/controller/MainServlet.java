package ua.com.sas.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.dao.ProjectsDAO;
//import ua.com.sas.model.*;

@Controller
public class MainServlet extends HttpServlet {

	@Autowired
	private CategoriesDAO categoriesDAO;
	
	@Autowired
	private ProjectsDAO projectsDAO;
	
	Map<String, Action> actions = new HashMap<String, Action>();
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		CategoriesAction categoriesAction = new CategoriesAction(categoriesDAO);
		actions.put("/", categoriesAction);
		actions.put("/categories", categoriesAction);
		actions.put("/projects", new ProjectsAction(projectsDAO));
		actions.put("/project", new ProjectAction(projectsDAO));
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Action action = actions.get(getActionString(req));
		String jsp = action.getJsp(req, resp);
		req.getRequestDispatcher(jsp).forward(req, resp);
	}

	private String getActionString(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		return requestURI.substring(req.getContextPath().length(), requestURI.length());
	}
}
